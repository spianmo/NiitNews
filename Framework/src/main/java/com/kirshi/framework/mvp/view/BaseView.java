package com.kirshi.framework.mvp.view;


import com.google.android.material.snackbar.Snackbar;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:BaseView.java
 * @LastModified:2021/06/19 21:50:19
 */

public interface BaseView {
    void jumpPage(Class<?> activity);

    void finishself();

    Snackbar showSnackBar(String message);

    void showToast(String message);
}
