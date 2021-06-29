package com.luck.picture.lib.compress;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:CompressionPredicate.java
 * @LastModified:2021/06/29 20:53:29
 */

/**
 * Created on 2018/1/3 19:43
 *
 * @author andy
 * <p>
 * A functional interface (callback) that returns true or false for the given input path should be compressed.
 */

public interface CompressionPredicate {

    /**
     * Determine the given input path should be compressed and return a boolean.
     *
     * @param path input path
     * @return the boolean result
     */
    boolean apply(String path);
}
