/*
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:NewsDetailPage.kt
 * @LastModified:2021/06/29 01:31:29
 */

package com.kirito666.niitnews.ui.single

import android.R
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.MenuItem
import android.view.View
import android.view.Window
import androidx.annotation.RequiresApi
import com.google.android.material.color.MaterialColors
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.kirito666.niitnews.databinding.PageNewsDetailBinding
import com.kirito666.niitnews.entity.News
import com.kirito666.niitnews.util.Tools
import com.kirshi.framework.viewbinding.KBaseActivity

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:NewsDetailPage.java
 * @LastModified:2021/06/22 08:12:22
 */
class NewsDetailPage : KBaseActivity<PageNewsDetailBinding>() {
    private val duration: Long = 400

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        findViewById<View>(R.id.content).transitionName = "EXTRA_VIEW"
        //setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        //window.sharedElementEnterTransition = buildContainerTransform(true)
        //window.sharedElementReturnTransition = buildContainerTransform(false)
        super.onCreate(savedInstanceState)
        val news = intent.getSerializableExtra("news") as News?
        LOGE(news.toString())
        Tools.displayImageOriginal(mContext, v.image, news!!.coverImg)
        v.name.text = news.title
        v.tvContent.text = Html.fromHtml(news.content)
        initToolbar()

        v.fab.setOnClickListener {
            Tools.share(this@NewsDetailPage, news.sourceUrl, news.title)
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private fun buildContainerTransform(entering: Boolean): MaterialContainerTransform {
        val transform = MaterialContainerTransform()
        transform.transitionDirection =
            if (entering) MaterialContainerTransform.TRANSITION_DIRECTION_ENTER else MaterialContainerTransform.TRANSITION_DIRECTION_RETURN
        transform.setAllContainerColors(
            MaterialColors.getColor(
                findViewById(R.id.content),
                com.google.android.material.R.attr.colorSurface
            )
        )
        transform.addTarget(R.id.content)
        transform.duration = duration
        return transform
    }

    private fun initToolbar() {
        setSupportActionBar(v.toolbar)
        supportActionBar!!.title = ""
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.home) {
            super.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}