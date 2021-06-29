/*
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:PostDetailPage.kt
 * @LastModified:2021/06/29 10:37:29
 */

package com.kirito666.niitnews.ui.post_detail

import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.kirito666.niitnews.BR
import com.kirito666.niitnews.R
import com.kirito666.niitnews.databinding.PagePostDetailBinding
import com.kirito666.niitnews.entity.dto.CommitDto
import com.kirito666.niitnews.entity.dto.SimplePost
import com.kirito666.niitnews.ui.post_detail.adapter.CommitListAdapter
import com.kirshi.framework.databinding.BaseBindingActivity
import com.kirshi.framework.databinding.DataBindingConfig

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:PostDetailActivity.java
 * @LastModified:2021/06/21 03:15:21
 */
class PostDetailPage : BaseBindingActivity<PagePostDetailBinding>() {
    private val simplePost: SimplePost = intent!!.getSerializableExtra("post") as SimplePost
    private lateinit var mPostDetailViewModel: PostDetailViewModel
    private lateinit var mAdapter: CommitListAdapter
    override fun initViewModel() {
        mPostDetailViewModel =
            PostDetailViewModel(simplePost.pid.toInt())
    }

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(
            R.layout.page_post_detail,
            BR.vm,
            mPostDetailViewModel
        )
            .addBindingParam(BR.click, ClickProxy())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(mPostDetailViewModel)
        v.toolbar.title = "动态详情"
        setSupportActionBar(v.toolbar)
        v.toolbar.background.alpha = 255
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
        v.recyclerView.layoutManager = LinearLayoutManager(baseContext)
        v.recyclerView.setHasFixedSize(true)
        mAdapter = CommitListAdapter(baseContext, mPostDetailViewModel.post.getValue()!!.commits)
        mAdapter.setOnItemClickListener(object : CommitListAdapter.OnItemClickListener {
            override fun onEnterCommitOwnerPofile(view: View?, ownerId: Int, position: Int) {
                // TODO: 6/29/2021 进入他人主页
            }

            override fun onReplyCommit(view: View?, obj: CommitDto?, position: Int) {
                // TODO: 6/29/2021 回复评论
            }

            override fun onDeleteCommit(view: View?, obj: CommitDto?, position: Int) {
                // TODO: 6/29/2021 删除评论
            }

        })

        v.recyclerView.adapter = mAdapter
        mPostDetailViewModel.post.observe(this, Observer {
            mAdapter.notifyDataSetChanged()
            v.refreshLayout.isRefreshing = false
        })

        v.refreshLayout.setColorSchemeResources(
            R.color.google_blue,
            R.color.google_green, R.color.google_yellow,
            R.color.google_red
        )
        v.refreshLayout.setDistanceToTriggerSync(300)
        v.refreshLayout.setProgressBackgroundColorSchemeColor(Color.WHITE)
        v.refreshLayout.setOnRefreshListener {
            v.refreshLayout.isRefreshing = true
            if (v != null) {
                mPostDetailViewModel.getPostDetail()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    inner class ClickProxy : Toolbar.OnMenuItemClickListener {

        override fun onMenuItemClick(item: MenuItem): Boolean {
            return true
        }
    }
}