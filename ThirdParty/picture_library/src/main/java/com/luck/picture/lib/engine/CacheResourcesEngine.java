package com.luck.picture.lib.engine;

import android.content.Context;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:CacheResourcesEngine.java
 * @LastModified:2021/06/29 17:27:29
 */

/**
 * @author：luck
 * @date：2020-03-24 09:36
 * @describe：CacheResourcesEngine
 */
public interface CacheResourcesEngine {
    /**
     * Get the cache path
     *
     * @param context
     * @param url
     */
    String onCachePath(Context context, String url);
}
