package com.kirito666.niitnews.entity;

import java.sql.Timestamp;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:Application.java
 * @LastModified:2021/06/21 08:04:21
 */
public class Application {
    long id;
    String md5;
    String signature;
    String updateMsg;
    long versionCode;
    String versionName;
    Timestamp releaseTime;

    public Application(long id, String md5, String signature, String updateMsg, long versionCode, String versionName, Timestamp releaseTime) {
        this.id = id;
        this.md5 = md5;
        this.signature = signature;
        this.updateMsg = updateMsg;
        this.versionCode = versionCode;
        this.versionName = versionName;
        this.releaseTime = releaseTime;
    }

    public Application() {
    }

    public long getId() {
        return this.id;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getUpdateMsg() {
        return this.updateMsg;
    }

    public long getVersionCode() {
        return this.versionCode;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public Timestamp getReleaseTime() {
        return this.releaseTime;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void setUpdateMsg(String updateMsg) {
        this.updateMsg = updateMsg;
    }

    public void setVersionCode(long versionCode) {
        this.versionCode = versionCode;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public void setReleaseTime(Timestamp releaseTime) {
        this.releaseTime = releaseTime;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Application)) return false;
        final Application other = (Application) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$md5 = this.getMd5();
        final Object other$md5 = other.getMd5();
        if (this$md5 == null ? other$md5 != null : !this$md5.equals(other$md5)) return false;
        final Object this$signature = this.getSignature();
        final Object other$signature = other.getSignature();
        if (this$signature == null ? other$signature != null : !this$signature.equals(other$signature))
            return false;
        final Object this$updateMsg = this.getUpdateMsg();
        final Object other$updateMsg = other.getUpdateMsg();
        if (this$updateMsg == null ? other$updateMsg != null : !this$updateMsg.equals(other$updateMsg))
            return false;
        if (this.getVersionCode() != other.getVersionCode()) return false;
        final Object this$versionName = this.getVersionName();
        final Object other$versionName = other.getVersionName();
        if (this$versionName == null ? other$versionName != null : !this$versionName.equals(other$versionName))
            return false;
        final Object this$releaseTime = this.getReleaseTime();
        final Object other$releaseTime = other.getReleaseTime();
        if (this$releaseTime == null ? other$releaseTime != null : !this$releaseTime.equals(other$releaseTime))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Application;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $md5 = this.getMd5();
        result = result * PRIME + ($md5 == null ? 43 : $md5.hashCode());
        final Object $signature = this.getSignature();
        result = result * PRIME + ($signature == null ? 43 : $signature.hashCode());
        final Object $updateMsg = this.getUpdateMsg();
        result = result * PRIME + ($updateMsg == null ? 43 : $updateMsg.hashCode());
        final long $versionCode = this.getVersionCode();
        result = result * PRIME + (int) ($versionCode >>> 32 ^ $versionCode);
        final Object $versionName = this.getVersionName();
        result = result * PRIME + ($versionName == null ? 43 : $versionName.hashCode());
        final Object $releaseTime = this.getReleaseTime();
        result = result * PRIME + ($releaseTime == null ? 43 : $releaseTime.hashCode());
        return result;
    }

    public String toString() {
        return "Application(id=" + this.getId() + ", md5=" + this.getMd5() + ", signature=" + this.getSignature() + ", updateMsg=" + this.getUpdateMsg() + ", versionCode=" + this.getVersionCode() + ", versionName=" + this.getVersionName() + ", releaseTime=" + this.getReleaseTime() + ")";
    }
}
