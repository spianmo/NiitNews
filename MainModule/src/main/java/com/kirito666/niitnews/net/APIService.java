package com.kirito666.niitnews.net;

import com.kirito666.niitnews.entity.Application;
import com.kirito666.niitnews.entity.Banner;
import com.kirito666.niitnews.entity.Bling;
import com.kirito666.niitnews.entity.Commit;
import com.kirito666.niitnews.entity.News;
import com.kirito666.niitnews.entity.NewsGroup;
import com.kirito666.niitnews.entity.Post;
import com.kirito666.niitnews.entity.Rank;
import com.kirito666.niitnews.entity.User;
import com.kirito666.niitnews.entity.base.BaseResponse;
import com.kirito666.niitnews.entity.dto.FriendDto;
import com.kirito666.niitnews.entity.dto.NewsPageData;
import com.kirito666.niitnews.entity.dto.PostDto;
import com.kirito666.niitnews.entity.dto.PostPageData;

import java.sql.Timestamp;
import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:APIService.java
 * @LastModified:2021/06/29 00:41:29
 */

public interface APIService {

    String BASE_URL = "http://niit.cache.ren:9090/";

    @GET("/user/{id}")
    Call<BaseResponse<User>> getUserDetail(@Query("id") int id);

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

    @GET("/ranks/news")
    Call<BaseResponse<List<Rank>>> fetchNewsRank(@Query("afterTime") Timestamp afterTime);

    @GET("/ranks/posts")
    Call<BaseResponse<List<Rank>>> fetchPostsRank(@Query("afterTime") Timestamp afterTime);

    @GET("/news")
    Call<BaseResponse<NewsPageData>> fetchNewsPage(@Query("pageId") int pageId, @Query("pageSize") int pageSize, @Query("groupId") int groupId);

    @GET("/news/{id}")
    Call<BaseResponse<News>> getNewsById(@Path("id") int id);

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

    @GET("/posts")
    Call<BaseResponse<PostPageData>> fetchPost(@Query("pageId") int pageId, @Query("pageSize") int pageSize);

    @GET("/posts/public")
    Call<BaseResponse<PostPageData>> fetchPostPublic(@Query("pageId") int pageId, @Query("pageSize") int pageSize);

    @POST("/posts")
    Call<BaseResponse<String>> insertPost(@Body Post post);


    @GET("/posts/{pid}")
    Call<BaseResponse<PostDto>> postDetail(@Path("pid") int pid);


    @PUT("/posts/{pid}")
    Call<BaseResponse<String>> updatePost(@Body Post post, @Path("pid") int pid);

    @DELETE("/posts/{pid}")
    Call<BaseResponse<String>> deletePost(@Path("pid") int pid);

    @POST("/posts/{pid}/favor")
    Call<BaseResponse<String>> favorPost(@Path("pid") int pid);

    @FormUrlEncoded
    @DELETE("/posts/{pid}/favor")
    Call<BaseResponse<String>> deleteFavor(@Path("pid") int pid);

    @POST("/posts/{pid}/commit")
    Call<BaseResponse<String>> commitPost(@Path("pid") int pid, @Body Commit commit);

    @FormUrlEncoded
    @DELETE("/posts/{pid}/commit")
    Call<BaseResponse<String>> deleteCommit(@Path("pid") int pid, @Field("cid") int cid);

    @POST("/posts/{pid}/forward")
    Call<BaseResponse<String>> forwardPost(@Path("pid") int pid);

    @GET("/friends")
    Call<BaseResponse<List<FriendDto>>> getAllFriend();

    @DELETE("/friends/{friendId}")
    Call<BaseResponse<List<String>>> deleteFriend(@Path("friendId") int friendId);

    @FormUrlEncoded
    @POST("/friends/{friendId}")
    Call<BaseResponse<List<String>>> addFriend(@Path("friendId") int friendId, @Field("remark") String remark);


    @PATCH("/friends/{friendId}")
    Call<BaseResponse<List<String>>> remarkFriend(@Path("friendId") int friendId, @Field("remark") String remark);


    @PUT("/oss/avatar")
    Call<BaseResponse<String>> uploadOssImg(@Part("uploadFile") MultipartBody.Part uploadFile);

    @PUT("/oss/file")
    Call<BaseResponse<String>> uploadOssFile(@Part("uploadFile") MultipartBody.Part uploadFile);

    @GET("/app")
    Call<BaseResponse<Application>> getCurrentApplicationInfo();

    @GET("/app/{versionCode}")
    Call<BaseResponse<Application>> getApplicationInfoByVersionCode(@Path("versionCode") long versionCode);

    @GET("/app/history")
    Call<BaseResponse<List<Application>>> getApplicationHistory();

    @GET("/app/banner/main")
    Call<BaseResponse<List<Banner>>> getMainBanner(@Query("num") int num);

    @GET("/app/banner/news")
    Call<BaseResponse<List<Banner>>> getNewsBanner(@Query("num") int num);

    @GET("/app/banner/adv")
    Call<BaseResponse<List<Banner>>> getAdvBanner(@Query("num") int num);

    @GET("/app/banner/common")
    Call<BaseResponse<List<Banner>>> getCommonBanner(@Query("num") int num);

    @GET("/app/bling")
    Call<BaseResponse<Bling>> getApplicationBling();

}