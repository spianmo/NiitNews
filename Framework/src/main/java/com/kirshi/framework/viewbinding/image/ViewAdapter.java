package com.kirshi.framework.viewbinding.image;

import android.text.TextUtils;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.annotation.RawRes;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:ViewAdapter.java
 * @LastModified:2021/06/28 14:09:28
 */

/**
 * @author Finger
 */
public final class ViewAdapter {
    @BindingAdapter(value = {"url", "placeholderRes"}, requireAll = false)
    public static void setImageUri(ImageView imageView, String url, int placeholderRes) {
        if (!TextUtils.isEmpty(url)) {
            Glide.with(imageView.getContext())
                    .load(url)
                    .apply(new RequestOptions().placeholder(placeholderRes))
                    .into(imageView);
        }
    }

    @BindingAdapter(value = {"local", "placeholderRes"}, requireAll = false)
    public static void setImageLocal(ImageView imageView, @RawRes @DrawableRes int resourceId, int placeholderRes) {
        Glide.with(imageView.getContext())
                .load(resourceId)
                .apply(new RequestOptions().placeholder(placeholderRes))
                .into(imageView);
    }
}

