package com.kirito666.niitnews.ui.rank;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kirito666.niitnews.entity.Rank;
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
 * @FileName:RankPageViewModel.java
 * @LastModified:2021/06/22 14:08:22
 */

public class RankPageViewModel extends ViewModel {
    private final APIService mRepository = RetrofitClient.getInstance().getApi();
    public MutableLiveData<List<Rank>> ranks;
    private final boolean isPost;

    public RankPageViewModel(boolean isPost) {
        this.isPost = isPost;
        if (ranks == null) {
            ranks = new MutableLiveData<>();
            ranks.setValue(new ArrayList<>());
        } else {
            if (ranks.getValue() != null) {
                ranks.getValue().clear();
            }
        }
    }

    public void fetchRank() {
        Call<BaseResponse<List<Rank>>> call = isPost ? mRepository.fetchPostsRank() : mRepository.fetchNewsRank();
        call.enqueue(new Callback<BaseResponse<List<Rank>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<Rank>>> call, Response<BaseResponse<List<Rank>>> response) {
                if (response.body().getStatusCode() == HttpStatusCode.SUCCESS.getStatus()) {
                    List<Rank> diffRanks = ranks.getValue();
                    diffRanks.clear();
                    diffRanks.addAll(response.body().getData());
                    ranks.setValue(diffRanks);
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<Rank>>> call, Throwable t) {

            }
        });
    }

    public void search() {

    }
}
