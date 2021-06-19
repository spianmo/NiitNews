package kale.sharelogin.utils;


import androidx.annotation.CallSuper;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:IBaseListener.java
 * @LastModified:2021/06/19 21:50:19
 */

/**
 * @author Kale
 * @date 2018/9/10
 */
public interface IBaseListener {

    @CallSuper
    default void onError(String errorMsg) {
        SlUtils.printErr("login or share error:" + errorMsg);
        onComplete();
    }

    @CallSuper
    default void onCancel() {
        SlUtils.printLog("login or share canceled");
        onComplete();
    }

    default void onComplete() {

    }
}