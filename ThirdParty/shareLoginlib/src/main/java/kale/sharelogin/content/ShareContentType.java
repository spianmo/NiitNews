package kale.sharelogin.content;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:ShareContentType.java
 * @LastModified:2021/06/19 21:50:19
 */

/**
 * Created by echo on 5/18/15.
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef({ShareContentType.TEXT, ShareContentType.PIC, ShareContentType.WEBPAGE, ShareContentType.MUSIC, ShareContent.NO_CONTENT})
public @interface ShareContentType {

    int TEXT = 1, PIC = 2, WEBPAGE = 3, MUSIC = 4;
}