package com.kirito666.niitnews.entity.dto;

import java.sql.Timestamp;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:FriendDto.java
 * @LastModified:2021/06/21 08:04:21
 */

public class FriendDto {
    long uid;
    String account;
    String nickname;
    String remark;
    String avatar;
    String studentId;
    Timestamp regTime;

    FriendDto(long uid, String account, String nickname, String remark, String avatar, String studentId, Timestamp regTime) {
        this.uid = uid;
        this.account = account;
        this.nickname = nickname;
        this.remark = remark;
        this.avatar = avatar;
        this.studentId = studentId;
        this.regTime = regTime;
    }

    public static FriendDtoBuilder builder() {
        return new FriendDtoBuilder();
    }

    public long getUid() {
        return this.uid;
    }

    public String getAccount() {
        return this.account;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public Timestamp getRegTime() {
        return this.regTime;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof FriendDto)) return false;
        final FriendDto other = (FriendDto) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getUid() != other.getUid()) return false;
        final Object this$account = this.getAccount();
        final Object other$account = other.getAccount();
        if (this$account == null ? other$account != null : !this$account.equals(other$account))
            return false;
        final Object this$nickname = this.getNickname();
        final Object other$nickname = other.getNickname();
        if (this$nickname == null ? other$nickname != null : !this$nickname.equals(other$nickname))
            return false;
        final Object this$remark = this.getRemark();
        final Object other$remark = other.getRemark();
        if (this$remark == null ? other$remark != null : !this$remark.equals(other$remark))
            return false;
        final Object this$avatar = this.getAvatar();
        final Object other$avatar = other.getAvatar();
        if (this$avatar == null ? other$avatar != null : !this$avatar.equals(other$avatar))
            return false;
        final Object this$studentId = this.getStudentId();
        final Object other$studentId = other.getStudentId();
        if (this$studentId == null ? other$studentId != null : !this$studentId.equals(other$studentId))
            return false;
        final Object this$regTime = this.getRegTime();
        final Object other$regTime = other.getRegTime();
        if (this$regTime == null ? other$regTime != null : !this$regTime.equals(other$regTime))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof FriendDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $uid = this.getUid();
        result = result * PRIME + (int) ($uid >>> 32 ^ $uid);
        final Object $account = this.getAccount();
        result = result * PRIME + ($account == null ? 43 : $account.hashCode());
        final Object $nickname = this.getNickname();
        result = result * PRIME + ($nickname == null ? 43 : $nickname.hashCode());
        final Object $remark = this.getRemark();
        result = result * PRIME + ($remark == null ? 43 : $remark.hashCode());
        final Object $avatar = this.getAvatar();
        result = result * PRIME + ($avatar == null ? 43 : $avatar.hashCode());
        final Object $studentId = this.getStudentId();
        result = result * PRIME + ($studentId == null ? 43 : $studentId.hashCode());
        final Object $regTime = this.getRegTime();
        result = result * PRIME + ($regTime == null ? 43 : $regTime.hashCode());
        return result;
    }

    public String toString() {
        return "FriendDto(uid=" + this.getUid() + ", account=" + this.getAccount() + ", nickname=" + this.getNickname() + ", remark=" + this.getRemark() + ", avatar=" + this.getAvatar() + ", studentId=" + this.getStudentId() + ", regTime=" + this.getRegTime() + ")";
    }

    public static class FriendDtoBuilder {
        private long uid;
        private String account;
        private String nickname;
        private String remark;
        private String avatar;
        private String studentId;
        private Timestamp regTime;

        FriendDtoBuilder() {
        }

        public FriendDtoBuilder uid(long uid) {
            this.uid = uid;
            return this;
        }

        public FriendDtoBuilder account(String account) {
            this.account = account;
            return this;
        }

        public FriendDtoBuilder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public FriendDtoBuilder remark(String remark) {
            this.remark = remark;
            return this;
        }

        public FriendDtoBuilder avatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public FriendDtoBuilder studentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public FriendDtoBuilder regTime(Timestamp regTime) {
            this.regTime = regTime;
            return this;
        }

        public FriendDto build() {
            return new FriendDto(uid, account, nickname, remark, avatar, studentId, regTime);
        }

        public String toString() {
            return "FriendDto.FriendDtoBuilder(uid=" + this.uid + ", account=" + this.account + ", nickname=" + this.nickname + ", remark=" + this.remark + ", avatar=" + this.avatar + ", studentId=" + this.studentId + ", regTime=" + this.regTime + ")";
        }
    }
}
