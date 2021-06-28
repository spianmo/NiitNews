package com.kirito666.niitnews.ui.forum;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.kirito666.niitnews.R;
import com.kirito666.niitnews.databinding.FragmentForumBinding;
import com.kirito666.niitnews.ui.empty.EmptyEntity;
import com.kirito666.niitnews.ui.forum.adapter.ForumPageAdapter;
import com.kirshi.framework.viewbinding.BaseFragment;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:ForumFragment.java
 * @LastModified:2021/06/28 20:03:28
 */

public class ForumFragment extends BaseFragment<FragmentForumBinding> {

    ForumPageAdapter forumPageAdapter;
    SparseArray<ForumChildFragment> mForumChildFragments;


    @Override
    public void inCreateView() {
        mForumChildFragments = new SparseArray<>();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mForumChildFragments.size() == 0) {
            mForumChildFragments.append(1, new ForumChildFragment(true, new EmptyEntity(R.drawable.ic_empty_font, "广场空空荡荡~")));
            mForumChildFragments.append(2, new ForumChildFragment(false, new EmptyEntity(R.drawable.ic_empty, "空空如也~")));
            forumPageAdapter = new ForumPageAdapter(getChildFragmentManager(), Arrays.asList("校园广场", "朋友圈"), mForumChildFragments);
            v.viewPager.setAdapter(forumPageAdapter);
            v.viewPager.setOffscreenPageLimit(forumPageAdapter.getCount() - 1);
            v.tabLayout.setupWithViewPager(v.viewPager);
        }
    }
}
