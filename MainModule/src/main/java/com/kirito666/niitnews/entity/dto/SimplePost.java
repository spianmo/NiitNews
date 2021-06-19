package com.kirito666.niitnews.entity.dto;


import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:SimplePost.java
 * @LastModified:2021/06/19 16:18:19
 */

@Data
public class SimplePost {
    long pid;
    String title;
    Timestamp modifiedTime;
    String textSmp;
    long authorId;
    List<String> attachPic;
    long shareCount;
    long viewsNum;
    long favorCount;
    long commitCount;
    long parentPid;
    boolean allowComment;
}
