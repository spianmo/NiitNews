package com.kirshi.framework.mvp.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;

import com.google.android.material.snackbar.Snackbar;
import com.kirshi.framework.mvp.presenter.BasePresenter;
import com.kirshi.framework.mvp.view.BaseView;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:BaseActivityCompat.java
 * @LastModified:2021/06/19 21:50:19
 */

public abstract class BaseActivityCompat<P extends BasePresenter, V extends ViewBinding> extends AppCompatActivity implements BaseView, Toolbar.OnMenuItemClickListener {
    Handler mainHandler;
    protected P mPresenter;
    protected V v;
    protected Activity mContext;
    private Bundle savedInstance;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        savedInstance = savedInstanceState;
        mContext = this;
        beforeInitLayout();

        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        Class cls = (Class) type.getActualTypeArguments()[1];
        try {
            Method inflate = cls.getDeclaredMethod("inflate", LayoutInflater.class);
            v = (V) inflate.invoke(null, getLayoutInflater());
            setContentView(v.getRoot());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        createPresenter();

        if (mPresenter != null) mPresenter.attachView(this);
        initViews();
        initParams();
    }

    public Bundle getSavedInstance() {
        return savedInstance;
    }

    protected abstract void beforeInitLayout();

    protected abstract void initViews();  //初始化控件

    protected abstract void initParams(); //初始化参数


    private void createPresenter() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        Class cls = (Class) type.getActualTypeArguments()[0];
        try {
            Constructor constructor = cls.getConstructor(Activity.class);
            mPresenter = (P) constructor.newInstance(mContext);
        } catch (IllegalAccessException e) {
            //e.printStackTrace();
        } catch (InstantiationException e) {
            //e.printStackTrace();
        } catch (NoSuchMethodException e) {
            //e.printStackTrace();
            try {
                mPresenter = (P) cls.newInstance();
                LOGE("重新创建了无参Presenter");
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            } catch (InstantiationException instantiationException) {
                instantiationException.printStackTrace();
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }


    @Override
    protected void onDestroy() {
        if (mPresenter != null) mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void jumpPage(Class<?> activity) {
        mContext.startActivity(new Intent(this, activity));
    }

    @Override
    public void finishself() {
        finish();
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

    @Override
    public Snackbar showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(v.getRoot(), message, Snackbar.LENGTH_SHORT);
        runOnUI(snackbar::show);
        return snackbar;
    }

    @Override
    public void showToast(String message) {
        runOnUI(() -> {
            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
        });
    }


}
