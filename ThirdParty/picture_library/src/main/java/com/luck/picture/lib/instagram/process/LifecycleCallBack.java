package com.luck.picture.lib.instagram.process;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:LifecycleCallBack.java
 * @LastModified:2021/06/29 20:53:29
 */

/**
 * ================================================
 * Created by JessYan on 2020/6/18 16:52
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public interface LifecycleCallBack {
    void onStart(InstagramMediaProcessActivity activity);

    void onResume(InstagramMediaProcessActivity activity);

    void onPause(InstagramMediaProcessActivity activity);

    void onDestroy(InstagramMediaProcessActivity activity);
}
