package com.kirshi.framework.viewbinding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import com.google.android.material.snackbar.Snackbar;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:BaseActivity.java
 * @LastModified:2021/06/29 02:16:29
 */

public class BaseActivity<V extends ViewBinding> extends AppCompatActivity {
    Handler mainHandler;
    protected V v;
    protected Activity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        Class cls = (Class) type.getActualTypeArguments()[0];
        try {
            Method inflate = cls.getDeclaredMethod("inflate", LayoutInflater.class);
            v = (V) inflate.invoke(null, getLayoutInflater());
            setContentView(v.getRoot());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void runOnUI(Runnable runnable) {
        mainHandler = new Handler(Looper.getMainLooper());
        mainHandler.post(runnable);
    }

    public void toast(String message) {
        Toast toast = Toast.makeText(mContext, message, Toast.LENGTH_SHORT);
        runOnUI(toast::show);
    }

    public void LOGE(String log) {
        Log.e("==" + this.getClass().getName() + "==>", log);
    }

    public void LOGW(String log) {
        Log.w("==" + this.getClass().getName() + "==>", log);
    }

    public void finishself() {
        finish();
    }

    public void jumpPage(Class<?> activity) {
        mContext.startActivity(new Intent(this, activity));
    }

    public Snackbar showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(v.getRoot(), message, Snackbar.LENGTH_SHORT);
        runOnUI(snackbar::show);
        return snackbar;
    }


}
