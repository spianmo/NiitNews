/*
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:Prefs.kt
 * @LastModified:2021/06/29 19:59:29
 */

package com.kirito666.niitnews.util

import android.content.Context
import android.content.SharedPreferences
import com.kirito666.niitnews.App

/**
 * Prefs
 * @author Finegr
 * @date 2020/6/24 11:58
 */

object Prefs {
    private val sharedPreferences: SharedPreferences =
        App.Instance().getSharedPreferences("Settings", Context.MODE_PRIVATE)

    /**
     * 保存
     * @param key 键
     * @param value 值
     * */
    @JvmStatic
    fun save(key: String, value: Any?) {
        value ?: return
        sharedPreferences.edit().apply {
            when (value) {
                is String -> putString(key, value)
                is Int -> putInt(key, value)
                is Boolean -> putBoolean(key, value)
                is Float -> putFloat(key, value)
                is Long -> putLong(key, value)
            }
            apply()
        }
    }

    @JvmStatic
    fun getString(key: String, defV: String = "") = sharedPreferences.getString(key, defV)

    @JvmStatic
    fun getInt(key: String, defV: Int) = sharedPreferences.getInt(key, defV)

    @JvmStatic
    fun getBoolean(key: String, defV: Boolean) = sharedPreferences.getBoolean(key, defV)

    @JvmStatic
    fun getLong(key: String, defV: Long) = sharedPreferences.getLong(key, defV)
}