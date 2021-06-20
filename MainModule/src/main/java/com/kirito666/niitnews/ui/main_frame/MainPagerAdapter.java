package com.kirito666.niitnews.ui.main_frame;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:MainPagerAdapter.java
 * @LastModified:2021/06/20 00:29:20
 */

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> fragments;

    public MainPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }


    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
