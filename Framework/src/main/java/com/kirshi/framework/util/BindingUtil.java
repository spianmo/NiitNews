package com.kirshi.framework.util;

import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:BindingUtil.java
 * @LastModified:2021/06/21 22:11:21
 */

public class BindingUtil {
    /**
     * 找到 ViewBinding 的 class
     *
     * @param object obj : activity
     * @return Class<? extends ViewBinding>
     */
    @SuppressWarnings("unchecked")
    private static Class<? extends ViewBinding> findViewBinding(Object object) {
        //获取到 BaseBindingActivity
        Type type = object.getClass().getGenericSuperclass();
        if (type == null) {
            return null;
        }
        // 获取 BaseBindingActivity 的 所包含的泛型参数列表，这里是核心。
        Type[] types = ((ParameterizedType) type).getActualTypeArguments();

        if (types.length == 0) {
            return null;
        }

        //目前泛型只有一个，所以拿第0 个
        return (Class<? extends ViewBinding>) types[0];
    }

    /**
     * 得到 Binding 的实例
     *
     * @param viewBindingClass Class<? extends ViewBinding>
     * @param layoutInflater   LayoutInflater
     * @param <Binding>        Binding
     * @return Binding
     */
    @SuppressWarnings("unchecked")
    private static <Binding> Binding createViewBinding(Class<? extends ViewBinding> viewBindingClass, LayoutInflater layoutInflater) {

        try {
            Method method = viewBindingClass.getMethod("inflate", LayoutInflater.class);

            ViewBinding viewBinding = (ViewBinding) method.invoke(viewBindingClass,
                    layoutInflater);

            return (Binding) viewBinding;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * activity 的 创建方式
     *
     * @param appCompatActivity AppCompatActivity
     * @param <Binding>         Binding
     * @return <Binding> Binding
     */
    public static <Binding> Binding createBinding(@NonNull AppCompatActivity
                                                          appCompatActivity) {
        LayoutInflater layoutInflater = appCompatActivity.getLayoutInflater();
        Class<? extends ViewBinding> viewBindClass =
                findViewBinding(appCompatActivity);

        return createViewBinding(viewBindClass, layoutInflater);
    }

}
