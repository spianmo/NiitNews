package com.kirito666.niitnews.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:Banner.java
 * @LastModified:2021/06/21 08:04:21
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Banner {
    long id;
    String title;
    String hint;
    String picUrl;
    Target target;
    Type type;
    Timestamp createTime;

    public enum Target {
        NEWS("NEWS"), POST("POST"), URL("URL"), SCHEME("SCHEME");

        private final String value;

        Target(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    public enum Type {
        MAIN("MAIN"), NEWS("NEWS"), ADV("ADV"), COMMON("COMMON");

        private final String value;

        Type(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }
}
