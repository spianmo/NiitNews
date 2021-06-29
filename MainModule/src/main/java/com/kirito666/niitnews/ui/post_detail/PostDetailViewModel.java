package com.kirito666.niitnews.ui.post_detail;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.kirito666.niitnews.App;
import com.kirito666.niitnews.entity.Commit;
import com.kirito666.niitnews.entity.RepositoryCallback;
import com.kirito666.niitnews.entity.base.BaseResponse;
import com.kirito666.niitnews.entity.base.HttpStatusCode;
import com.kirito666.niitnews.entity.dto.PostDto;
import com.kirito666.niitnews.net.APIService;
import com.kirito666.niitnews.net.retrofit.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:PostDetailViewModel.java
 * @LastModified:2021/06/30 06:37:30
 */

public class PostDetailViewModel extends ViewModel implements LifecycleObserver {
    private final APIService mRepository = RetrofitClient.getInstance().getApi();
    public MutableLiveData<PostDto> post;
    private final int pid;

    public PostDetailViewModel(int pid) {
        this.pid = pid;
        if (post == null) {
            post = new MutableLiveData<>();
            PostDto postDto = new PostDto();
            postDto.setCommits(new ArrayList<>());
            post.setValue(postDto);
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

    public void deleteCommit(int cid, RepositoryCallback<String> callback) {
        RetrofitClient.getInstance().getApi().deleteCommit(pid, cid).enqueue(new Callback<BaseResponse<String>>() {
            @Override
            public void onResponse(Call<BaseResponse<String>> call, Response<BaseResponse<String>> response) {
                if (response.body().getStatusCode() == HttpStatusCode.SUCCESS.getStatus()) {
                    callback.onSuccess(response.body().getData());
                } else {
                    callback.onFailure(HttpStatusCode.getStatusByCode(response.body().getStatusCode()));
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<String>> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

    public void sendCommit(int parentCid, String text, RepositoryCallback<String> callback) {
        RetrofitClient.getInstance().getApi().sendCommit(pid, Commit.builder()
                .ownerId(App.currentUser.getId())
                .text(text)
                .pid(pid)
                .parentCid(parentCid)
                .build()).enqueue(new Callback<BaseResponse<String>>() {
            @Override
            public void onResponse(Call<BaseResponse<String>> call, Response<BaseResponse<String>> response) {
                Log.e("==========>", response.body().toString());
                if (response.body().getStatusCode() == HttpStatusCode.SUCCESS.getStatus()) {
                    callback.onSuccess(response.body().getData());
                } else {
                    callback.onFailure(HttpStatusCode.getStatusByCode(response.body().getStatusCode()));
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<String>> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

    public void forwardPost(int pid, RepositoryCallback<String> callback) {
        RetrofitClient.getInstance().getApi().forwardPost(pid).enqueue(new Callback<BaseResponse<String>>() {
            @Override
            public void onResponse(Call<BaseResponse<String>> call, Response<BaseResponse<String>> response) {
                if (response.body().getStatusCode() == HttpStatusCode.SUCCESS.getStatus()) {
                    callback.onSuccess(response.body().getData());
                } else {
                    callback.onFailure(HttpStatusCode.getStatusByCode(response.body().getStatusCode()));
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<String>> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

    public void favorPost(int pid, RepositoryCallback<String> callback) {
        RetrofitClient.getInstance().getApi().favorPost(pid).enqueue(new Callback<BaseResponse<String>>() {
            @Override
            public void onResponse(Call<BaseResponse<String>> call, Response<BaseResponse<String>> response) {
                if (response.body().getStatusCode() == HttpStatusCode.SUCCESS.getStatus()) {
                    callback.onSuccess(response.body().getData());
                } else {
                    callback.onFailure(HttpStatusCode.getStatusByCode(response.body().getStatusCode()));
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<String>> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

    public void deleteFavor(int pid, RepositoryCallback<String> callback) {
        RetrofitClient.getInstance().getApi().deleteFavor(pid).enqueue(new Callback<BaseResponse<String>>() {
            @Override
            public void onResponse(Call<BaseResponse<String>> call, Response<BaseResponse<String>> response) {
                if (response.body().getStatusCode() == HttpStatusCode.SUCCESS.getStatus()) {
                    callback.onSuccess(response.body().getData());
                } else {
                    callback.onFailure(HttpStatusCode.getStatusByCode(response.body().getStatusCode()));
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<String>> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

}