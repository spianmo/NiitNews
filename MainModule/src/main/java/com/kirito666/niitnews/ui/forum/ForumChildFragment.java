package com.kirito666.niitnews.ui.forum;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kirito666.niitnews.R;
import com.kirito666.niitnews.databinding.FragmentForumChildBinding;
import com.kirito666.niitnews.entity.dto.SimplePost;
import com.kirito666.niitnews.ui.forum.adapter.PostsListAdapter;
import com.kirito666.niitnews.ui.news.adapter.NewsListAdapter;
import com.kirshi.framework.databinding.BaseBindingFragment;
import com.kirshi.framework.databinding.DataBindingConfig;

import org.jetbrains.annotations.NotNull;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:ForumChildFragment.java
 * @LastModified:2021/06/28 10:26:28
 */

public class ForumChildFragment extends BaseBindingFragment<FragmentForumChildBinding> {
    private ForumPageViewModel mForumPageViewModel;
    private final boolean isPublic;
    private PostsListAdapter mAdapter;

    public ForumChildFragment(boolean isPublic) {
        this.isPublic = isPublic;
    }

    @Override
    protected void initViewModel() {
        mForumPageViewModel = new ForumPageViewModel(isPublic);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_forum_child, BR.vm, mForumPageViewModel)
                .addBindingParam(BR.click, new ForumChildFragment.ClickProxy());
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getLifecycle().addObserver(mForumPageViewModel);
        v.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        v.recyclerView.setHasFixedSize(true);
        mAdapter = new PostsListAdapter(getContext(), mForumPageViewModel.posts.getValue(), R.layout.item_posts_light);
        mAdapter.setOnItemClickListener(new PostsListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, SimplePost post, int position) {
                // TODO: 6/28/2021 Simple帖子点击事件，跳转帖子详情页
            }
        });

        v.recyclerView.setAdapter(mAdapter);
        mForumPageViewModel.posts.observe(getViewLifecycleOwner(), posts -> {
            Log.e("=============>", "第" + pageId + "页，" + posts.size());
            mAdapter.notifyDataSetChanged();
            v.refreshLayout.setRefreshing(false);
        });

        v.refreshLayout.setColorSchemeResources(R.color.google_blue,
                R.color.google_green, R.color.google_yellow,
                R.color.google_red);
        v.refreshLayout.setDistanceToTriggerSync(300);
        v.refreshLayout.setProgressBackgroundColorSchemeColor(Color.WHITE);
        v.refreshLayout.setOnRefreshListener(() -> {
            v.refreshLayout.setRefreshing(true);
            if (v != null) {
                mForumPageViewModel.fetchPost();
            }
        });
        initLoadMoreListener();
    }

    public static class ClickProxy implements Toolbar.OnMenuItemClickListener {

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            return true;
        }
    }

    private int pageId = 1;

    private void initLoadMoreListener() {
        v.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int lastVisibleItem;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                //判断RecyclerView的状态 是空闲时，同时，是最后一个可见的ITEM时才加载
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == mAdapter.getItemCount()) {
                    mAdapter.changeMoreStatus(NewsListAdapter.LOADING_MORE);
                    mForumPageViewModel.fetchPost(++pageId, 10);
                }
            }

            @Override
            public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                lastVisibleItem = layoutManager.findLastVisibleItemPosition();
            }
        });

    }
}
