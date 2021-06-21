package com.kirshi.framework.util;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:ViewHolder.java
 * @LastModified:2021/06/21 23:15:21
 */

/**
 * ViewHolder
 */
public class ViewHolder extends RecyclerView.ViewHolder {
    private ViewDataBinding binding;

    ViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    ViewDataBinding getBinding() {
        return binding;
    }

    void setBinding(ViewDataBinding binding) {
        this.binding = binding;
    }
}
