package com.luck.picture.lib.listener;

import java.util.List;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:OnQueryDataResultListener.java
 * @LastModified:2021/06/29 17:27:29
 */

/**
 * @author：luck
 * @date：2020-04-16 12:42
 * @describe：OnQueryMediaResultListener
 */
public interface OnQueryDataResultListener<T> {
    /**
     * Query to complete The callback listener
     *
     * @param data        The data source
     * @param currentPage The page number
     * @param isHasMore   Is there more
     */
    void onComplete(List<T> data, int currentPage, boolean isHasMore);
}
