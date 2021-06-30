package com.kirito666.niitnews.ui.news;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kirito666.niitnews.R;
import com.kirito666.niitnews.databinding.FragmentNewsChildBinding;
import com.kirito666.niitnews.entity.News;
import com.kirito666.niitnews.ui.news.adapter.NewsListAdapter;
import com.kirito666.niitnews.ui.single.NewsDetailPage;
import com.kirito666.niitnews.ui.single.WebPage;
import com.kirshi.framework.databinding.BaseBindingFragment;
import com.kirshi.framework.databinding.DataBindingConfig;

import org.jetbrains.annotations.NotNull;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:NewsChildFragment.java
 * @LastModified:2021/06/30 10:07:30
 */

public class NewsChildFragment extends BaseBindingFragment<FragmentNewsChildBinding> {
    private NewsPageViewModel mNewsPageViewModel;
    private final int newsGroupId;
    private NewsListAdapter mAdapter;

    public NewsChildFragment(long id) {
        this.newsGroupId = (int) id;
    }

    @Override
    protected void initViewModel() {
        mNewsPageViewModel = new NewsPageViewModel(newsGroupId);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_news_child, BR.vm, mNewsPageViewModel)
                .addBindingParam(BR.click, new ClickProxy());
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getLifecycle().addObserver(mNewsPageViewModel);
        v.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        v.recyclerView.setHasFixedSize(true);
        mAdapter = new NewsListAdapter(getContext(), mNewsPageViewModel.news.getValue());
        mAdapter.setOnItemClickListener(new NewsListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, News news, int position) {
                if (TextUtils.isEmpty(news.getContent())) {
                    ///_redirect?siteId=133&columnId=4002&articleId=39723
                    Intent intent = new Intent(mActivity, WebPage.class);
                    intent.putExtra("title", news.getTitle());
                    intent.putExtra("url", "http://news.niit.edu.cn/" + news.getSourceUrl());
                    mActivity.startActivity(intent);
                } else {
                    Intent intent = new Intent(mActivity, NewsDetailPage.class);
                    intent.putExtra("news", news);
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(mActivity, view, "EXTRA_VIEW");
                    //mActivity.startActivity(intent, options.toBundle());
                    mActivity.startActivity(intent);
                }
            }
        });

        v.recyclerView.setAdapter(mAdapter);
        mNewsPageViewModel.news.observe(getViewLifecycleOwner(), news -> {
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
                mNewsPageViewModel.fetchNews();
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

                //判断RecyclerView的状态 是空闲并且是最后一个可见的ITEM时才加载更多数据
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == mAdapter.getItemCount()) {
                    mAdapter.changeMoreStatus(NewsListAdapter.LOADING_MORE);
                    mNewsPageViewModel.fetchNews(++pageId, 10);
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
