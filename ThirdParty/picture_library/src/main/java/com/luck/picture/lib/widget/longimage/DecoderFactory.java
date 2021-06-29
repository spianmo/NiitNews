package com.luck.picture.lib.widget.longimage;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:DecoderFactory.java
 * @LastModified:2021/06/29 20:53:29
 */

/**
 * Interface for decoder (and region decoder) factories.
 *
 * @param <T> the class of decoder that will be produced.
 */
public interface DecoderFactory<T> {
    /**
     * Produce a new instance of a decoder with type {@link T}.
     *
     * @return a new instance of your decoder.
     */
    T make() throws IllegalAccessException, InstantiationException;
}
