/*
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:RegisterDialog.kt
 * @LastModified:2021/06/28 09:34:28
 */

package com.kirito666.niitnews.ui.register

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.kirito666.niitnews.databinding.DialogRegisterBinding
import com.kirito666.niitnews.entity.Session
import com.kirito666.niitnews.entity.User
import com.kirito666.niitnews.entity.base.BaseResponse
import com.kirito666.niitnews.entity.base.HttpStatusCode
import com.kirito666.niitnews.net.jar.SessionJar
import com.kirito666.niitnews.net.jar.UserJar
import com.kirito666.niitnews.net.retrofit.RetrofitClient
import com.kirito666.niitnews.util.StringUtil
import com.kirshi.framework.viewbinding.KBaseDialogFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Copyright (c) 2021
 *
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:RegisterDialog.java
 * @LastModified:2021/06/24 11:41:24
 */
class RegisterDialog : KBaseDialogFragment<DialogRegisterBinding>() {

    private lateinit var listener: OnRegisterCallback

    override fun inCreateView() {}
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        v.btnRegister.setOnClickListener {
            val user = User()
            user.account = v.tvAccount.text.toString()
            user.passwd = v.tvPassword.text.toString()
            user.nickname = user.account
            if (TextUtils.isEmpty(user.account) || TextUtils.isEmpty(user.passwd)) {
                toast("账号密码不能为空")
                return@setOnClickListener
            }

            if (!StringUtil.checkPassword(user.passwd)) {
                toast("密码强度不够，密码必须为6-16位数字与大小写字母混合")
                return@setOnClickListener
            }
            RetrofitClient.getInstance().api.register(user)
                .enqueue(object : Callback<BaseResponse<User>> {
                    override fun onResponse(
                        call: Call<BaseResponse<User>>,
                        response: Response<BaseResponse<User>>
                    ) {
                        val rawResponse = response.body()
                        if (rawResponse?.statusCode == HttpStatusCode.SUCCESS.status) {
                            val session = Session(
                                response.headers()["uid"]!!.toLong(), response.headers()["superkey"]
                            )
                            SessionJar.saveSessionToDisk(session)
                            UserJar.saveToDisk(rawResponse.data)
                            dismiss()
                            listener.onSuccess()
                        } else {
                            rawResponse?.msg?.toast()
                        }
                    }

                    override fun onFailure(call: Call<BaseResponse<User>>, t: Throwable) {
                        t.toast()
                    }
                })
        }
    }

    fun setOnRegisterCallback(callback: OnRegisterCallback) {
        listener = callback
    }

    interface OnRegisterCallback {
        fun onSuccess()
    }
}