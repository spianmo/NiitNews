package com.kirito666.niitnews.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:Rank.java
 * @LastModified:2021/06/29 01:56:29
 */
public class Rank implements Serializable {
    long rid;
    String title;
    String desc;
    long score;
    long pid;
    boolean visible;
    Timestamp washTime;
    String coverImg;

    public Rank(long rid, String title, String desc, long score, long pid, boolean visible, Timestamp washTime, String coverImg) {
        this.rid = rid;
        this.title = title;
        this.desc = desc;
        this.score = score;
        this.pid = pid;
        this.visible = visible;
        this.washTime = washTime;
        this.coverImg = coverImg;
    }

    public Rank() {
    }

    public static RankBuilder builder() {
        return new RankBuilder();
    }

    public long getRid() {
        return this.rid;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDesc() {
        return this.desc;
    }

    public long getScore() {
        return this.score;
    }

    public long getPid() {
        return this.pid;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public Timestamp getWashTime() {
        return this.washTime;
    }

    public String getCoverImg() {
        return this.coverImg;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setWashTime(Timestamp washTime) {
        this.washTime = washTime;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Rank)) return false;
        final Rank other = (Rank) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getRid() != other.getRid()) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title))
            return false;
        final Object this$desc = this.getDesc();
        final Object other$desc = other.getDesc();
        if (this$desc == null ? other$desc != null : !this$desc.equals(other$desc)) return false;
        if (this.getScore() != other.getScore()) return false;
        if (this.getPid() != other.getPid()) return false;
        if (this.isVisible() != other.isVisible()) return false;
        final Object this$washTime = this.getWashTime();
        final Object other$washTime = other.getWashTime();
        if (this$washTime == null ? other$washTime != null : !this$washTime.equals(other$washTime))
            return false;
        final Object this$coverImg = this.getCoverImg();
        final Object other$coverImg = other.getCoverImg();
        if (this$coverImg == null ? other$coverImg != null : !this$coverImg.equals(other$coverImg))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Rank;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $rid = this.getRid();
        result = result * PRIME + (int) ($rid >>> 32 ^ $rid);
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $desc = this.getDesc();
        result = result * PRIME + ($desc == null ? 43 : $desc.hashCode());
        final long $score = this.getScore();
        result = result * PRIME + (int) ($score >>> 32 ^ $score);
        final long $pid = this.getPid();
        result = result * PRIME + (int) ($pid >>> 32 ^ $pid);
        result = result * PRIME + (this.isVisible() ? 79 : 97);
        final Object $washTime = this.getWashTime();
        result = result * PRIME + ($washTime == null ? 43 : $washTime.hashCode());
        final Object $coverImg = this.getCoverImg();
        result = result * PRIME + ($coverImg == null ? 43 : $coverImg.hashCode());
        return result;
    }

    public String toString() {
        return "Rank(rid=" + this.getRid() + ", title=" + this.getTitle() + ", desc=" + this.getDesc() + ", score=" + this.getScore() + ", pid=" + this.getPid() + ", visible=" + this.isVisible() + ", washTime=" + this.getWashTime() + ", coverImg=" + this.getCoverImg() + ")";
    }

    public static class RankBuilder {
        private long rid;
        private String title;
        private String desc;
        private long score;
        private long pid;
        private boolean visible;
        private Timestamp washTime;
        private String coverImg;

        RankBuilder() {
        }

        public RankBuilder rid(long rid) {
            this.rid = rid;
            return this;
        }

        public RankBuilder title(String title) {
            this.title = title;
            return this;
        }

        public RankBuilder desc(String desc) {
            this.desc = desc;
            return this;
        }

        public RankBuilder score(long score) {
            this.score = score;
            return this;
        }

        public RankBuilder pid(long pid) {
            this.pid = pid;
            return this;
        }

        public RankBuilder visible(boolean visible) {
            this.visible = visible;
            return this;
        }

        public RankBuilder washTime(Timestamp washTime) {
            this.washTime = washTime;
            return this;
        }

        public RankBuilder coverImg(String coverImg) {
            this.coverImg = coverImg;
            return this;
        }

        public Rank build() {
            return new Rank(rid, title, desc, score, pid, visible, washTime, coverImg);
        }

        public String toString() {
            return "Rank.RankBuilder(rid=" + this.rid + ", title=" + this.title + ", desc=" + this.desc + ", score=" + this.score + ", pid=" + this.pid + ", visible=" + this.visible + ", washTime=" + this.washTime + ", coverImg=" + this.coverImg + ")";
        }
    }
}