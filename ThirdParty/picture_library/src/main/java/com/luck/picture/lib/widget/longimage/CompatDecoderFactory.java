package com.luck.picture.lib.widget.longimage;


import androidx.annotation.NonNull;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:CompatDecoderFactory.java
 * @LastModified:2021/06/29 20:53:29
 */

/**
 * Compatibility factory to instantiate decoders with empty public constructors.
 *
 * @param <T> The base type of the decoder this factory will produce.
 */
public class CompatDecoderFactory<T> implements DecoderFactory<T> {
    private Class<? extends T> clazz;

    public CompatDecoderFactory(@NonNull Class<? extends T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T make() throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }
}
