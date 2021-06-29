package com.kirito666.niitnews.ui.posts;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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
import com.kirito666.niitnews.entity.RepositoryCallback;
import com.kirito666.niitnews.entity.base.HttpStatusCode;
import com.kirito666.niitnews.entity.dto.SimplePost;
import com.kirito666.niitnews.ui.empty.EmptyEntity;
import com.kirito666.niitnews.ui.news.adapter.NewsListAdapter;
import com.kirito666.niitnews.ui.post_detail.PostDetailPage;
import com.kirito666.niitnews.ui.posts.adapter.PostsListAdapter;
import com.kirito666.niitnews.util.Tools;
import com.kirshi.framework.databinding.BaseBindingFragment;
import com.kirshi.framework.databinding.DataBindingConfig;

import org.jetbrains.annotations.NotNull;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:ForumChildFragment.java
 * @LastModified:2021/06/29 13:49:29
 */

public class ForumChildFragment extends BaseBindingFragment<FragmentForumChildBinding> {
    private ForumPageViewModel mForumPageViewModel;
    private final boolean isPublic;
    private PostsListAdapter mAdapter;
    public final EmptyEntity emptyEntity;

    public ForumChildFragment(boolean isPublic, EmptyEntity emptyEntity) {
        this.isPublic = isPublic;
        this.emptyEntity = emptyEntity;
    }

    @Override
    protected void initViewModel() {
        mForumPageViewModel = new ForumPageViewModel(isPublic, emptyEntity);
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
        mAdapter = new PostsListAdapter(this, mForumPageViewModel.posts.getValue());
        mAdapter.setOnItemClickListener(new PostsListAdapter.OnItemClickListener() {
            @Override
            public void onShare(String title, String detail) {
                Tools.share(mActivity, title, detail);
            }

            @Override
            public void onForward(SimplePost post) {
                mForumPageViewModel.forwardPost((int) post.getPid(), new RepositoryCallback<String>() {
                    @Override
                    public void onSuccess(String data) {
                        post.setShareCount(post.getShareCount() + 1);
                        mAdapter.notifyDataSetChanged();
                        showSnackBar("转发成功");
                    }

                    @Override
                    public void onFailure(HttpStatusCode code) {
                        showSnackBar("转发失败");
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        showSnackBar(throwable.toString());
                    }
                });
            }

            @Override
            public void onFavor(int pid, PostsListAdapter.OnFavorResult callback) {
                mForumPageViewModel.favorPost(pid, new RepositoryCallback<String>() {
                    @Override
                    public void onSuccess(String data) {
                        callback.onSuccess();
                    }

                    @Override
                    public void onFailure(HttpStatusCode code) {
                        showSnackBar("点赞失败");
                        callback.onFailure();
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        showSnackBar(throwable.toString());
                        callback.onFailure();
                    }
                });
            }

            @Override
            public void onFavorCancel(int pid, PostsListAdapter.OnFavorResult callback) {
                mForumPageViewModel.deleteFavor(pid, new RepositoryCallback<String>() {
                    @Override
                    public void onSuccess(String data) {
                        callback.onSuccess();
                    }

                    @Override
                    public void onFailure(HttpStatusCode code) {
                        callback.onFailure();
                        showSnackBar("取消点赞失败");
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        callback.onFailure();
                        showSnackBar(throwable.toString());
                    }
                });
            }

            @Override
            public void onCommit(SimplePost post, boolean allow) {
                if (!allow) {
                    showSnackBar("该动态不允许评论");
                } else {
                    onItemClick(post);
                }
            }

            @Override
            public void onItemClick(SimplePost post) {
                Intent intent = new Intent(mActivity, PostDetailPage.class);
                intent.putExtra("post", post);
                startActivity(intent);
            }
        });

        v.recyclerView.setAdapter(mAdapter);
        mForumPageViewModel.posts.observe(getViewLifecycleOwner(), posts -> {
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
