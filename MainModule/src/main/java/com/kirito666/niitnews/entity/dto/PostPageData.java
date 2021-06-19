package com.kirito666.niitnews.entity.dto;

import java.util.List;

import lombok.Data;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:PostPageData.java
 * @LastModified:2021/06/19 16:18:19
 */

@Data
public class PostPageData {
    int pageId;
    int pageSize;
    int count;
    List<SimplePost> postData;
}
