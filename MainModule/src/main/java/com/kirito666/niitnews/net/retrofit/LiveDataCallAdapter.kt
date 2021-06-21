/*
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:LiveDataCallAdapter.kt
 * @LastModified:2021/06/21 22:14:21
 */

package com.kirito666.niitnews.net.retrofit

import androidx.lifecycle.LiveData
import com.kirito666.niitnews.entity.base.BaseResponse
import com.kirito666.niitnews.entity.base.HttpStatusCode
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import java.util.concurrent.atomic.AtomicBoolean

class LiveDataCallAdapter<T>(private val responseType: Type) : CallAdapter<T, LiveData<T>> {
    override fun adapt(call: Call<T>): LiveData<T> {
        return object : LiveData<T>() {
            private val started = AtomicBoolean(false)
            override fun onActive() {
                super.onActive()
                if (started.compareAndSet(false, true)) {//确保执行一次
                    call.enqueue(object : Callback<T> {
                        override fun onFailure(call: Call<T>, t: Throwable) {
                            val value =
                                BaseResponse(HttpStatusCode.UNKNOW_EXCEPTION, t.message) as T
                            postValue(value)
                        }

                        override fun onResponse(call: Call<T>, response: Response<T>) {
                            postValue(response.body())
                        }
                    })
                }
            }
        }
    }

    override fun responseType() = responseType
}