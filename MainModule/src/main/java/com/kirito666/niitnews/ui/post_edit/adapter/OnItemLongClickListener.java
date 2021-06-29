package com.kirito666.niitnews.ui.post_edit.adapter;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:OnItemLongClickListener.java
 * @LastModified:2021/06/29 18:20:29
 */

/**
 * @author：luck
 * @date：2020-01-13 17:58
 * @describe：长按事件
 */
public interface OnItemLongClickListener {
    void onItemLongClick(RecyclerView.ViewHolder holder, int position, View v);
}
