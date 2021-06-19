package com.kirito666.niitnews.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:User.java
 * @LastModified:2021/06/19 16:18:19
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    long id;
    String account;
    String nickname;
    String passwd;
    String avatar;
    String studentId;
    Role role;
    Timestamp regTime;

    public enum Role {
        ADMIN("ADMIN"), USER("USER"), GUEST("GUEST");

        private final String value;

        Role(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }
}
