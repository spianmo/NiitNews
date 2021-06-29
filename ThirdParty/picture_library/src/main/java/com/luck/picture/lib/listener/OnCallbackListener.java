package com.luck.picture.lib.listener;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:OnCallbackListener.java
 * @LastModified:2021/06/29 17:27:29
 */

/**
 * @author：luck
 * @date：2020/4/24 11:48 AM
 * @describe：OnCallbackListener
 */
public interface OnCallbackListener<T> {
    /**
     * @param data
     */
    void onCall(T data);
}
