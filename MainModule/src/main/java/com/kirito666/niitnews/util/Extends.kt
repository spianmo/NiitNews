/*
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:Extends.kt
 * @LastModified:2021/06/21 23:20:21
 */

package com.kirito666.niitnews.util

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kirshi.framework.util.BaseAdapter

/**
 * Intro：
 * 扩展函数
 * @author sunliwei
 * @date 2020/6/23 15:47
 */

/**
 * List
 * 列表比特计数
 * 1，3，5 -> 10101
 * 1,2,4 -> 1001
 * @param maxLen 最大长度
 * */
fun List<Int>.bitCount(maxLen: Int = 30): String {
    val sb = StringBuilder().apply {
        repeat(maxLen) { append("0") }
    }
    this.forEach {
        if (it <= sb.length) {
            sb[it - 1] = '1'
        }
    }
    return sb.toString()
}

/**
 * RecyclerView加载器
 * @param layoutManager 布局
 * @param adapter 适配器
 * */
fun <T> RecyclerView.load(
    mLayoutManager: RecyclerView.LayoutManager,
    mAdapter: BaseAdapter<T>,
    adapterOp: (adapter: BaseAdapter<T>) -> Unit = {}
) {
    layoutManager = mLayoutManager
    adapter = mAdapter
    adapterOp(mAdapter)
}


fun View.hide() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}

/**
 * 对0 - 9 补前置0
 * */
fun Int.supplyZero(): String = if (this < 10) "0$this" else this.toString()


//此生仅进行一次的操作
fun once(key: String, block: () -> Unit) {
    if (!Prefs.getBoolean(key, false)) {
        block()
        Prefs.save(key, true)
    }
}

inline fun <T> ifValue(t1: T, t2: T, block: (t1: T, t2: T) -> Boolean) =
    if (block(t1, t2)) t1 else t2

fun ifGreater(t1: Int, t2: Int) = ifValue(t1, t2) { i1, i2 -> i1 > i2 }
fun ifLess(t1: Int, t2: Int) = ifValue(t1, t2) { i1, i2 -> i1 < i2 }
fun ifGreaterEqual(t1: Int, t2: Int) = ifValue(t1, t2) { i1, i2 -> i1 >= i2 }
fun ifLessEqual(t1: Int, t2: Int) = ifValue(t1, t2) { i1, i2 -> i1 <= i2 }

