package com.kirito666.niitnews.ui.main_frame;

import android.os.Bundle;
import android.view.Menu;

import androidx.fragment.app.Fragment;

import com.kirito666.niitnews.R;
import com.kirito666.niitnews.databinding.PageMainFrameBinding;
import com.kirito666.niitnews.service.HeartBeatService;
import com.kirshi.framework.BaseActivity;
import com.kirshi.framework.daemon.DaemonHolder;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:MainFrame.java
 * @LastModified:2021/06/21 03:15:21
 */

public class MainFrame extends BaseActivity<PageMainFrameBinding> {

    private ArrayList<Fragment> fragmentList = new ArrayList<>();

    MainPagerAdapter mainPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaemonHolder.init(this, HeartBeatService.class);

    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (menu != null) {
            if (menu.getClass().getSimpleName().equalsIgnoreCase("MenuBuilder")) {
                try {
                    Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke(menu, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_extra, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
