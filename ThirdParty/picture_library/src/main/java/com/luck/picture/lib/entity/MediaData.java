package com.luck.picture.lib.entity;

import java.util.List;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:MediaData.java
 * @LastModified:2021/06/29 17:27:29
 */

/**
 * @author：luck
 * @date：2020-04-17 13:52
 * @describe：MediaData
 */
public class MediaData {

    /**
     * Is there more
     */
    public boolean isHasNextMore;

    /**
     * data
     */
    public List<LocalMedia> data;


    public MediaData() {
        super();
    }

    public MediaData(boolean isHasNextMore, List<LocalMedia> data) {
        super();
        this.isHasNextMore = isHasNextMore;
        this.data = data;
    }
}
