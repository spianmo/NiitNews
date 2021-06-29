package com.luck.picture.lib.listener;

import com.luck.picture.lib.entity.LocalMedia;

import java.util.List;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:OnAlbumItemClickListener.java
 * @LastModified:2021/06/29 17:27:29
 */

/**
 * @author：luck
 * @date：2020-03-26 10:57
 * @describe：OnAlbumItemClickListener
 */
public interface OnAlbumItemClickListener {
    /**
     * Album catalog item click event
     *
     * @param position
     * @param isCameraFolder
     * @param bucketId
     * @param folderName
     * @param data
     */
    void onItemClick(int position, boolean isCameraFolder,
                     long bucketId, String folderName, List<LocalMedia> data);
}
