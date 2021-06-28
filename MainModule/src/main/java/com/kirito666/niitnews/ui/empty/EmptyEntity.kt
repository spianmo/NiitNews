/*
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:EmptyEntity.kt
 * @LastModified:2021/06/28 20:03:28
 */

package com.kirito666.niitnews.ui.empty

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes

data class EmptyEntity(@RawRes @DrawableRes var resId: Int, var desc: String)
