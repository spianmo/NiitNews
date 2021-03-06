package com.kirito666.niitnews.ui.rank;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kirito666.niitnews.entity.Banner;
import com.kirito666.niitnews.entity.Rank;
import com.kirito666.niitnews.entity.base.BaseResponse;
import com.kirito666.niitnews.entity.base.HttpStatusCode;
import com.kirito666.niitnews.net.APIService;
import com.kirito666.niitnews.net.retrofit.RetrofitClient;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:RankPageViewModel.java
 * @LastModified:2021/06/23 23:42:23
 */

public class RankPageViewModel extends ViewModel {
    private final APIService mRepository = RetrofitClient.getInstance().getApi();
    public MutableLiveData<List<Rank>> ranks;
    public MutableLiveData<List<Banner>> banners;
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
        if (banners == null) {
            banners = new MutableLiveData<>();
            banners.setValue(new ArrayList<>());
        } else {
            if (banners.getValue() != null) {
                banners.getValue().clear();
            }
        }
    }

    public void fetchBanner() {
        mRepository.getMainBanner(5).enqueue(new Callback<BaseResponse<List<Banner>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<Banner>>> call, Response<BaseResponse<List<Banner>>> response) {
                if (response.body().getStatusCode() == HttpStatusCode.SUCCESS.getStatus()) {
                    List<Banner> diffBanners = banners.getValue();
                    diffBanners.clear();
                    diffBanners.addAll(response.body().getData());
                    banners.setValue(diffBanners);
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<Banner>>> call, Throwable t) {

            }
        });
    }

    public void fetchRank() {
        Timestamp afterTime = new Timestamp(getMonthFirstDay());
        Log.e("=========>", afterTime.toGMTString());
        Call<BaseResponse<List<Rank>>> call = isPost ? mRepository.fetchPostsRank(afterTime) : mRepository.fetchNewsRank(afterTime);
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

    private long getMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -2);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTimeInMillis();
    }
}
