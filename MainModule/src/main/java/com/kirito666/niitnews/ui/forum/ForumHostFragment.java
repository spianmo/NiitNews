package com.kirito666.niitnews.ui.forum;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.kirito666.niitnews.App;
import com.kirito666.niitnews.R;
import com.kirito666.niitnews.databinding.FragmentForumHostBinding;
import com.kirito666.niitnews.ui.login.LoginFragment;
import com.kirshi.framework.viewbinding.BaseFragment;

import org.jetbrains.annotations.NotNull;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:ForumHostFragment.java
 * @LastModified:2021/06/24 14:06:24
 */

public class ForumHostFragment extends BaseFragment<FragmentForumHostBinding> {

    LoginFragment loginFragment;
    ForumFragment forumFragment;
    boolean isSnackToast = false;

    @Override
    public void inCreateView() {
        loginFragment = new LoginFragment();
        forumFragment = new ForumFragment();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (App.currentUser == null) {
            getChildFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, loginFragment)
                    .commit();
        } else {
            getChildFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, forumFragment)
                    .commit();
        }
    }

    public void switchChildFragment(boolean switchForum) {
        getChildFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.fragment_enter, R.anim.fragment_exit)
                .replace(R.id.fragment_container, switchForum ? forumFragment : loginFragment)
                .commit();
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            if (App.currentUser == null && !isSnackToast) {
                isSnackToast = true;
                showSnackBar("登录后使用校园圈子功能(*^▽^*)");
            }
        }
    }
}