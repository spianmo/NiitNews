package com.kirito666.niitnews.ui.forum;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.kirito666.niitnews.entity.base.BaseResponse;
import com.kirito666.niitnews.entity.base.HttpStatusCode;
import com.kirito666.niitnews.entity.dto.PostPageData;
import com.kirito666.niitnews.entity.dto.SimplePost;
import com.kirito666.niitnews.net.APIService;
import com.kirito666.niitnews.net.retrofit.RetrofitClient;
import com.kirito666.niitnews.ui.empty.EmptyEntity;

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
 * @FileName:ForumPageViewModel.java
 * @LastModified:2021/06/28 14:18:28
 */

public class ForumPageViewModel extends ViewModel implements LifecycleObserver {
    private final APIService mRepository = RetrofitClient.getInstance().getApi();
    public MutableLiveData<List<SimplePost>> posts;
    private final boolean isPublic;
    public final EmptyEntity emptyEntity;

    public ForumPageViewModel(boolean isPublic, EmptyEntity emptyEntity) {
        this.isPublic = isPublic;
        this.emptyEntity = emptyEntity;
        if (posts == null) {
            posts = new MutableLiveData<>();
            posts.setValue(new ArrayList<>());
        } else {
            if (posts.getValue() != null) {
                posts.getValue().clear();
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void fetchPost() {
        fetchPost(1, 10);
    }

    public void fetchPost(int pageId, int pageSize) {
        Call<BaseResponse<PostPageData>> call = isPublic ? mRepository.fetchPost(pageId, pageSize) : mRepository.fetchPostPublic(pageId, pageSize);
        call.enqueue(new Callback<BaseResponse<PostPageData>>() {
            @Override
            public void onResponse(@NotNull Call<BaseResponse<PostPageData>> call, @NotNull Response<BaseResponse<PostPageData>> response) {
                if (response.body().getStatusCode() == HttpStatusCode.SUCCESS.getStatus()) {
                    List<SimplePost> diffPosts = posts.getValue();
                    if (pageId == 1) {
                        diffPosts.clear();
                    }
                    diffPosts.addAll(response.body().getData().getPostData());
                    posts.setValue(diffPosts);
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<PostPageData>> call, Throwable t) {

            }
        });
    }

}
