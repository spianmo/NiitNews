/*
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:ExpandableIconStyles.kt
 * @LastModified:2021/06/17 14:56:17
 */

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:ExpandableIconStyles.kt
 * @LastModified:2021/04/08 19:48:08
 */

package com.kirshi.freya.ui.component

enum class ExpandableIconStyles {
    SQUARE, CIRCLE, ROUNDED_SQUARE;

    companion object {
        fun getByIndex(index: Int): ExpandableIconStyles {
            return when (index) {
                CIRCLE.ordinal -> CIRCLE
                ROUNDED_SQUARE.ordinal -> ROUNDED_SQUARE
                else -> SQUARE
            }
        }
    }
}