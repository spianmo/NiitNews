/*
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:KBaseDialogFragment.kt
 * @LastModified:2021/06/28 09:34:28
 */

package com.kirshi.framework.viewbinding

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.ParameterizedType

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:BaseDialogFragment.java
 * @LastModified:2021/06/24 18:42:24
 */
abstract class KBaseDialogFragment<V : ViewBinding> : DialogFragment() {
    var mainHandler: Handler = Handler(Looper.getMainLooper())
    protected lateinit var v: V
    protected var mContext: Context? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mContext = activity
        val type = javaClass.genericSuperclass as ParameterizedType
        val cls = type.actualTypeArguments[0] as Class<*>
        try {
            val inflate = cls.getDeclaredMethod(
                "inflate",
                LayoutInflater::class.java,
                ViewGroup::class.java,
                Boolean::class.javaPrimitiveType
            )
            v = inflate.invoke(null, inflater, container, false) as V
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }
        inCreateView()
        return v.root
    }

    abstract fun inCreateView()
    override fun onStart() {
        val params = requireDialog().window!!.attributes
        params.width = ViewGroup.LayoutParams.WRAP_CONTENT
        val dm = DisplayMetrics()
        activity?.windowManager?.defaultDisplay?.getMetrics(dm)
        requireDialog().window!!.setLayout(
            (dm.widthPixels * 0.85).toInt(),
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        requireDialog().window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        requireDialog().window!!.attributes = params
        super.onStart()
    }

    protected fun toast(str: String) {
        mainHandler.post {
            Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show()
        }
    }

    protected fun Any.toast(duration: Int = Toast.LENGTH_SHORT) {
        return ktxRunOnUi {
            Toast.makeText(mContext, this.toString(), duration).apply { show() }
        }
    }

    private fun ktxRunOnUi(block: () -> Unit) {
        mainHandler.post {
            block()
        }
    }
}