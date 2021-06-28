package com.kirito666.niitnews.ui.news;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.kirito666.niitnews.entity.News;
import com.kirito666.niitnews.entity.base.BaseResponse;
import com.kirito666.niitnews.entity.base.HttpStatusCode;
import com.kirito666.niitnews.entity.dto.NewsPageData;
import com.kirito666.niitnews.net.APIService;
import com.kirito666.niitnews.net.retrofit.RetrofitClient;

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
 * @FileName:NewsPageViewModel.java
 * @LastModified:2021/06/29 02:16:29
 */

public class NewsPageViewModel extends ViewModel implements LifecycleObserver {
    private final APIService mRepository = RetrofitClient.getInstance().getApi();
    public MutableLiveData<List<News>> news;
    private final int newsGroupId;

    public NewsPageViewModel(int newsGroupId) {
        this.newsGroupId = newsGroupId;
        if (news == null) {
            news = new MutableLiveData<>();
            news.setValue(new ArrayList<>());
        } else {
            if (news.getValue() != null) {
                news.getValue().clear();
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void fetchNews() {
        fetchNews(1, 10);
    }

    public void fetchNews(int pageId, int pageSize) {
        mRepository.fetchNewsPage(pageId, pageSize, newsGroupId).enqueue(new Callback<BaseResponse<NewsPageData>>() {
            @Override
            public void onResponse(@NotNull Call<BaseResponse<NewsPageData>> call, @NotNull Response<BaseResponse<NewsPageData>> response) {
                if (response.body().getStatusCode() == HttpStatusCode.SUCCESS.getStatus()) {
                    List<News> diffNews = news.getValue();
                    if (pageId == 1) {
                        diffNews.clear();
                    }
                    diffNews.addAll(response.body().getData().getNewsData());
                    news.setValue(diffNews);
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<NewsPageData>> call, Throwable t) {

            }
        });
    }

    public void search() {

    }
}
