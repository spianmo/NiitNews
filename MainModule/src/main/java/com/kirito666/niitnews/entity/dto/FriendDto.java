package com.kirito666.niitnews.entity.dto;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Data;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:FriendDto.java
 * @LastModified:2021/06/21 08:04:21
 */

@Data
@Builder
public class FriendDto {
    long uid;
    String account;
    String nickname;
    String remark;
    String avatar;
    String studentId;
    Timestamp regTime;
}
