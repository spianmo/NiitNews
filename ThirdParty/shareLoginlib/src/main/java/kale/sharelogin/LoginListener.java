package kale.sharelogin;


import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import kale.sharelogin.utils.IBaseListener;
import kale.sharelogin.utils.SlUtils;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:LoginListener.java
 * @LastModified:2021/06/29 02:16:29
 */

/**
 * @author Kale
 * @date 2018/9/10
 */
public class LoginListener implements IBaseListener {

    /**
     * @param accessToken 第三方给的一次性token，几分钟内会失效
     * @param uId         用户的id
     * @param expiresIn   过期时间
     * @param wholeData   第三方本身返回的全部数据
     */
    @CallSuper
    public void onReceiveToken(String accessToken, String uId, long expiresIn, @Nullable String wholeData) {
        SlUtils.printLog("login success \naccessToken = " + accessToken + "\nuserId = " + uId + "\nexpires_in = " + expiresIn);
    }

    /**
     * 得到第三方平台的用户信息
     * <p>
     * 本库希望不要获取太多的用户信息，故{OAuthUserInfo}仅提供基础的信息，如果不满足请请提交{issue}
     */
    public void onReceiveUserInfo(@NonNull OAuthUserInfo userInfo) {
        SlUtils.printLog("nickname = " + userInfo.nickName + "\nsex = " + userInfo.sex + "\nid = " + userInfo.userId);
        onComplete();
    }
}