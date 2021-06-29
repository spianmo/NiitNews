package com.kirito666.niitnews.entity.base;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:HttpStatusCode.java
 * @LastModified:2021/06/29 11:24:29
 */

/**
 * @Description: 自定义状态码异常枚举类
 * @ProjectName: spring-parent
 * @Package: com.yaomy.common.HttpStatusMsg
 * @Date: 2019/7/18 15:09
 * @Version: 1.0
 */
@SuppressWarnings("all")
public enum HttpStatusCode {
    LOGIN_FAILD(198, "登录失败,账号或密码错误"),
    USER_REG_EDITED(199, "用户已被注册"),
    USER_NOEXIST(197, "用户不存在"),
    USER_REG_ERROR(196, "注册失败"),
    FAILD(199, "请求失败"),
    SUCCESS(200, "请求成功"),
    UNKNOW_EXCEPTION(201, "未知异常"),
    RUNTIME_EXCEPTION(202, "运行时异常"),
    NULL_POINTER_EXCEPTION(203, "空指针异常"),
    CLASS_CAST_EXCEPTION(204, "类型转换异常"),
    IO_EXCEPTION(205, "IO异常"),
    INDEX_OUTOF_BOUNDS_EXCEPTION(206, "数组越界异常"),
    METHOD_ARGUMENT_TYPE_MISMATCH_EXCEPTIION(207, "参数类型不匹配"),
    MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION(208, "缺少参数"),
    HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION(209, "不支持的METHOD类型"),
    PARAM_EXCEPTION(210, "参数异常"),

    NOT_FOUND_EXCEPTION(404, "NOT FOUND"),

    //--------------------OAUTH2认证异常------------------
    AUTHENTICATION_EXCEPTION(300, "登录态异常"),
    ACCESS_DENIDED_EXCEPTION(301, "访问资源受限"),
    PASSWORD_EXCEPTION(302, "密码异常"),
    USERNAME_EXCEPTION(303, "用户名异常"),
    LOGOUT_EXCEPTION(304, "登出异常");

    private final int status;
    private final String message;

    HttpStatusCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public static String getMessageByStatusCode(int statusCode) {
        for (HttpStatusCode s : HttpStatusCode.values()) {
            if (s.getStatus() == statusCode) {
                return s.getMessage();
            }
        }
        return "";
    }

    public static HttpStatusCode getStatusByCode(int statusCode) {
        for (HttpStatusCode s : HttpStatusCode.values()) {
            if (s.getStatus() == statusCode) {
                return s;
            }
        }
        return HttpStatusCode.UNKNOW_EXCEPTION;
    }
}
