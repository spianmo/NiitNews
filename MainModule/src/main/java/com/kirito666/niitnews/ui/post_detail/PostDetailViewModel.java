package com.kirito666.niitnews.ui.post_detail;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.kirito666.niitnews.entity.base.BaseResponse;
import com.kirito666.niitnews.entity.base.HttpStatusCode;
import com.kirito666.niitnews.entity.dto.PostDto;
import com.kirito666.niitnews.net.APIService;
import com.kirito666.niitnews.net.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:PostDetailViewModel.java
 * @LastModified:2021/06/29 10:37:29
 */

public class PostDetailViewModel extends ViewModel implements LifecycleObserver {
    private final APIService mRepository = RetrofitClient.getInstance().getApi();
    public MutableLiveData<PostDto> post;
    private final int pid;

    public PostDetailViewModel(int pid) {
        this.pid = pid;
        if (post == null) {
            post = new MutableLiveData<>();
            post.setValue(new PostDto());
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void getPostDetail() {
        mRepository.postDetail(pid).enqueue(new Callback<BaseResponse<PostDto>>() {
            @Override
            public void onResponse(Call<BaseResponse<PostDto>> call, Response<BaseResponse<PostDto>> response) {
                if (response.body().getStatusCode() == HttpStatusCode.SUCCESS.getStatus()) {
                    post.setValue(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<PostDto>> call, Throwable t) {

            }
        });
    }

}