package com.kirito666.niitnews.entity.dto;

import com.kirito666.niitnews.entity.News;

import java.util.List;

import lombok.Data;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:NewsPageData.java
 * @LastModified:2021/06/21 08:04:21
 */

@Data
public class NewsPageData {
    int pageId;
    int pageSize;
    int count;
    List<News> newsData;
}
