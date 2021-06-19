package com.kirito666.niitnews.entity.base;

import lombok.Data;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:BaseResponse.java
 * @LastModified:2021/06/19 21:50:19
 */

/**
 * @ClassName BaseResponseEntity
 * @Description TODO
 * @Author Finger
 * @Date 1/4/2021
 **/
@Data
public class BaseResponse<T> {
    private T data;
    private String msg;
    private int statusCode;

    public BaseResponse(HttpStatusCode httpStatusCode) {
        this.statusCode = httpStatusCode.getStatus();
        this.msg = httpStatusCode.getMessage();
    }

    public BaseResponse(HttpStatusCode httpStatusCode, T data) {
        this.statusCode = httpStatusCode.getStatus();
        this.msg = httpStatusCode.getMessage();
        this.data = data;
    }


    public BaseResponse(int statusCode, String msg) {
        this.msg = msg;
        this.statusCode = statusCode;
    }

    public BaseResponse(int statusCode, T data) {
        this.data = data;
        this.statusCode = statusCode;
    }

    public BaseResponse(int statusCode, String msg, T data) {
        this.data = data;
        this.msg = msg;
        this.statusCode = statusCode;
    }
}
