package com.kirito666.niitnews.entity;

import java.sql.Timestamp;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:Banner.java
 * @LastModified:2021/06/23 20:15:23
 */
public class Banner {
    long id;
    String title;
    String hint;
    String picUrl;
    Target target;
    String resource;
    Type type;
    Timestamp createTime;

    public Banner(long id, String title, String hint, String picUrl, Target target, String resource, Type type, Timestamp createTime) {
        this.id = id;
        this.title = title;
        this.hint = hint;
        this.picUrl = picUrl;
        this.target = target;
        this.resource = resource;
        this.type = type;
        this.createTime = createTime;
    }

    public Banner() {
    }

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getHint() {
        return this.hint;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public Target getTarget() {
        return this.target;
    }

    public String getResource() {
        return this.resource;
    }

    public Type getType() {
        return this.type;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Banner)) return false;
        final Banner other = (Banner) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title))
            return false;
        final Object this$hint = this.getHint();
        final Object other$hint = other.getHint();
        if (this$hint == null ? other$hint != null : !this$hint.equals(other$hint)) return false;
        final Object this$picUrl = this.getPicUrl();
        final Object other$picUrl = other.getPicUrl();
        if (this$picUrl == null ? other$picUrl != null : !this$picUrl.equals(other$picUrl))
            return false;
        final Object this$target = this.getTarget();
        final Object other$target = other.getTarget();
        if (this$target == null ? other$target != null : !this$target.equals(other$target))
            return false;
        final Object this$resource = this.getResource();
        final Object other$resource = other.getResource();
        if (this$resource == null ? other$resource != null : !this$resource.equals(other$resource))
            return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        final Object this$createTime = this.getCreateTime();
        final Object other$createTime = other.getCreateTime();
        if (this$createTime == null ? other$createTime != null : !this$createTime.equals(other$createTime))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Banner;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $hint = this.getHint();
        result = result * PRIME + ($hint == null ? 43 : $hint.hashCode());
        final Object $picUrl = this.getPicUrl();
        result = result * PRIME + ($picUrl == null ? 43 : $picUrl.hashCode());
        final Object $target = this.getTarget();
        result = result * PRIME + ($target == null ? 43 : $target.hashCode());
        final Object $resource = this.getResource();
        result = result * PRIME + ($resource == null ? 43 : $resource.hashCode());
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        final Object $createTime = this.getCreateTime();
        result = result * PRIME + ($createTime == null ? 43 : $createTime.hashCode());
        return result;
    }

    public String toString() {
        return "Banner(id=" + this.getId() + ", title=" + this.getTitle() + ", hint=" + this.getHint() + ", picUrl=" + this.getPicUrl() + ", target=" + this.getTarget() + ", resource=" + this.getResource() + ", type=" + this.getType() + ", createTime=" + this.getCreateTime() + ")";
    }

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