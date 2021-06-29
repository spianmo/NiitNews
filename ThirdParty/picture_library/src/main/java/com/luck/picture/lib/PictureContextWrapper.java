package com.luck.picture.lib;

import android.content.Context;
import android.content.ContextWrapper;

import com.luck.picture.lib.language.PictureLanguageUtils;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:PictureContextWrapper.java
 * @LastModified:2021/06/29 17:27:29
 */

/**
 * @author：luck
 * @date：2019-12-15 19:34
 * @describe：ContextWrapper
 */
public class PictureContextWrapper extends ContextWrapper {

    public PictureContextWrapper(Context base) {
        super(base);
    }

    public static ContextWrapper wrap(Context context, int language) {
        PictureLanguageUtils.setAppLanguage(context, language);
        return new PictureContextWrapper(context);
    }
}
