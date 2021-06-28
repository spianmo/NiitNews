package com.kirito666.niitnews.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:Favor.java
 * @LastModified:2021/06/29 01:56:29
 */
public class Favor implements Serializable {
    long id;
    long ownerId;
    long pid;
    Timestamp date;

    public Favor(long id, long ownerId, long pid, Timestamp date) {
        this.id = id;
        this.ownerId = ownerId;
        this.pid = pid;
        this.date = date;
    }

    public Favor() {
    }

    public static FavorBuilder builder() {
        return new FavorBuilder();
    }

    public long getId() {
        return this.id;
    }

    public long getOwnerId() {
        return this.ownerId;
    }

    public long getPid() {
        return this.pid;
    }

    public Timestamp getDate() {
        return this.date;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Favor)) return false;
        final Favor other = (Favor) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        if (this.getOwnerId() != other.getOwnerId()) return false;
        if (this.getPid() != other.getPid()) return false;
        final Object this$date = this.getDate();
        final Object other$date = other.getDate();
        if (this$date == null ? other$date != null : !this$date.equals(other$date)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Favor;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final long $ownerId = this.getOwnerId();
        result = result * PRIME + (int) ($ownerId >>> 32 ^ $ownerId);
        final long $pid = this.getPid();
        result = result * PRIME + (int) ($pid >>> 32 ^ $pid);
        final Object $date = this.getDate();
        result = result * PRIME + ($date == null ? 43 : $date.hashCode());
        return result;
    }

    public String toString() {
        return "Favor(id=" + this.getId() + ", ownerId=" + this.getOwnerId() + ", pid=" + this.getPid() + ", date=" + this.getDate() + ")";
    }

    public static class FavorBuilder {
        private long id;
        private long ownerId;
        private long pid;
        private Timestamp date;

        FavorBuilder() {
        }

        public FavorBuilder id(long id) {
            this.id = id;
            return this;
        }

        public FavorBuilder ownerId(long ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public FavorBuilder pid(long pid) {
            this.pid = pid;
            return this;
        }

        public FavorBuilder date(Timestamp date) {
            this.date = date;
            return this;
        }

        public Favor build() {
            return new Favor(id, ownerId, pid, date);
        }

        public String toString() {
            return "Favor.FavorBuilder(id=" + this.id + ", ownerId=" + this.ownerId + ", pid=" + this.pid + ", date=" + this.date + ")";
        }
    }
}
