package com.kirshi.framework.mvp.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;

import com.kirshi.framework.mvp.presenter.BasePresenter;
import com.kirshi.framework.mvp.view.BaseView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:BaseFragmentCompat.java
 * @LastModified:2021/06/29 02:16:29
 */

public abstract class BaseFragmentCompat<T extends BasePresenter, V extends ViewBinding> extends Fragment implements BaseView {

    Handler mainHandler;
    protected T mPresenter;
    protected V v;
    protected FragmentActivity mContext;
    private View mRootView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        Class cls = (Class) type.getActualTypeArguments()[1];
        try {
            Method inflate = cls.getDeclaredMethod("inflate", LayoutInflater.class, ViewGroup.class, boolean.class);
            v = (V) inflate.invoke(null, inflater, container, false);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        mRootView = v.getRoot();
        mContext = getActivity();
        createPresenter();
        if (mPresenter != null) mPresenter.attachView(this);
        initParams();
        initViews();
        return mRootView;
    }

    protected abstract void initViews();

    protected abstract void initParams();

    protected abstract void createPresenter();


    @Override
    public void onDestroyView() {
        if (mPresenter != null) mPresenter.detachView();
        if (v != null) v = null;
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        v = null;
    }

    protected void runOnUI(Runnable runnable) {
        mainHandler = new Handler(Looper.getMainLooper());
        mainHandler.post(runnable);
    }

}