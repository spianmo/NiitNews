package com.kirito666.niitnews.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:Friend.java
 * @LastModified:2021/06/21 08:04:21
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Friend {
    long uid;
    long friendId;
    String remark;
}
