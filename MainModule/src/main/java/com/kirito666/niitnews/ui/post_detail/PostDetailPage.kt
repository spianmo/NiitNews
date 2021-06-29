/*
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:PostDetailPage.kt
 * @LastModified:2021/06/30 06:37:30
 */

package com.kirito666.niitnews.ui.post_detail

import android.content.Intent
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
import com.kirito666.niitnews.entity.RepositoryCallback
import com.kirito666.niitnews.entity.base.HttpStatusCode
import com.kirito666.niitnews.entity.dto.CommitDto
import com.kirito666.niitnews.entity.dto.SimplePost
import com.kirito666.niitnews.ui.post_detail.adapter.CommitListAdapter
import com.kirito666.niitnews.ui.profile.ProfilePage
import com.kirito666.niitnews.util.Tools
import com.kirshi.framework.databinding.BaseBindingActivity
import com.kirshi.framework.databinding.DataBindingConfig
import com.peanut.sdk.miuidialog.MIUIDialog

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:PostDetailActivity.java
 * @LastModified:2021/06/21 03:15:21
 */
class PostDetailPage : BaseBindingActivity<PagePostDetailBinding>() {
    private lateinit var simplePost: SimplePost
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

    override fun beforeInitViewModel() {
        simplePost = intent.getSerializableExtra("post") as SimplePost
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycle.addObserver(mPostDetailViewModel)
        v.toolbar.title = "动态详情"
        setSupportActionBar(v.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        v.toolbar.setNavigationOnClickListener { finish() }
        v.btnFavorBling.setChecked(simplePost.isFavor, false)
        v.recyclerView.layoutManager = LinearLayoutManager(baseContext)
        v.recyclerView.setHasFixedSize(true)

        mAdapter = CommitListAdapter(baseContext, mPostDetailViewModel.post.value?.commits)
        mAdapter.setOnItemClickListener(object : CommitListAdapter.OnItemClickListener {
            override fun onEnterCommitOwnerPofile(view: View?, ownerId: Int, position: Int) {
                val intent = Intent(this@PostDetailPage, ProfilePage::class.java)
                intent.putExtra("uid", ownerId)
                startActivity(intent)
            }

            override fun onReplyCommit(view: View?, commit: CommitDto, position: Int) {
                showCommitDialog(commit.cid.toInt())
            }

            override fun onDeleteCommit(view: View?, obj: CommitDto?, position: Int) {
                mPostDetailViewModel.deleteCommit(obj!!.cid.toInt(),
                    object : RepositoryCallback<String> {
                        override fun onSuccess(data: String) {
                            showSnackBar("评论已删除")
                        }

                        override fun onFailure(code: HttpStatusCode) {
                            showSnackBar("评论删除失败")
                        }

                        override fun onError(throwable: Throwable) {
                            showSnackBar(throwable.toString())
                        }
                    })
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

    fun showCommitDialog(parentCid: Int) {
        MIUIDialog(this@PostDetailPage).show {
            title(text = "发表评论")
            input(
                hint = "请输入你的评论"
            ) { it, _ ->
                mPostDetailViewModel.sendCommit(
                    parentCid, it.toString(),
                    object : RepositoryCallback<String> {
                        override fun onSuccess(data: String?) {
                            mPostDetailViewModel.getPostDetail()
                        }

                        override fun onFailure(code: HttpStatusCode) {
                            showSnackBar("评论发表失败")
                        }

                        override fun onError(throwable: Throwable) {
                            showSnackBar(throwable.toString())
                        }
                    })
            }
            positiveButton(text = "发表") { }
            negativeButton(text = "取消") { }
        }
    }

    inner class ClickProxy : Toolbar.OnMenuItemClickListener {

        fun sharePost() {
            Tools.share(
                baseContext,
                mPostDetailViewModel.post.value!!.title,
                mPostDetailViewModel.post.value!!.text
            )
        }

        fun forwardPost() {
            mPostDetailViewModel.forwardPost(
                simplePost.pid.toInt(),
                object : RepositoryCallback<String> {
                    override fun onSuccess(data: String) {
                        showSnackBar("转发成功")
                    }

                    override fun onFailure(code: HttpStatusCode) {
                        showSnackBar("转发失败")
                    }

                    override fun onError(throwable: Throwable) {
                        showSnackBar(throwable.toString())
                    }
                })
        }

        fun favorPost() {
            if (simplePost.isFavor) {
                mPostDetailViewModel.favorPost(
                    simplePost.pid.toInt(),
                    object : RepositoryCallback<String> {
                        override fun onSuccess(data: String?) {
                            mPostDetailViewModel.getPostDetail()
                        }

                        override fun onFailure(code: HttpStatusCode) {
                            showSnackBar("点赞失败")
                            v.btnFavorBling.setChecked(false, false)
                        }

                        override fun onError(throwable: Throwable) {
                            showSnackBar(throwable.toString())
                        }
                    })
            } else {
                mPostDetailViewModel.deleteFavor(
                    simplePost.pid.toInt(),
                    object : RepositoryCallback<String> {
                        override fun onSuccess(data: String?) {
                            mPostDetailViewModel.getPostDetail()
                        }

                        override fun onFailure(code: HttpStatusCode) {
                            showSnackBar("取消点赞失败")
                            v.btnFavorBling.setChecked(true, false)
                        }

                        override fun onError(throwable: Throwable) {
                            showSnackBar(throwable.toString())
                        }
                    })
            }
        }

        fun sendCommit() {
            showCommitDialog(0)
        }

        override fun onMenuItemClick(item: MenuItem): Boolean {
            return true
        }
    }

}