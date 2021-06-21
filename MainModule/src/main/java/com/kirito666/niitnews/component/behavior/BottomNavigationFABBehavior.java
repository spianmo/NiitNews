package com.kirito666.niitnews.component.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.snackbar.Snackbar;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:BottomNavigationFABBehavior.java
 * @LastModified:2021/06/21 11:37:21
 */

public class BottomNavigationFABBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    public BottomNavigationFABBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BottomNavigationFABBehavior() {
        super();
    }

    @Override
    public void onDependentViewRemoved(@NonNull CoordinatorLayout parent, @NonNull V child, @NonNull View dependency) {
        child.setTranslationY(0f);
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull V child, @NonNull View dependency) {
        return updateButton(child, dependency);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull V child, @NonNull View dependency) {
        return dependency instanceof Snackbar.SnackbarLayout;
    }

    private void updateSnackBar(View child, Snackbar.SnackbarLayout snackBarLayout) {
        if (snackBarLayout.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) snackBarLayout.getLayoutParams();

            params.setAnchorId(child.getId());
            params.anchorGravity = Gravity.TOP;
            params.gravity = Gravity.TOP;
            snackBarLayout.setLayoutParams(params);
        }
    }

    private boolean updateButton(View child, View dependency) {
        if (dependency instanceof Snackbar.SnackbarLayout) {
            float oldTranslation = child.getTranslationY();
            float height = dependency.getHeight();
            float newTranslation = dependency.getTranslationY() - height;
            child.setTranslationY(newTranslation);
            return oldTranslation != newTranslation;
        }
        return false;
    }

}