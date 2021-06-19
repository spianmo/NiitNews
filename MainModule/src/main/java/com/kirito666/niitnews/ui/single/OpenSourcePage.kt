/*
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:OpenSourcePage.kt
 * @LastModified:2021/06/17 15:04:17
 */

package com.kirito666.niitnews.ui.single

import android.annotation.SuppressLint
import android.os.Bundle
import com.kirito666.niitnews.R
import com.mikepenz.aboutlibraries.LibsBuilder
import com.mikepenz.aboutlibraries.ui.LibsActivity

class OpenSourcePage : LibsActivity() {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        intent = LibsBuilder()
            .withSortEnabled(true)
            .withAutoDetect(false)
            .withFields(R.string::class.java.fields)
            .withActivityTitle("开源许可")
            .withAboutAppName("Open Source License")
            .withAboutIconShown(true)
            .withLicenseShown(true)
            .withLicenseDialog(true)
            .withSearchEnabled(true)
            .withAboutMinimalDesign(true)
            .withEdgeToEdge(true)
            .intent(this)
        this.window.setBackgroundDrawable(getDrawable(R.drawable.window_bg_white))
        super.onCreate(savedInstanceState)
    }
}