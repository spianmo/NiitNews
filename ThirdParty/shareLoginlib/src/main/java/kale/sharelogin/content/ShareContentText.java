package kale.sharelogin.content;


import androidx.annotation.NonNull;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:ShareContentText.java
 * @LastModified:2021/06/19 21:50:19
 */

/**
 * Created by echo on 5/18/15.
 * 分享文本内容
 */
public class ShareContentText implements ShareContent {

    private final String summary;

    /**
     * 给QQ、微博、微信使用
     *
     * @param summary 分享的文字内容
     */
    public ShareContentText(@NonNull String summary) {
        this.summary = summary;
    }

    @Override
    public int getType() {
        return ShareContentType.TEXT;
    }

    @Override
    public String getSummary() {
        return summary;
    }

}