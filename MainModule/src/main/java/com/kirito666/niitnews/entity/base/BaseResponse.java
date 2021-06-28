package com.kirito666.niitnews.entity.base;

import java.io.Serializable;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:BaseResponse.java
 * @LastModified:2021/06/29 01:56:29
 */

/**
 * @ClassName BaseResponseEntity
 * @Description TODO
 * @Author Finger
 * @Date 1/4/2021
 **/
public class BaseResponse<T> implements Serializable {
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

    public BaseResponse() {

    }

    public T getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BaseResponse)) return false;
        final BaseResponse<?> other = (BaseResponse<?>) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$data = this.getData();
        final Object other$data = other.getData();
        if (this$data == null ? other$data != null : !this$data.equals(other$data)) return false;
        final Object this$msg = this.getMsg();
        final Object other$msg = other.getMsg();
        if (this$msg == null ? other$msg != null : !this$msg.equals(other$msg)) return false;
        if (this.getStatusCode() != other.getStatusCode()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BaseResponse;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $data = this.getData();
        result = result * PRIME + ($data == null ? 43 : $data.hashCode());
        final Object $msg = this.getMsg();
        result = result * PRIME + ($msg == null ? 43 : $msg.hashCode());
        result = result * PRIME + this.getStatusCode();
        return result;
    }

    public String toString() {
        return "BaseResponse(data=" + this.getData() + ", msg=" + this.getMsg() + ", statusCode=" + this.getStatusCode() + ")";
    }
}
