package com.kirito666.niitnews.entity.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:CommitDto.java
 * @LastModified:2021/06/29 09:37:29
 */

public class CommitDto implements Serializable {
    long cid;
    long ownerId;
    String nickname;
    String avatar;
    long pid;
    String text;
    long parentCid;
    Timestamp createTime;

    CommitDto(long cid, long ownerId, String nickname, String avatar, long pid, String text, long parentCid, Timestamp createTime) {
        this.cid = cid;
        this.ownerId = ownerId;
        this.nickname = nickname;
        this.avatar = avatar;
        this.pid = pid;
        this.text = text;
        this.parentCid = parentCid;
        this.createTime = createTime;
    }

    public static CommitDtoBuilder builder() {
        return new CommitDtoBuilder();
    }

    public long getCid() {
        return this.cid;
    }

    public long getOwnerId() {
        return this.ownerId;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getAvatar() {
        return this.avatar;
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

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
        if (!(o instanceof CommitDto)) return false;
        final CommitDto other = (CommitDto) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getCid() != other.getCid()) return false;
        if (this.getOwnerId() != other.getOwnerId()) return false;
        final Object this$nickname = this.getNickname();
        final Object other$nickname = other.getNickname();
        if (this$nickname == null ? other$nickname != null : !this$nickname.equals(other$nickname))
            return false;
        final Object this$avatar = this.getAvatar();
        final Object other$avatar = other.getAvatar();
        if (this$avatar == null ? other$avatar != null : !this$avatar.equals(other$avatar))
            return false;
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
        return other instanceof CommitDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $cid = this.getCid();
        result = result * PRIME + (int) ($cid >>> 32 ^ $cid);
        final long $ownerId = this.getOwnerId();
        result = result * PRIME + (int) ($ownerId >>> 32 ^ $ownerId);
        final Object $nickname = this.getNickname();
        result = result * PRIME + ($nickname == null ? 43 : $nickname.hashCode());
        final Object $avatar = this.getAvatar();
        result = result * PRIME + ($avatar == null ? 43 : $avatar.hashCode());
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
        return "CommitDto(cid=" + this.getCid() + ", ownerId=" + this.getOwnerId() + ", nickname=" + this.getNickname() + ", avatar=" + this.getAvatar() + ", pid=" + this.getPid() + ", text=" + this.getText() + ", parentCid=" + this.getParentCid() + ", createTime=" + this.getCreateTime() + ")";
    }

    public static class CommitDtoBuilder {
        private long cid;
        private long ownerId;
        private String nickname;
        private String avatar;
        private long pid;
        private String text;
        private long parentCid;
        private Timestamp createTime;

        CommitDtoBuilder() {
        }

        public CommitDtoBuilder cid(long cid) {
            this.cid = cid;
            return this;
        }

        public CommitDtoBuilder ownerId(long ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public CommitDtoBuilder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public CommitDtoBuilder avatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public CommitDtoBuilder pid(long pid) {
            this.pid = pid;
            return this;
        }

        public CommitDtoBuilder text(String text) {
            this.text = text;
            return this;
        }

        public CommitDtoBuilder parentCid(long parentCid) {
            this.parentCid = parentCid;
            return this;
        }

        public CommitDtoBuilder createTime(Timestamp createTime) {
            this.createTime = createTime;
            return this;
        }

        public CommitDto build() {
            return new CommitDto(cid, ownerId, nickname, avatar, pid, text, parentCid, createTime);
        }

        public String toString() {
            return "CommitDto.CommitDtoBuilder(cid=" + this.cid + ", ownerId=" + this.ownerId + ", nickname=" + this.nickname + ", avatar=" + this.avatar + ", pid=" + this.pid + ", text=" + this.text + ", parentCid=" + this.parentCid + ", createTime=" + this.createTime + ")";
        }
    }
}
