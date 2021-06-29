package com.kirito666.niitnews.ui.posts.adapter;

import android.util.Log;
import android.util.SparseArray;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.kirito666.niitnews.ui.posts.ForumChildFragment;

import java.util.List;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:ForumPageAdapter.java
 * @LastModified:2021/06/29 11:08:29
 */

public class ForumPageAdapter extends FragmentStatePagerAdapter {
    private SparseArray<ForumChildFragment> mFragments;
    private List<String> mTitles;

    public ForumPageAdapter(FragmentManager fm, List<String> titles, SparseArray<ForumChildFragment> mFragments) {
        super(fm);
        mTitles = titles;
        this.mFragments = mFragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Log.e("####################", "getItem" + position);
        return mFragments.valueAt(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Log.e("####################", "instantiateItem" + position);
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;


    }

    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.setPrimaryItem(container, position, object);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}