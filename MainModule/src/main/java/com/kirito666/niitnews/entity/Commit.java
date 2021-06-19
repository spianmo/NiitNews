package com.kirito666.niitnews.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:Commit.java
 * @LastModified:2021/06/19 16:18:19
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Commit {
    long cid;
    long ownerId;
    long pid;
    String text;
    long parentCid;
}
