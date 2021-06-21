package com.kirito666.niitnews.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:Favor.java
 * @LastModified:2021/06/21 08:04:21
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Favor {
    long id;
    long ownerId;
    long pid;
    Timestamp date;
}
