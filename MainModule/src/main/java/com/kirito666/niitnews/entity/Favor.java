package com.kirito666.niitnews.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:Favor.java
 * @LastModified:2021/06/19 16:18:19
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Favor {
    long id;
    long ownerId;
    long pid;
    Timestamp date;
}
