/*
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:KBaseActivity.kt
 * @LastModified:2021/06/21 22:10:21
 */

package com.kirshi.framework.viewbinding

import android.R
import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.ParameterizedType

/**
 * Copyright (c) 2021
 *
 * @Project:Freya
 * @Author:Finger
 * @FileName:BaseActivity.java
 * @LastModified:2021-04-15T03:12:15.850+08:00
 */
open class KBaseActivity<V : ViewBinding> : AppCompatActivity() {
    private val handler = Handler(Looper.getMainLooper())

    protected fun Any.toast(context: Context, duration: Int = Toast.LENGTH_SHORT) {
        return ktxRunOnUi {
            Toast.makeText(context, this.toString(), duration).apply { show() }
        }
    }

    protected fun ktxRunOnUi(block: () -> Unit) {
        handler.post {
            block()
        }
    }

    protected lateinit var v: V
    private var mContext: Activity? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.statusBarColor = resources.getColor(R.color.white)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        mContext = this
        val type = javaClass.genericSuperclass as ParameterizedType
        val cls = type.actualTypeArguments[0] as Class<*>
        try {
            val inflate = cls.getDeclaredMethod("inflate", LayoutInflater::class.java)
            v = inflate.invoke(null, layoutInflater) as V
            setContentView(v.root)
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }
    }

    fun LOGE(log: String) {
        Log.e("==" + localClassName + "==>", log);
    }

    fun LOGW(log: String) {
        Log.w("==" + localClassName + "==>", log);
    }
}