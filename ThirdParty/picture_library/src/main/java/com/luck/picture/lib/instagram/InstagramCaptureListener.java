package com.luck.picture.lib.instagram;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:InstagramCaptureListener.java
 * @LastModified:2021/06/29 17:27:29
 */

/**
 * ================================================
 * Created by JessYan on 2020/4/20 15:45
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public interface InstagramCaptureListener {
    void takePictures();

    void recordStart();

    void recordEnd(long time);

    void recordShort(long time);

    void recordError();
}
