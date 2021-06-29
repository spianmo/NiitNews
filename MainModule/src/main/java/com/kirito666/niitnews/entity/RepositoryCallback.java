package com.kirito666.niitnews.entity;

import com.kirito666.niitnews.entity.base.HttpStatusCode;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:RepositoryCallback.java
 * @LastModified:2021/06/29 13:49:29
 */

public interface RepositoryCallback<T> {
    void onSuccess(T data);

    void onFailure(HttpStatusCode code);

    void onError(Throwable throwable);
}
