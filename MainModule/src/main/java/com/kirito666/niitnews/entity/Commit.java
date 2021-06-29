package com.kirito666.niitnews.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:Commit.java
 * @LastModified:2021/06/29 12:30:29
 */
public class Commit implements Serializable {
    long cid;
    long ownerId;
    long pid;
    String text;
    long parentCid;
    Timestamp createTime;

    public Commit(long cid, long ownerId, long pid, String text, long parentCid, Timestamp createTime) {
        this.cid = cid;
        this.ownerId = ownerId;
        this.pid = pid;
        this.text = text;
        this.parentCid = parentCid;
        this.createTime = createTime;
    }

    public Commit() {
    }

    public static CommitBuilder builder() {
        return new CommitBuilder();
    }

    public long getCid() {
        return this.cid;
    }

    public long getOwnerId() {
        return this.ownerId;
    }

    public long getPid() {
        return this.pid;
    }

    public String getText() {
        return this.text;
    }

    public long getParentCid() {
        return this.parentCid;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setParentCid(long parentCid) {
        this.parentCid = parentCid;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Commit)) return false;
        final Commit other = (Commit) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getCid() != other.getCid()) return false;
        if (this.getOwnerId() != other.getOwnerId()) return false;
        if (this.getPid() != other.getPid()) return false;
        final Object this$text = this.getText();
        final Object other$text = other.getText();
        if (this$text == null ? other$text != null : !this$text.equals(other$text)) return false;
        if (this.getParentCid() != other.getParentCid()) return false;
        final Object this$createTime = this.getCreateTime();
        final Object other$createTime = other.getCreateTime();
        if (this$createTime == null ? other$createTime != null : !this$createTime.equals(other$createTime))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Commit;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $cid = this.getCid();
        result = result * PRIME + (int) ($cid >>> 32 ^ $cid);
        final long $ownerId = this.getOwnerId();
        result = result * PRIME + (int) ($ownerId >>> 32 ^ $ownerId);
        final long $pid = this.getPid();
        result = result * PRIME + (int) ($pid >>> 32 ^ $pid);
        final Object $text = this.getText();
        result = result * PRIME + ($text == null ? 43 : $text.hashCode());
        final long $parentCid = this.getParentCid();
        result = result * PRIME + (int) ($parentCid >>> 32 ^ $parentCid);
        final Object $createTime = this.getCreateTime();
        result = result * PRIME + ($createTime == null ? 43 : $createTime.hashCode());
        return result;
    }

    public String toString() {
        return "Commit(cid=" + this.getCid() + ", ownerId=" + this.getOwnerId() + ", pid=" + this.getPid() + ", text=" + this.getText() + ", parentCid=" + this.getParentCid() + ", createTime=" + this.getCreateTime() + ")";
    }

    public static class CommitBuilder {
        private long cid;
        private long ownerId;
        private long pid;
        private String text;
        private long parentCid;
        private Timestamp createTime;

        CommitBuilder() {
        }

        public CommitBuilder cid(long cid) {
            this.cid = cid;
            return this;
        }

        public CommitBuilder ownerId(long ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public CommitBuilder pid(long pid) {
            this.pid = pid;
            return this;
        }

        public CommitBuilder text(String text) {
            this.text = text;
            return this;
        }

        public CommitBuilder parentCid(long parentCid) {
            this.parentCid = parentCid;
            return this;
        }

        public CommitBuilder createTime(Timestamp createTime) {
            this.createTime = createTime;
            return this;
        }

        public Commit build() {
            return new Commit(cid, ownerId, pid, text, parentCid, createTime);
        }

        public String toString() {
            return "Commit.CommitBuilder(cid=" + this.cid + ", ownerId=" + this.ownerId + ", pid=" + this.pid + ", text=" + this.text + ", parentCid=" + this.parentCid + ", createTime=" + this.createTime + ")";
        }
    }
}
