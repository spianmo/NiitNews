package com.kirshi.framework.databinding;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:BaseBindingActivity.java
 * @LastModified:2021/06/21 22:11:21
 */

public abstract class BaseBindingActivity<Binding extends ViewDataBinding> extends AppCompatActivity {
    protected Binding v;

    protected abstract void initViewModel();

    protected abstract DataBindingConfig getDataBindingConfig();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewModel();
        DataBindingConfig dataBindingConfig = getDataBindingConfig();
        v = (Binding) DataBindingUtil.setContentView(this, dataBindingConfig.getLayout());
        setContentView(((ViewDataBinding) v).getRoot());
        v.setLifecycleOwner(this);
        v.setVariable(dataBindingConfig.getVmVariableId(), dataBindingConfig.getStateViewModel());
        SparseArray bindingParams = dataBindingConfig.getBindingParams();
        for (int i = 0, length = bindingParams.size(); i < length; i++) {
            v.setVariable(bindingParams.keyAt(i), bindingParams.valueAt(i));
        }
    }

    protected void toggleSoftInput() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    protected void openUrlInBrowser(String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    protected void showLongToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }

    protected void showShortToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    protected void showLongToast(int stringRes) {
        showLongToast(getApplicationContext().getString(stringRes));
    }

    protected void showShortToast(int stringRes) {
        showShortToast(getApplicationContext().getString(stringRes));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        v.unbind();
        v = null;
    }

}