package com.kirito666.niitnews.entity;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:Post.java
 * @LastModified:2021/06/19 16:18:19
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    long pid;
    String title;
    Timestamp createTime;
    Timestamp modifiedTime;
    String text;
    long authorId;
    List<String> attachPic;
    long shareCount;
    long viewsNum;
    long favorCount;
    long commitCount;
    long parentPid;
    boolean allowComment;
    boolean allowFeed;
}
