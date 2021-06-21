package com.kirito666.niitnews.ui.search;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kirito666.niitnews.entity.NewsGroup;
import com.kirito666.niitnews.entity.base.BaseResponse;
import com.kirito666.niitnews.entity.base.HttpStatusCode;
import com.kirito666.niitnews.net.APIService;
import com.kirito666.niitnews.net.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:SearchViewModel.java
 * @LastModified:2021/06/21 22:17:21
 */

public class SearchViewModel extends ViewModel {
    private final APIService mRepository = RetrofitClient.getInstance().getApi();
    public MutableLiveData<List<NewsGroup>> newsGroups;
    public final ObservableBoolean isNews = new ObservableBoolean();
    public MutableLiveData<List<NewsGroup>> selectedGroups;

    public SearchViewModel() {
        isNews.set(true);
        if (newsGroups == null) {
            newsGroups = new MutableLiveData<>();
            newsGroups.setValue(new ArrayList<>());
        } else {
            if (newsGroups.getValue() != null) {
                newsGroups.getValue().clear();
            }
        }
    }

    public ObservableBoolean isNews() {
        return isNews;
    }

    public void fetchNewsGroup() {
        mRepository.fetchNewsGroup().enqueue(new Callback<BaseResponse<List<NewsGroup>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<NewsGroup>>> call, Response<BaseResponse<List<NewsGroup>>> response) {
                if (response.body().getStatusCode() == HttpStatusCode.SUCCESS.getStatus()) {
                    newsGroups.setValue(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<NewsGroup>>> call, Throwable t) {

            }
        });
    }

    public void search() {

    }

}