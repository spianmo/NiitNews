package com.luck.picture.lib.instagram;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:OnPageChangeListener.java
 * @LastModified:2021/06/29 20:53:29
 */

/**
 * ================================================
 * Created by JessYan on 2020/4/15 18:07
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public interface OnPageChangeListener {
    void onPageScrolled(int position, float positionOffset, int positionOffsetPixels);

    void onPageSelected(int position);
}
