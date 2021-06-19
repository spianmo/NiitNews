/*
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:AboutPage.kt
 * @LastModified:2021/06/17 16:57:17
 */

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:AboutPage.kt
 * @LastModified:2021/04/14 02:07:14
 */

package com.kirito666.niitnews.ui.single;

import android.os.Bundle
import com.kirito666.niitnews.BuildConfig
import com.kirito666.niitnews.R

import com.mikepenz.aboutlibraries.LibsBuilder
import com.mikepenz.aboutlibraries.ui.LibsActivity

/**
 * Copyright (c) 2021
 * @Project:Freya
 * @Author:Finger
 * @FileName:AboutPage.java
 * @LastModified:2021-03-29T19:16:39.650+08:00
 */

class AboutPage : LibsActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        intent = LibsBuilder()
            .withSortEnabled(true)
            .withAutoDetect(false)
            .withFields(R.string::class.java.fields)
            .withActivityTitle("关于本软件")
            .withAboutAppName("NiitNews")
            .withLicenseShown(true)
            .withLicenseDialog(true)
            .withAboutDescription("应用Jetpack组件的ViewModel新闻App")
            .withAboutVersionString("Version: " + BuildConfig.VERSION_NAME)
            .withSearchEnabled(true)
            .withEdgeToEdge(true)
            .withAboutSpecial1("更新日志")
            .withAboutSpecial2("检查更新")
            .withAboutSpecial3("Github")
            .intent(this)
        this.window.setBackgroundDrawable(getDrawable(R.drawable.window_bg_white))
        super.onCreate(savedInstanceState)
    }
}