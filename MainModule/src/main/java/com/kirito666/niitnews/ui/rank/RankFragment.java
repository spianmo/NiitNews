package com.kirito666.niitnews.ui.rank;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.kirito666.niitnews.R;
import com.kirito666.niitnews.databinding.FragmentRankBinding;
import com.kirito666.niitnews.entity.Rank;
import com.kirito666.niitnews.ui.rank.adapter.RankListAdapter;
import com.kirshi.framework.databinding.DataBindingConfig;
import com.kirshi.framework.databinding.DataBindingFragment;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Shinonon
 * @FileName:RankFragment.java
 * @LastModified:2021/06/22 14:04:22
 */

public class RankFragment extends DataBindingFragment<FragmentRankBinding> {
    private RankPageViewModel mRankPageViewModel;
    private RankListAdapter mAdapter;
    private final boolean isPost;

    public RankFragment(boolean isPost) {
        this.isPost = isPost;
    }

    @Override
    protected void initViewModel() {
        mRankPageViewModel = new RankPageViewModel(isPost);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_rank, BR.vm, mRankPageViewModel)
                .addBindingParam(BR.click, new RankFragment.ClickProxy());
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        v.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        v.recyclerView.setHasFixedSize(true);
        mAdapter = new RankListAdapter(getContext(), mRankPageViewModel.ranks.getValue(), R.layout.item_news_light);
        mAdapter.setOnItemClickListener(new RankListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Rank rank, int position) {
                // TODO: 6/22/2021 热搜榜点击事件
            }
        });
        //((SimpleItemAnimator)v.recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        //v.recyclerView.getItemAnimator().setChangeDuration(0);
        v.recyclerView.setAdapter(mAdapter);
        mRankPageViewModel.ranks.observe(getViewLifecycleOwner(), new Observer<List<Rank>>() {
            @Override
            public void onChanged(List<Rank> ranks) {
                mAdapter.notifyDataSetChanged();
                v.refreshLayout.setRefreshing(false);
            }
        });
        mRankPageViewModel.fetchRank();
        v.refreshLayout.setColorSchemeResources(R.color.google_blue,
                R.color.google_green, R.color.google_yellow,
                R.color.google_red);
        v.refreshLayout.setDistanceToTriggerSync(300);
        v.refreshLayout.setProgressBackgroundColorSchemeColor(Color.WHITE);
        v.refreshLayout.setOnRefreshListener(() -> {
            v.refreshLayout.setRefreshing(true);
            if (v != null) {
                mRankPageViewModel.fetchRank();
            }
        });
    }

    public static class ClickProxy implements Toolbar.OnMenuItemClickListener {

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            return true;
        }
    }
}
