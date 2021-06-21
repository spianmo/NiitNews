package com.kirito666.niitnews.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:Bling.java
 * @LastModified:2021/06/21 08:04:21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bling {
    long id;
    String splashPic;
    String bulletin;
    String bulletinLevel;
    boolean inMaintain;
    String oneTalk;
}
