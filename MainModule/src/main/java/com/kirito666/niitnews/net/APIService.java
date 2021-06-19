package com.kirito666.niitnews.net;


import androidx.lifecycle.LiveData;

import com.kirito666.niitnews.entity.User;
import com.kirito666.niitnews.entity.base.BaseResponse;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:APIService.java
 * @LastModified:2021/06/19 21:24:19
 */

public interface APIService {

    String BASE_URL = "http://niit.cache.ren:9090/";

    @FormUrlEncoded
    @POST("/user/login")
    LiveData<BaseResponse<User>> login(@Field("account") String account, @Field("passwd") String passwd);

    @POST("/user/register")
    LiveData<BaseResponse<User>> register(@Body User user);

    @PATCH("/user/passwd")
    LiveData<BaseResponse<String>> resetPasswd(@Field("passwd") String passwd);

    @PATCH("/user/nickname")
    LiveData<BaseResponse<String>> patchNickname(@Field("nickname") String nickname);

    @PATCH("/user/avater")
    LiveData<BaseResponse<String>> updateAvater(@Field("avater") String avater);

}