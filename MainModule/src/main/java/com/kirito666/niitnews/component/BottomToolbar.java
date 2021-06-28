package com.kirito666.niitnews.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;


/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:BottomToolbar.java
 * @LastModified:2021/06/29 02:16:29
 */

public class BottomToolbar extends Toolbar {


    public BottomToolbar(Context context) {
        super(context);
    }

    public BottomToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }


    public BottomToolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof ActionMenuView) {
            layoutParams.width = LayoutParams.MATCH_PARENT;
        }
        super.addView(view, layoutParams);
    }

    public void showBar() {
        TranslateAnimation showAnim = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        showAnim.setDuration(100);
        this.startAnimation(showAnim);
        this.setVisibility(View.VISIBLE);
    }

    public void hideBar() {
        TranslateAnimation hideAnim = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f);
        hideAnim.setDuration(150);
        this.startAnimation(hideAnim);
        hideAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                BottomToolbar.this.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

}
