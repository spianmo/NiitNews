package com.kirito666.niitnews.net.retrofit;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kirito666.niitnews.App;
import com.kirito666.niitnews.R;
import com.kirito666.niitnews.entity.Session;
import com.kirito666.niitnews.net.APIService;
import com.kirito666.niitnews.net.jar.SessionJar;
import com.kirito666.niitnews.util.CertificatesUtil;
import com.zhy.http.okhttp.cookie.CookieJarImpl;
import com.zhy.http.okhttp.cookie.store.PersistentCookieStore;

import java.io.InputStream;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:RetrofitClient.java
 * @LastModified:2021/06/22 02:47:22
 */

public class RetrofitClient {

    private static volatile RetrofitClient instance;
    private APIService apiService;
    private static CertificatesUtil.SSLParams sslParams;
    private Session session;


    private RetrofitClient() {
        session = SessionJar.loadSessionFromDisk(App.getAppContext());
        InputStream inputStreams = App.getAppContext().getResources().openRawResource(R.raw.cert);
        sslParams = CertificatesUtil.getSslSocketFactory(inputStreams, null, null);
    }

    public static RetrofitClient getInstance() {
        if (instance == null) {
            synchronized (RetrofitClient.class) {
                if (instance == null) {
                    instance = new RetrofitClient();
                }
            }
        }
        return instance;
    }

    /**
     * 设置Header
     *
     * @return
     */
    private Interceptor getHeaderInterceptor() {
        return chain -> {
            Request original = chain.request();
            Request.Builder requestBuilder = original.newBuilder();
            if (session == null) {
                session = SessionJar.loadSessionFromDisk(App.getAppContext());
            }
            if (SessionJar.isExist(App.getAppContext())) {
                requestBuilder
                        .addHeader("uid", String.valueOf(session.getUid()))
                        .addHeader("superkey", session.getSuperkey());
            }
            Request request = requestBuilder.build();
            return chain.proceed(request);
        };

    }

    /**
     * 设置拦截器
     *
     * @return
     */
    private Interceptor getInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    public APIService getApi() {
        OkHttpClient client;
        if (App.isApkInDebug(App.getAppContext())) {
            client = new OkHttpClient().newBuilder()
                    .cookieJar(new CookieJarImpl(new PersistentCookieStore(App.getAppContext())))
                    .addInterceptor(getHeaderInterceptor())
                    .addInterceptor(getInterceptor())
                    .build();
        } else {
            client = new OkHttpClient().newBuilder()
                    .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                    .addInterceptor(getHeaderInterceptor())
                    .cookieJar(new CookieJarImpl(new PersistentCookieStore(App.getAppContext())))
                    .build();
        }
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                //.serializeNulls()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                //设置网络请求的Url地址
                .baseUrl(APIService.BASE_URL)
                //设置数据解析器
                .addConverterFactory(new ToStringConverterFactory())
                .addConverterFactory(GsonConverterFactory.create(gson))
                //设置网络请求适配器，使其支持RxJava与RxAndroid
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .build();
        //创建—— 网络请求接口—— 实例
        apiService = retrofit.create(APIService.class);
        return apiService;
    }


}