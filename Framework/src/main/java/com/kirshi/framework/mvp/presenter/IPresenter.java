package com.kirshi.framework.mvp.presenter;


/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:IPresenter.java
 * @LastModified:2021/06/29 02:16:29
 */

public interface IPresenter<T> {
    void attachView(T view);

    void detachView();
}
