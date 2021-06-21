package com.kirito666.niitnews.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:News.java
 * @LastModified:2021/06/21 08:04:21
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class News {
    long id;
    String title;
    String hint;
    String content;
    Timestamp postTime;
    long authorId;
    long groupId;
    String coverImg;
    int visitCount;
    String feedSource;
    String sourceUrl;
}
