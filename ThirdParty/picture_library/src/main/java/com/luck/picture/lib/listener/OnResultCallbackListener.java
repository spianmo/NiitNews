package com.luck.picture.lib.listener;

import java.util.List;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:OnResultCallbackListener.java
 * @LastModified:2021/06/29 17:27:29
 */

/**
 * @author：luck
 * @date：2020-01-14 17:08
 * @describe：onResult Callback Listener
 */
public interface OnResultCallbackListener<T> {
    /**
     * return LocalMedia result
     *
     * @param result
     */
    void onResult(List<T> result);

    /**
     * Cancel
     */
    void onCancel();
}
