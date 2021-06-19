package com.kirito666.niitnews.util;

import java.util.List;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:StringUtil.java
 * @LastModified:2021/06/17 16:57:17
 */

/**
 * string工具类
 * Created by burro on 2017/9/23.
 */
public class StringUtil {
    /**
     * 判断str是否为空
     *
     * @param str String
     * @return boolean true:空;false:非空
     */
    public static boolean isStrEmpty(String str) {
        return ((str == null) || (str.trim().equals("")));
    }

    /**
     * 判断list是否为空
     *
     * @param str String
     * @return boolean true:空;false:非空
     */
    public static boolean isListEmpty(List str) {
        return ((str == null) || (str.size() <= 0));
    }

    //获取String
    public static String getString(String str) {
        if (str == null || "null".equalsIgnoreCase(str)) return "";
        return str;
    }

    //获取String
    public static String getString(Object str) {
        if (str == null || "null".equalsIgnoreCase(str.toString())) return "";
        return str.toString();
    }
}
