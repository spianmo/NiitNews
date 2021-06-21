package com.kirito666.niitnews.net;


import androidx.lifecycle.LiveData;

import com.kirito666.niitnews.entity.NewsGroup;
import com.kirito666.niitnews.entity.Rank;
import com.kirito666.niitnews.entity.User;
import com.kirito666.niitnews.entity.base.BaseResponse;
import com.kirito666.niitnews.entity.dto.NewsPageData;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Shinonon
 * @FileName:APIService.java
 * @LastModified:2021/06/21 09:29:21
 */

public interface APIService {

    String BASE_URL = "http://niit.cache.ren:9090/";

    @FormUrlEncoded
    @POST("/user/login")
    LiveData<BaseResponse<User>> login(@Field("account") String account, @Field("passwd") String passwd);

    @POST("/user/register")
    LiveData<BaseResponse<User>> register(@Body User user);

    @FormUrlEncoded
    @PATCH("/user/passwd")
    LiveData<BaseResponse<String>> resetPasswd(@Field("passwd") String passwd);

    @FormUrlEncoded
    @PATCH("/user/nickname")
    LiveData<BaseResponse<String>> patchNickname(@Field("nickname") String nickname);

    @FormUrlEncoded
    @PATCH("/user/avater")
    LiveData<BaseResponse<String>> updateAvater(@Field("avater") String avater);

    @FormUrlEncoded
    @GET("/ranks/news")
    LiveData<BaseResponse<List<Rank>>> fetchNewsRank(@Field("afterTime") String afterTime);

    @GET("/ranks/posts")
    LiveData<BaseResponse<List<Rank>>> fetchRank() ;

    @FormUrlEncoded
    @GET("/news")
    LiveData<BaseResponse<NewsPageData>> fetchNewsPage(@Field("pageId") int pageId,@Field("pageSize")int pageSize,@Field("groupId") int groupId );


    @GET("/news/groups")
    LiveData<BaseResponse<List<NewsGroup>>> fetchNewsGroup();

    @FormUrlEncoded
    @GET("/news/xxyw")
    LiveData<BaseResponse<NewsPageData>> fetchNews1(@Field("pageId") int pageId,@Field("pageSize") int pageSize);

    @FormUrlEncoded
    @GET("/news/xwsd")
    LiveData<BaseResponse<NewsPageData>> fetchNews2(@Field("pageId") int pageId,@Field("pageSize") int pageSize);

    @FormUrlEncoded
    @GET("/news/ybfc")
    LiveData<BaseResponse<NewsPageData>> fetchNews3(@Field("pageId") int pageId,@Field("pageSize") int pageSize);

    @FormUrlEncoded
    @GET("/news/dsxx")
    LiveData<BaseResponse<NewsPageData>> fetchNews4(@Field("pageId") int pageId,@Field("pageSize") int pageSize);

    @FormUrlEncoded
    @GET("/news/mtjj")
    LiveData<BaseResponse<NewsPageData>> fetchNews5(@Field("pageId") int pageId,@Field("pageSize") int pageSize);

    @FormUrlEncoded
    @GET("/news/tzgg")
    LiveData<BaseResponse<NewsPageData>> fetchNews6(@Field("pageId") int pageId,@Field("pageSize") int pageSize);

    @FormUrlEncoded
    @GET("/news/zbgg")
    LiveData<BaseResponse<NewsPageData>> fetchNews7(@Field("pageId") int pageId,@Field("pageSize") int pageSize);

    @FormUrlEncoded
    @GET("/news/kyzl")
    LiveData<BaseResponse<NewsPageData>> fetchNews8(@Field("pageId") int pageId,@Field("pageSize") int pageSize);



}