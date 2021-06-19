package com.kirito666.niitnews.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:InsetDispatchingCoordinatorLayout.java
 * @LastModified:2021/06/19 16:51:19
 */

public class InsetDispatchingCoordinatorLayout extends CoordinatorLayout {
    public InsetDispatchingCoordinatorLayout(@NonNull Context context) {
        super(context);
    }

    public InsetDispatchingCoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public InsetDispatchingCoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        WindowInsets dispatched = super.dispatchApplyWindowInsets(insets);
        WindowInsets applied = onApplyWindowInsets(insets);

        if (dispatched.isConsumed()) {
            return dispatched;
        }
        if (applied.isConsumed()) {
            return applied;
        }
        return dispatched;
    }

    @Override
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            child.dispatchApplyWindowInsets(insets);
        }
        return insets;
    }
}
