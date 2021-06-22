package com.kirito666.niitnews.ui.main_frame;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.kirito666.niitnews.R;
import com.kirito666.niitnews.databinding.PageMainFrameBinding;
import com.kirito666.niitnews.service.HeartBeatService;
import com.kirito666.niitnews.ui.forum.ForumFragment;
import com.kirito666.niitnews.ui.news.NewsFragment;
import com.kirito666.niitnews.ui.rank.RankFragment;
import com.kirito666.niitnews.ui.search.SearchPage;
import com.kirito666.niitnews.util.Tools;
import com.kirshi.framework.daemon.DaemonHolder;
import com.kirshi.framework.viewbinding.BaseActivity;

import java.lang.reflect.Method;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:MainFrame.java
 * @LastModified:2021/06/22 08:23:22
 */

public class MainFrame extends BaseActivity<PageMainFrameBinding> {

    private SparseArray<Fragment> fragmentList = new SparseArray<>();

    MainPagerAdapter mainPagerAdapter;

    Fragment newsFragment = new NewsFragment();
    Fragment rankFragment = new RankFragment();
    Fragment forumFragment = new ForumFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaemonHolder.init(this, HeartBeatService.class);
        initToolbar();
        v.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                LOGE("===>" + position);
                v.floatingActionButton.setVisibility(position == 2 ? View.VISIBLE : View.GONE);
                v.navigation.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        v.navView.setNavigationItemSelectedListener(item -> {
            final int id = item.getItemId();
            switch (id) {
                case R.id.navigation_news:
                    v.viewPager.setCurrentItem(0);
                    break;
                case R.id.navigation_rank:
                    v.viewPager.setCurrentItem(1);
                    break;
                case R.id.navigation_posts:
                    v.viewPager.setCurrentItem(3);
                    break;
            }
            v.drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
        v.navigation.setOnNavigationItemSelectedListener(item -> {
            v.toolbar.setSubtitle(item.getTitle());
            switch (item.getItemId()) {
                case R.id.navigation_news:
                    v.viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_rank:
                    v.viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_posts:
                    v.viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        });
        fragmentList.append(0, newsFragment);
        fragmentList.append(1, rankFragment);
        fragmentList.append(2, forumFragment);
        mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), fragmentList);
        v.viewPager.setOffscreenPageLimit(mainPagerAdapter.getCount() - 1);
        v.viewPager.setAdapter(mainPagerAdapter);
        //绑定抽屉布局
        bindNavigationDrawer();
    }

    private void initToolbar() {
        v.toolbar.setNavigationIcon(R.drawable.ic_notes);
        setSupportActionBar(v.toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Tools.setSystemBarColor(this, R.color.grey_5);
        Tools.setSystemBarLight(this);
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
        Tools.changeMenuIconColor(menu, getResources().getColor(R.color.grey_80));
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                startActivity(new Intent(mContext, SearchPage.class));
                break;
            case R.id.action_about:
                new MaterialAlertDialogBuilder(mContext)
                        .setTitle("About")
                        .setIcon(R.drawable.ic_baseline_code_24)
                        .setMessage("Finger@spianmo.com")
                        .setNegativeButton("Cancel", (dialog, which) -> {

                        })
                        .setPositiveButton("OK", (dialog, which) -> {

                        })
                        .show();
                break;
        }
        return true;
    }

    private void bindNavigationDrawer() {
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, v.drawerLayout, v.toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        v.drawerLayout.addDrawerListener(toggle);
        v.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                v.navigation.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        v.navView.setNavigationItemSelectedListener(item -> {
            final int id = item.getItemId();
            switch (id) {
                case R.id.nav_home:
                    v.viewPager.setCurrentItem(0);
                    showSnackBar("nav_home");
                    break;
                case R.id.nav_dashboard:
                    v.viewPager.setCurrentItem(1);
                    showSnackBar("nav_dashboard");
                    break;
                case R.id.nav_notification:
                    v.viewPager.setCurrentItem(3);
                    showSnackBar("nav_notification");
                    break;
                case R.id.nav_share:
                    showSnackBar("nav_share");
                    break;
                case R.id.nav_setting:
                    showSnackBar("nav_setting");
                    break;
            }
            v.drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

    }

}
