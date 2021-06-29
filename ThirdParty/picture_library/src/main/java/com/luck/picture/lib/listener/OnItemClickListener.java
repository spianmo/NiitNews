package com.luck.picture.lib.listener;

import android.view.View;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:OnItemClickListener.java
 * @LastModified:2021/06/29 17:27:29
 */

/**
 * @author：luck
 * @date：2020-03-26 10:50
 * @describe：OnItemClickListener
 */
public interface OnItemClickListener {
    /**
     * Item click event
     *
     * @param v
     * @param position
     */
    void onItemClick(View v, int position);
}
