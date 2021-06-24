package com.kirito666.niitnews.ui.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kirito666.niitnews.entity.Session;
import com.kirito666.niitnews.entity.User;
import com.kirito666.niitnews.entity.base.BaseResponse;
import com.kirito666.niitnews.entity.base.HttpStatusCode;
import com.kirito666.niitnews.net.jar.SessionJar;
import com.kirito666.niitnews.net.jar.UserJar;
import com.kirito666.niitnews.net.retrofit.RetrofitClient;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:LoginViewModel.java
 * @LastModified:2021/06/24 14:06:24
 */

public class LoginViewModel extends ViewModel {
    MutableLiveData<BaseResponse<User>> loginResponse;

    public LoginViewModel() {
        loginResponse = new MutableLiveData<>();
        loginResponse.setValue(new BaseResponse<>());
    }

    public void login(String account, String password) {
        RetrofitClient.getInstance().getApi().login(account, password).enqueue(new Callback<BaseResponse<User>>() {
            @Override
            public void onResponse(@NotNull Call<BaseResponse<User>> call, @NotNull Response<BaseResponse<User>> response) {
                BaseResponse<User> rawResponse = response.body();
                if (rawResponse.getStatusCode() == HttpStatusCode.SUCCESS.getStatus()) {
                    Session session = new Session(Long.parseLong(response.headers().get("uid")), response.headers().get("superkey"));
                    SessionJar.saveSessionToDisk(session);
                    UserJar.saveToDisk(rawResponse.getData());
                }
                loginResponse.setValue(rawResponse);
            }

            @Override
            public void onFailure(@NotNull Call<BaseResponse<User>> call, @NotNull Throwable t) {

            }
        });
    }
}
