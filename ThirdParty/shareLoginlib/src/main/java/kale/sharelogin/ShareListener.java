package kale.sharelogin;


import androidx.annotation.CallSuper;

import kale.sharelogin.utils.IBaseListener;
import kale.sharelogin.utils.SlUtils;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:ShareListener.java
 * @LastModified:2021/06/29 02:16:29
 */

/**
 * @author Kale
 * @date 2018/9/10
 */
public class ShareListener implements IBaseListener {

    @CallSuper
    public void onSuccess() {
        SlUtils.printLog("share success");

        onComplete();
    }

}