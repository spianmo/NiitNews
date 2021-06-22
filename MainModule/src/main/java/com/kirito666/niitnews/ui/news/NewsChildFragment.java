package com.kirito666.niitnews.ui.news;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.kirito666.niitnews.R;
import com.kirito666.niitnews.databinding.FragmentNewsChildBinding;
import com.kirito666.niitnews.entity.News;
import com.kirito666.niitnews.ui.news.adapter.NewsListAdapter;
import com.kirito666.niitnews.ui.single.NewsDetailPage;
import com.kirito666.niitnews.ui.single.WebPage;
import com.kirshi.framework.databinding.DataBindingConfig;
import com.kirshi.framework.databinding.DataBindingFragment;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:NewsChildFragment.java
 * @LastModified:2021/06/22 10:42:22
 */

public class NewsChildFragment extends DataBindingFragment<FragmentNewsChildBinding> {
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
        v.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        v.recyclerView.setHasFixedSize(true);
        mAdapter = new NewsListAdapter(getContext(), mNewsPageViewModel.news.getValue(), R.layout.item_news_light);
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
        //((SimpleItemAnimator)v.recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        //v.recyclerView.getItemAnimator().setChangeDuration(0);
        v.recyclerView.setAdapter(mAdapter);
        mNewsPageViewModel.news.observe(getViewLifecycleOwner(), new Observer<List<News>>() {
            @Override
            public void onChanged(List<News> news) {
                mAdapter.notifyDataSetChanged();
            }
        });
        mNewsPageViewModel.fetchNews(1, 10);
    }

    public static class ClickProxy implements Toolbar.OnMenuItemClickListener {

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            return true;
        }
    }
}
