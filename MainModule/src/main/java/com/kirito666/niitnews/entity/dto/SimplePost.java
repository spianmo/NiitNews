package com.kirito666.niitnews.entity.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.Builder;
import lombok.Data;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:SimplePost.java
 * @LastModified:2021/06/21 08:04:21
 */

@Data
@Builder
public class SimplePost {
    long pid;
    String title;
    Timestamp modifiedTime;
    Timestamp createdTime;
    String textSmp;
    long authorId;
    List<String> attachPic;
    long shareCount;
    long viewsNum;
    long favorCount;
    long commitCount;
    long parentPid;
    boolean isFavor;
    boolean allowComment;
}
