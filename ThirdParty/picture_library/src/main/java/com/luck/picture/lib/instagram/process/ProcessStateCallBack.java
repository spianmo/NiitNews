package com.luck.picture.lib.instagram.process;

import android.content.Intent;
import android.widget.ImageView;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:ProcessStateCallBack.java
 * @LastModified:2021/06/29 20:53:29
 */

/**
 * ================================================
 * Created by JessYan on 2020/6/11 17:04
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public interface ProcessStateCallBack {
    void onBack(InstagramMediaProcessActivity activity);

    void onCenterFeature(InstagramMediaProcessActivity activity, ImageView view);

    void onProcess(InstagramMediaProcessActivity activity);

    void onActivityResult(InstagramMediaProcessActivity activity, int requestCode, int resultCode, Intent data);
}
