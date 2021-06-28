package com.kirito666.niitnews.ui.forum;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.kirito666.niitnews.databinding.FragmentForumBinding;
import com.kirito666.niitnews.ui.forum.adapter.ForumPageAdapter;
import com.kirshi.framework.viewbinding.BaseFragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:ForumFragment.java
 * @LastModified:2021/06/28 12:54:28
 */

public class ForumFragment extends BaseFragment<FragmentForumBinding> {

    ForumPageAdapter forumPageAdapter;
    SparseArray<ForumChildFragment> mForumChildFragments;
    private static final HashMap<String, Boolean> FORUM_TYPE = new HashMap<String, Boolean>() {
        {
            put("校园广场", true);
            put("朋友圈", false);
        }
    };

    @Override
    public void inCreateView() {
        mForumChildFragments = new SparseArray<>();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mForumChildFragments.size() == 0) {
            List<String> titles = new ArrayList<>();
            int count = 0;
            for (String forum : FORUM_TYPE.keySet()) {
                count++;
                titles.add(forum);
                mForumChildFragments.append(count, new ForumChildFragment(FORUM_TYPE.get(forum)));
            }
            forumPageAdapter = new ForumPageAdapter(getChildFragmentManager(), titles, mForumChildFragments);
            v.viewPager.setAdapter(forumPageAdapter);
            v.viewPager.setOffscreenPageLimit(forumPageAdapter.getCount() - 1);
            v.tabLayout.setupWithViewPager(v.viewPager);
        }
    }
}
