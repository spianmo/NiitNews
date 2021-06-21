package com.kirito666.niitnews.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:Rank.java
 * @LastModified:2021/06/21 08:04:21
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Rank {
    String title;
    String desc;
    long score;
    long pid;
    boolean visible;
}
