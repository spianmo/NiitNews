package com.kirito666.niitnews.entity;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:Rank.java
 * @LastModified:2021/06/21 08:04:21
 */
public class Rank {
    String title;
    String desc;
    long score;
    long pid;
    boolean visible;

    public Rank(String title, String desc, long score, long pid, boolean visible) {
        this.title = title;
        this.desc = desc;
        this.score = score;
        this.pid = pid;
        this.visible = visible;
    }

    public Rank() {
    }

    public static RankBuilder builder() {
        return new RankBuilder();
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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Rank)) return false;
        final Rank other = (Rank) o;
        if (!other.canEqual((Object) this)) return false;
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
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Rank;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $desc = this.getDesc();
        result = result * PRIME + ($desc == null ? 43 : $desc.hashCode());
        final long $score = this.getScore();
        result = result * PRIME + (int) ($score >>> 32 ^ $score);
        final long $pid = this.getPid();
        result = result * PRIME + (int) ($pid >>> 32 ^ $pid);
        result = result * PRIME + (this.isVisible() ? 79 : 97);
        return result;
    }

    public String toString() {
        return "Rank(title=" + this.getTitle() + ", desc=" + this.getDesc() + ", score=" + this.getScore() + ", pid=" + this.getPid() + ", visible=" + this.isVisible() + ")";
    }

    public static class RankBuilder {
        private String title;
        private String desc;
        private long score;
        private long pid;
        private boolean visible;

        RankBuilder() {
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

        public Rank build() {
            return new Rank(title, desc, score, pid, visible);
        }

        public String toString() {
            return "Rank.RankBuilder(title=" + this.title + ", desc=" + this.desc + ", score=" + this.score + ", pid=" + this.pid + ", visible=" + this.visible + ")";
        }
    }
}
