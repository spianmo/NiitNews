package com.kirito666.niitnews.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:MyViewPager.java
 * @LastModified:2021/06/19 16:51:19
 */

public class MyViewPager extends NoCacheViewPager {
    private boolean isCanScroll = true;

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (this.isCanScroll) {
            return super.onInterceptTouchEvent(arg0);
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        if (this.isCanScroll) {
            return super.onTouchEvent(arg0);
        }
        return false;
    }

    public boolean isCanScroll() {
        return this.isCanScroll;
    }

    public void setCanScroll(boolean isCanScroll) {
        this.isCanScroll = isCanScroll;
    }
}
