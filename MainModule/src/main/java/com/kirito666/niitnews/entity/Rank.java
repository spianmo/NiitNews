package com.kirito666.niitnews.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:Rank.java
 * @LastModified:2021/06/19 16:18:19
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rank {
    long rid;
    String title;
    long score;
    long pid;
    boolean visible;
}
