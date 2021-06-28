package com.kirshi.framework.databinding;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:BaseBindingFragment.java
 * @LastModified:2021/06/29 02:16:29
 */

public abstract class BaseBindingFragment<Binding extends ViewDataBinding> extends Fragment {

    protected AppCompatActivity mActivity;
    protected Binding v;
    Handler mainHandler;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity = (AppCompatActivity) context;
    }

    protected abstract void initViewModel();

    protected abstract DataBindingConfig getDataBindingConfig();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewModel();
    }


    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {

        DataBindingConfig dataBindingConfig = getDataBindingConfig();

        v = DataBindingUtil.inflate(inflater, dataBindingConfig.getLayout(), container, false);
        v.setLifecycleOwner(this);
        v.setVariable(dataBindingConfig.getVmVariableId(), dataBindingConfig.getStateViewModel());
        SparseArray bindingParams = dataBindingConfig.getBindingParams();
        for (int i = 0, length = bindingParams.size(); i < length; i++) {
            v.setVariable(bindingParams.keyAt(i), bindingParams.valueAt(i));
        }
        return v.getRoot();
    }

    protected void toggleSoftInput() {
        InputMethodManager imm = (InputMethodManager) mActivity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    protected void openUrlInBrowser(String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    protected void showLongToast(String text) {
        Toast.makeText(mActivity, text, Toast.LENGTH_LONG).show();
    }

    protected void showShortToast(String text) {
        Toast.makeText(mActivity, text, Toast.LENGTH_SHORT).show();
    }

    protected void showLongToast(int stringRes) {
        showLongToast(mActivity.getString(stringRes));
    }

    protected void showShortToast(int stringRes) {
        showShortToast(mActivity.getString(stringRes));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        v.unbind();
        v = null;
    }

    public void runOnUI(Runnable runnable) {
        mainHandler = new Handler(Looper.getMainLooper());
        mainHandler.post(runnable);
    }

    public Snackbar showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(v.getRoot(), message, Snackbar.LENGTH_SHORT);
        runOnUI(snackbar::show);
        return snackbar;
    }

}
