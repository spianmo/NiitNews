package com.kirito666.niitnews.entity.base;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:BaseDtoCallback.java
 * @LastModified:2021/06/29 02:16:29
 */

public interface BaseDtoCallback<T> {
    void onStartFetch();

    void onDtoAvailable(String message, T dto);

    void onDtoFailed(String message);
}
