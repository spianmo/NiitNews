package com.kirito666.niitnews.ui.news;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.kirito666.niitnews.databinding.FragmentNewsBinding;
import com.kirito666.niitnews.entity.NewsGroup;
import com.kirito666.niitnews.entity.base.BaseResponse;
import com.kirito666.niitnews.entity.base.HttpStatusCode;
import com.kirito666.niitnews.net.retrofit.RetrofitClient;
import com.kirito666.niitnews.ui.news.adapter.NewsPageAdapter;
import com.kirshi.framework.viewbinding.BaseFragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:NewsFragment.java
 * @LastModified:2021/06/29 02:16:29
 */

public class NewsFragment extends BaseFragment<FragmentNewsBinding> {

    NewsPageAdapter newsPageAdapter;
    SparseArray<NewsChildFragment> mNewsChildFragments;

    @Override
    public void inCreateView() {
        mNewsChildFragments = new SparseArray<>();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mNewsChildFragments.size() == 0) {
            RetrofitClient.getInstance().getApi().fetchNewsGroup().enqueue(new Callback<BaseResponse<List<NewsGroup>>>() {
                @Override
                public void onResponse(Call<BaseResponse<List<NewsGroup>>> call, Response<BaseResponse<List<NewsGroup>>> response) {
                    if (response.body().getStatusCode() == HttpStatusCode.SUCCESS.getStatus()) {
                        List<NewsGroup> newsGroups = response.body().getData();
                        List<String> titles = new ArrayList<>();
                        for (NewsGroup newsGroup : newsGroups) {
                            titles.add(newsGroup.getName());
                            mNewsChildFragments.append((int) newsGroup.getId(), new NewsChildFragment(newsGroup.getId()));
                        }
                        newsPageAdapter = new NewsPageAdapter(getChildFragmentManager(), titles, mNewsChildFragments);
                        v.viewPager.setAdapter(newsPageAdapter);
                        v.viewPager.setOffscreenPageLimit(newsPageAdapter.getCount() - 1);
                        v.tabLayout.setupWithViewPager(v.viewPager);
                    }
                }

                @Override
                public void onFailure(Call<BaseResponse<List<NewsGroup>>> call, Throwable t) {

                }
            });
        }
    }
}