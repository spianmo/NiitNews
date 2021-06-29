package com.luck.picture.lib.compress;

import com.luck.picture.lib.entity.LocalMedia;

import java.io.IOException;
import java.io.InputStream;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:InputStreamProvider.java
 * @LastModified:2021/06/29 17:27:29
 */

/**
 * 通过此接口获取输入流，以兼容文件、FileProvider方式获取到的图片
 * <p>
 * Get the input stream through this interface, and obtain the picture using compatible files and FileProvider
 */
public interface InputStreamProvider {

    InputStream open() throws IOException;

    void close();

    String getPath();

    LocalMedia getMedia();

}
