package com.kirito666.niitnews.entity.dto;


import com.kirito666.niitnews.entity.Commit;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:PostDto.java
 * @LastModified:2021/06/19 16:18:19
 */

@Data
public class PostDto {
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
    boolean isSourceAuthor;
    List<Commit> commits;
}
