package com.kirito666.niitnews.ui.login;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.library.baseAdapters.BR;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.kirito666.niitnews.R;
import com.kirito666.niitnews.databinding.PageLoginBinding;
import com.kirito666.niitnews.entity.User;
import com.kirito666.niitnews.entity.base.BaseResponse;
import com.kirito666.niitnews.entity.base.HttpStatusCode;
import com.kirito666.niitnews.ui.posts.ForumHostFragment;
import com.kirito666.niitnews.ui.register.RegisterDialog;
import com.kirshi.framework.databinding.BaseBindingFragment;
import com.kirshi.framework.databinding.DataBindingConfig;

import org.jetbrains.annotations.NotNull;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:LoginFragment.java
 * @LastModified:2021/06/29 11:08:29
 */

public class LoginFragment extends BaseBindingFragment<PageLoginBinding> {

    LoginViewModel mLoginViewModel;

    @Override
    protected void initViewModel() {
        mLoginViewModel = new LoginViewModel();
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.page_login, BR.vm, mLoginViewModel)
                .addBindingParam(BR.click, new LoginFragment.ClickProxy());
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLoginViewModel.loginResponse.observe(getViewLifecycleOwner(), new Observer<BaseResponse<User>>() {
            @Override
            public void onChanged(BaseResponse<User> userBaseResponse) {
                if (userBaseResponse.getStatusCode() != 0) {
                    if (userBaseResponse.getStatusCode() == HttpStatusCode.SUCCESS.getStatus()) {
                        showSnackBar("登陆成功");
                        // TODO: 6/24/2021 more
                        Fragment parent = getParentFragment();
                        if (parent instanceof ForumHostFragment) {
                            ((ForumHostFragment) parent).switchChildFragment(true);
                        }
                    } else {
                        showSnackBar(HttpStatusCode.getMessageByStatusCode(userBaseResponse.getStatusCode()));
                    }
                }
            }
        });
    }

    public class ClickProxy implements Toolbar.OnMenuItemClickListener {

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            return true;
        }

        public void login() {
            String account = v.tvAccount.getText().toString();
            String password = v.tvPassword.getText().toString();
            if (TextUtils.isEmpty(account) || TextUtils.isEmpty(password)) {
                showSnackBar("账号或密码不能为空");
                return;
            }
            loginAction();
            mLoginViewModel.login(account, password);
        }

        private void loginAction() {
            v.progressBar.setVisibility(View.VISIBLE);
            v.fabLogin.setAlpha(0f);

            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                if (v == null) {
                    return;
                }
                v.progressBar.setVisibility(View.GONE);
                v.fabLogin.setAlpha(1f);
            }, 1000);
        }

        public void showRegisterDialog() {
            RegisterDialog dialog = new RegisterDialog();
            dialog.setOnRegisterCallback(new RegisterDialog.OnRegisterCallback() {
                @Override
                public void onSuccess() {
                    showSnackBar("注册成功, Welcome!");
                    Fragment parent = getParentFragment();
                    if (parent instanceof ForumHostFragment) {
                        ((ForumHostFragment) parent).switchChildFragment(true);
                    }
                }
            });
            dialog.show(mActivity.getSupportFragmentManager(), "RegisterDialog");
        }

        public void jumpPasswordReset() {
            showSnackBar("忘记密码Build...");
        }
    }

}