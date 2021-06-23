/*
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:SearchPage.kt
 * @LastModified:2021/06/23 08:24:23
 */

package com.kirito666.niitnews.ui.search

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.chip.Chip
import com.kirito666.niitnews.BR
import com.kirito666.niitnews.R
import com.kirito666.niitnews.databinding.PageSearchBinding
import com.kirshi.framework.databinding.BaseBindingActivity
import com.kirshi.framework.databinding.DataBindingConfig


/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:SearchPage.java
 * @LastModified:2021/06/21 11:06:21
 */
class SearchPage : BaseBindingActivity<PageSearchBinding>() {

    private lateinit var mSearchViewModel: SearchViewModel

    override fun initViewModel() {
        mSearchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSearchViewModel.newsGroups.observe(this, { newsGroups ->
            var flag = true
            for (newsGroup in newsGroups) {
                val chip = layoutInflater.inflate(
                    R.layout.chip_group_item_choice,
                    v.reflowGroup,
                    false
                ) as Chip
                chip.text = newsGroup.name
                chip.isChecked = flag
                flag = false
                chip.setOnClickListener {

                }
                v.reflowGroup.addView(chip)
            }
        })
        initView()
    }


    fun initView() {
        v.etSearch.requestFocus()
        mSearchViewModel.fetchNewsGroup()
    }


    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(
            R.layout.page_search,
            BR.vm,
            mSearchViewModel
        )
            .addBindingParam(BR.click, ClickProxy())
    }

    inner class ClickProxy : Toolbar.OnMenuItemClickListener {

        fun changeSearchType(isNews: Boolean) {
            mSearchViewModel.isNews.set(isNews)
        }

        override fun onMenuItemClick(item: MenuItem): Boolean {
            return true
        }
    }
}