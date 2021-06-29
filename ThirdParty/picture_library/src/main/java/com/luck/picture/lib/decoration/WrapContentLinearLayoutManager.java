package com.luck.picture.lib.decoration;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:WrapContentLinearLayoutManager.java
 * @LastModified:2021/06/29 17:27:29
 */

/**
 * Created by luck on 2017/12/4.
 * <p>
 * RecyclerView Bug：IndexOutOfBoundsException: Inconsistency detected. Invalid view holder adapter的解决方案
 */

public class WrapContentLinearLayoutManager extends LinearLayoutManager {
    public WrapContentLinearLayoutManager(Context context) {
        super(context);
    }

    public WrapContentLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public WrapContentLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

}
