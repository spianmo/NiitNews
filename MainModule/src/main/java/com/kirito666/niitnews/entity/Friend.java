package com.kirito666.niitnews.entity;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:Friend.java
 * @LastModified:2021/06/21 08:04:21
 */
public class Friend {
    long uid;
    long friendId;
    String remark;

    public Friend(long uid, long friendId, String remark) {
        this.uid = uid;
        this.friendId = friendId;
        this.remark = remark;
    }

    public Friend() {
    }

    public long getUid() {
        return this.uid;
    }

    public long getFriendId() {
        return this.friendId;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public void setFriendId(long friendId) {
        this.friendId = friendId;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Friend)) return false;
        final Friend other = (Friend) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getUid() != other.getUid()) return false;
        if (this.getFriendId() != other.getFriendId()) return false;
        final Object this$remark = this.getRemark();
        final Object other$remark = other.getRemark();
        if (this$remark == null ? other$remark != null : !this$remark.equals(other$remark))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Friend;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $uid = this.getUid();
        result = result * PRIME + (int) ($uid >>> 32 ^ $uid);
        final long $friendId = this.getFriendId();
        result = result * PRIME + (int) ($friendId >>> 32 ^ $friendId);
        final Object $remark = this.getRemark();
        result = result * PRIME + ($remark == null ? 43 : $remark.hashCode());
        return result;
    }

    public String toString() {
        return "Friend(uid=" + this.getUid() + ", friendId=" + this.getFriendId() + ", remark=" + this.getRemark() + ")";
    }
}
