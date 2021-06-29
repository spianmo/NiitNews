package com.kirito666.niitnews.component.adapter;

import android.content.Context;
import android.view.View;

import java.util.List;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:NineGridAdapter.java
 * @LastModified:2021/06/30 04:13:30
 */

public abstract class NineGridAdapter {
    protected Context context;
    protected List list;

    public NineGridAdapter(Context context, List list) {
        this.context = context;
        this.list = list;
    }

    public abstract int getCount();

    public abstract String getUrl(int positopn);

    public abstract Object getItem(int position);

    public abstract long getItemId(int position);

    public abstract View getView(int i, View view);
}
