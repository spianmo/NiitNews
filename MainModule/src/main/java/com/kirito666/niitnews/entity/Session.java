package com.kirito666.niitnews.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:Session.java
 * @LastModified:2021/06/19 16:18:19
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Session {
    long uid;
    String superkey;
}
