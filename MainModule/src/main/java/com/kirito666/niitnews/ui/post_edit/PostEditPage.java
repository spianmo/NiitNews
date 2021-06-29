package com.kirito666.niitnews.ui.post_edit;

import android.os.Bundle;
import android.view.MenuItem;

import com.kirito666.niitnews.databinding.PagePostEditBinding;
import com.kirshi.framework.viewbinding.BaseActivity;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:PostEditPage.java
 * @LastModified:2021/06/29 14:06:29
 */

public class PostEditPage extends BaseActivity<PagePostEditBinding> {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(v.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        LOGE(item.toString());
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
