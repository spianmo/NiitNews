package com.luck.picture.lib.listener;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:OnImageCompleteCallback.java
 * @LastModified:2021/06/29 17:27:29
 */

/**
 * @author：luck
 * @date：2020-01-03 16:43
 * @describe：Image load complete callback
 */
public interface OnImageCompleteCallback {
    /**
     * Start loading
     */
    void onShowLoading();

    /**
     * Stop loading
     */
    void onHideLoading();
}
