/*
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:LiveDataCallAdapterFactory.kt
 * @LastModified:2021/06/21 22:14:21
 */

package com.kirito666.niitnews.net.retrofit

import androidx.lifecycle.LiveData
import com.kirito666.niitnews.entity.base.BaseResponse
import retrofit2.CallAdapter
import retrofit2.CallAdapter.Factory
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class LiveDataCallAdapterFactory : Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (getRawType(returnType) != LiveData::class.java) return null
        //获取第一个泛型类型
        val observableType = getParameterUpperBound(0, returnType as ParameterizedType)
        val rawType = getRawType(observableType)
        if (rawType != BaseResponse::class.java) {
            throw IllegalArgumentException("type must be ApiResponse")
        }
        if (observableType !is ParameterizedType) {
            throw IllegalArgumentException("resource must be parameterized")
        }
        return LiveDataCallAdapter<Any>(observableType)
    }
}