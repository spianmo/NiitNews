package com.kirito666.niitnews.net;


import com.kirito666.niitnews.entity.NewsGroup;
import com.kirito666.niitnews.entity.Rank;
import com.kirito666.niitnews.entity.User;
import com.kirito666.niitnews.entity.base.BaseResponse;
import com.kirito666.niitnews.entity.dto.NewsPageData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:APIService.java
 * @LastModified:2021/06/21 22:14:21
 */

public interface APIService {

    String BASE_URL = "http://niit.cache.ren:9090/";

    @FormUrlEncoded
    @POST("/user/login")
    Call<BaseResponse<User>> login(@Field("account") String account, @Field("passwd") String passwd);

    @POST("/user/register")
    Call<BaseResponse<User>> register(@Body User user);

    @FormUrlEncoded
    @PATCH("/user/passwd")
    Call<BaseResponse<String>> resetPasswd(@Field("passwd") String passwd);

    @FormUrlEncoded
    @PATCH("/user/nickname")
    Call<BaseResponse<String>> patchNickname(@Field("nickname") String nickname);

    @FormUrlEncoded
    @PATCH("/user/avater")
    Call<BaseResponse<String>> updateAvater(@Field("avater") String avater);

    @FormUrlEncoded
    @GET("/ranks/news")
    Call<BaseResponse<List<Rank>>> fetchNewsRank(@Field("afterTime") String afterTime);

    @GET("/ranks/posts")
    Call<BaseResponse<List<Rank>>> fetchRank();

    @FormUrlEncoded
    @GET("/news")
    Call<BaseResponse<NewsPageData>> fetchNewsPage(@Field("pageId") int pageId, @Field("pageSize") int pageSize, @Field("groupId") int groupId);


    @GET("/news/groups")
    Call<BaseResponse<List<NewsGroup>>> fetchNewsGroup();

    @FormUrlEncoded
    @GET("/news/xxyw")
    Call<BaseResponse<NewsPageData>> fetchNews1(@Field("pageId") int pageId, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @GET("/news/xwsd")
    Call<BaseResponse<NewsPageData>> fetchNews2(@Field("pageId") int pageId, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @GET("/news/ybfc")
    Call<BaseResponse<NewsPageData>> fetchNews3(@Field("pageId") int pageId, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @GET("/news/dsxx")
    Call<BaseResponse<NewsPageData>> fetchNews4(@Field("pageId") int pageId, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @GET("/news/mtjj")
    Call<BaseResponse<NewsPageData>> fetchNews5(@Field("pageId") int pageId, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @GET("/news/tzgg")
    Call<BaseResponse<NewsPageData>> fetchNews6(@Field("pageId") int pageId, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @GET("/news/zbgg")
    Call<BaseResponse<NewsPageData>> fetchNews7(@Field("pageId") int pageId, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @GET("/news/kyzl")
    Call<BaseResponse<NewsPageData>> fetchNews8(@Field("pageId") int pageId, @Field("pageSize") int pageSize);



}