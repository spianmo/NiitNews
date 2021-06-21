package com.kirito666.niitnews.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:Application.java
 * @LastModified:2021/06/21 08:04:21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Application {
    long id;
    String md5;
    String signature;
    String updateMsg;
    long versionCode;
    String versionName;
    Timestamp releaseTime;
}
