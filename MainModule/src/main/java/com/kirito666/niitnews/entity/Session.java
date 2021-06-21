package com.kirito666.niitnews.entity;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:Session.java
 * @LastModified:2021/06/21 08:04:21
 */

public class Session {
    long uid;
    String superkey;

    public Session(long uid, String superkey) {
        this.uid = uid;
        this.superkey = superkey;
    }

    public Session() {
    }

    public static SessionBuilder builder() {
        return new SessionBuilder();
    }

    public long getUid() {
        return this.uid;
    }

    public String getSuperkey() {
        return this.superkey;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public void setSuperkey(String superkey) {
        this.superkey = superkey;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Session)) return false;
        final Session other = (Session) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getUid() != other.getUid()) return false;
        final Object this$superkey = this.getSuperkey();
        final Object other$superkey = other.getSuperkey();
        if (this$superkey == null ? other$superkey != null : !this$superkey.equals(other$superkey))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Session;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $uid = this.getUid();
        result = result * PRIME + (int) ($uid >>> 32 ^ $uid);
        final Object $superkey = this.getSuperkey();
        result = result * PRIME + ($superkey == null ? 43 : $superkey.hashCode());
        return result;
    }

    public String toString() {
        return "Session(uid=" + this.getUid() + ", superkey=" + this.getSuperkey() + ")";
    }

    public static class SessionBuilder {
        private long uid;
        private String superkey;

        SessionBuilder() {
        }

        public SessionBuilder uid(long uid) {
            this.uid = uid;
            return this;
        }

        public SessionBuilder superkey(String superkey) {
            this.superkey = superkey;
            return this;
        }

        public Session build() {
            return new Session(uid, superkey);
        }

        public String toString() {
            return "Session.SessionBuilder(uid=" + this.uid + ", superkey=" + this.superkey + ")";
        }
    }
}
