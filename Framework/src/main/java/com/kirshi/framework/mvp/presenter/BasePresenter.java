package com.kirshi.framework.mvp.presenter;


import android.util.Log;

import com.kirshi.framework.mvp.view.BaseView;


/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:BasePresenter.java
 * @LastModified:2021/06/19 21:50:19
 */

/**
 * Presenter基类。目的是统一处理绑定和解绑
 */
public class BasePresenter<T extends BaseView> implements IPresenter<T> {

    protected T mView;

    @Override
    public void attachView(T view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }


    public void LOGE(String log) {
        Log.e("==" + this.getClass().getName() + "==>", log);
    }

    public void LOGW(String log) {
        Log.w("==" + this.getClass().getName() + "==>", log);
    }

}