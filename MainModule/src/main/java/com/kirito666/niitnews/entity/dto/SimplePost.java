package com.kirito666.niitnews.entity.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:SimplePost.java
 * @LastModified:2021/06/29 10:37:29
 */

public class SimplePost implements Serializable {
    long pid;
    String title;
    Timestamp modifiedTime;
    Timestamp createdTime;
    String textSmp;
    long authorId;
    String avatar;
    String nickname;
    String account;
    List<String> attachPic;
    long shareCount;
    long viewsNum;
    long favorCount;
    long commitCount;
    long parentPid;
    boolean isFavor;
    boolean allowComment;

    SimplePost(long pid, String title, Timestamp modifiedTime, Timestamp createdTime, String textSmp, long authorId, String avatar, String nickname, String account, List<String> attachPic, long shareCount, long viewsNum, long favorCount, long commitCount, long parentPid, boolean isFavor, boolean allowComment) {
        this.pid = pid;
        this.title = title;
        this.modifiedTime = modifiedTime;
        this.createdTime = createdTime;
        this.textSmp = textSmp;
        this.authorId = authorId;
        this.avatar = avatar;
        this.nickname = nickname;
        this.account = account;
        this.attachPic = attachPic;
        this.shareCount = shareCount;
        this.viewsNum = viewsNum;
        this.favorCount = favorCount;
        this.commitCount = commitCount;
        this.parentPid = parentPid;
        this.isFavor = isFavor;
        this.allowComment = allowComment;
    }

    public static SimplePostBuilder builder() {
        return new SimplePostBuilder();
    }

    public long getPid() {
        return this.pid;
    }

    public String getTitle() {
        return this.title;
    }

    public Timestamp getModifiedTime() {
        return this.modifiedTime;
    }

    public Timestamp getCreatedTime() {
        return this.createdTime;
    }

    public String getTextSmp() {
        return this.textSmp;
    }

    public long getAuthorId() {
        return this.authorId;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getAccount() {
        return this.account;
    }

    public List<String> getAttachPic() {
        return this.attachPic;
    }

    public long getShareCount() {
        return this.shareCount;
    }

    public long getViewsNum() {
        return this.viewsNum;
    }

    public long getFavorCount() {
        return this.favorCount;
    }

    public long getCommitCount() {
        return this.commitCount;
    }

    public long getParentPid() {
        return this.parentPid;
    }

    public boolean isFavor() {
        return this.isFavor;
    }

    public boolean isAllowComment() {
        return this.allowComment;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public void setTextSmp(String textSmp) {
        this.textSmp = textSmp;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setAttachPic(List<String> attachPic) {
        this.attachPic = attachPic;
    }

    public void setShareCount(long shareCount) {
        this.shareCount = shareCount;
    }

    public void setViewsNum(long viewsNum) {
        this.viewsNum = viewsNum;
    }

    public void setFavorCount(long favorCount) {
        this.favorCount = favorCount;
    }

    public void setCommitCount(long commitCount) {
        this.commitCount = commitCount;
    }

    public void setParentPid(long parentPid) {
        this.parentPid = parentPid;
    }

    public void setFavor(boolean isFavor) {
        this.isFavor = isFavor;
    }

    public void setAllowComment(boolean allowComment) {
        this.allowComment = allowComment;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof SimplePost)) return false;
        final SimplePost other = (SimplePost) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getPid() != other.getPid()) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title))
            return false;
        final Object this$modifiedTime = this.getModifiedTime();
        final Object other$modifiedTime = other.getModifiedTime();
        if (this$modifiedTime == null ? other$modifiedTime != null : !this$modifiedTime.equals(other$modifiedTime))
            return false;
        final Object this$createdTime = this.getCreatedTime();
        final Object other$createdTime = other.getCreatedTime();
        if (this$createdTime == null ? other$createdTime != null : !this$createdTime.equals(other$createdTime))
            return false;
        final Object this$textSmp = this.getTextSmp();
        final Object other$textSmp = other.getTextSmp();
        if (this$textSmp == null ? other$textSmp != null : !this$textSmp.equals(other$textSmp))
            return false;
        if (this.getAuthorId() != other.getAuthorId()) return false;
        final Object this$avatar = this.getAvatar();
        final Object other$avatar = other.getAvatar();
        if (this$avatar == null ? other$avatar != null : !this$avatar.equals(other$avatar))
            return false;
        final Object this$nickname = this.getNickname();
        final Object other$nickname = other.getNickname();
        if (this$nickname == null ? other$nickname != null : !this$nickname.equals(other$nickname))
            return false;
        final Object this$account = this.getAccount();
        final Object other$account = other.getAccount();
        if (this$account == null ? other$account != null : !this$account.equals(other$account))
            return false;
        final Object this$attachPic = this.getAttachPic();
        final Object other$attachPic = other.getAttachPic();
        if (this$attachPic == null ? other$attachPic != null : !this$attachPic.equals(other$attachPic))
            return false;
        if (this.getShareCount() != other.getShareCount()) return false;
        if (this.getViewsNum() != other.getViewsNum()) return false;
        if (this.getFavorCount() != other.getFavorCount()) return false;
        if (this.getCommitCount() != other.getCommitCount()) return false;
        if (this.getParentPid() != other.getParentPid()) return false;
        if (this.isFavor() != other.isFavor()) return false;
        if (this.isAllowComment() != other.isAllowComment()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SimplePost;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $pid = this.getPid();
        result = result * PRIME + (int) ($pid >>> 32 ^ $pid);
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $modifiedTime = this.getModifiedTime();
        result = result * PRIME + ($modifiedTime == null ? 43 : $modifiedTime.hashCode());
        final Object $createdTime = this.getCreatedTime();
        result = result * PRIME + ($createdTime == null ? 43 : $createdTime.hashCode());
        final Object $textSmp = this.getTextSmp();
        result = result * PRIME + ($textSmp == null ? 43 : $textSmp.hashCode());
        final long $authorId = this.getAuthorId();
        result = result * PRIME + (int) ($authorId >>> 32 ^ $authorId);
        final Object $avatar = this.getAvatar();
        result = result * PRIME + ($avatar == null ? 43 : $avatar.hashCode());
        final Object $nickname = this.getNickname();
        result = result * PRIME + ($nickname == null ? 43 : $nickname.hashCode());
        final Object $account = this.getAccount();
        result = result * PRIME + ($account == null ? 43 : $account.hashCode());
        final Object $attachPic = this.getAttachPic();
        result = result * PRIME + ($attachPic == null ? 43 : $attachPic.hashCode());
        final long $shareCount = this.getShareCount();
        result = result * PRIME + (int) ($shareCount >>> 32 ^ $shareCount);
        final long $viewsNum = this.getViewsNum();
        result = result * PRIME + (int) ($viewsNum >>> 32 ^ $viewsNum);
        final long $favorCount = this.getFavorCount();
        result = result * PRIME + (int) ($favorCount >>> 32 ^ $favorCount);
        final long $commitCount = this.getCommitCount();
        result = result * PRIME + (int) ($commitCount >>> 32 ^ $commitCount);
        final long $parentPid = this.getParentPid();
        result = result * PRIME + (int) ($parentPid >>> 32 ^ $parentPid);
        result = result * PRIME + (this.isFavor() ? 79 : 97);
        result = result * PRIME + (this.isAllowComment() ? 79 : 97);
        return result;
    }

    public String toString() {
        return "SimplePost(pid=" + this.getPid() + ", title=" + this.getTitle() + ", modifiedTime=" + this.getModifiedTime() + ", createdTime=" + this.getCreatedTime() + ", textSmp=" + this.getTextSmp() + ", authorId=" + this.getAuthorId() + ", avatar=" + this.getAvatar() + ", nickname=" + this.getNickname() + ", account=" + this.getAccount() + ", attachPic=" + this.getAttachPic() + ", shareCount=" + this.getShareCount() + ", viewsNum=" + this.getViewsNum() + ", favorCount=" + this.getFavorCount() + ", commitCount=" + this.getCommitCount() + ", parentPid=" + this.getParentPid() + ", isFavor=" + this.isFavor() + ", allowComment=" + this.isAllowComment() + ")";
    }

    public static class SimplePostBuilder {
        private long pid;
        private String title;
        private Timestamp modifiedTime;
        private Timestamp createdTime;
        private String textSmp;
        private long authorId;
        private String avatar;
        private String nickname;
        private String account;
        private List<String> attachPic;
        private long shareCount;
        private long viewsNum;
        private long favorCount;
        private long commitCount;
        private long parentPid;
        private boolean isFavor;
        private boolean allowComment;

        SimplePostBuilder() {
        }

        public SimplePostBuilder pid(long pid) {
            this.pid = pid;
            return this;
        }

        public SimplePostBuilder title(String title) {
            this.title = title;
            return this;
        }

        public SimplePostBuilder modifiedTime(Timestamp modifiedTime) {
            this.modifiedTime = modifiedTime;
            return this;
        }

        public SimplePostBuilder createdTime(Timestamp createdTime) {
            this.createdTime = createdTime;
            return this;
        }

        public SimplePostBuilder textSmp(String textSmp) {
            this.textSmp = textSmp;
            return this;
        }

        public SimplePostBuilder authorId(long authorId) {
            this.authorId = authorId;
            return this;
        }

        public SimplePostBuilder avatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public SimplePostBuilder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public SimplePostBuilder account(String account) {
            this.account = account;
            return this;
        }

        public SimplePostBuilder attachPic(List<String> attachPic) {
            this.attachPic = attachPic;
            return this;
        }

        public SimplePostBuilder shareCount(long shareCount) {
            this.shareCount = shareCount;
            return this;
        }

        public SimplePostBuilder viewsNum(long viewsNum) {
            this.viewsNum = viewsNum;
            return this;
        }

        public SimplePostBuilder favorCount(long favorCount) {
            this.favorCount = favorCount;
            return this;
        }

        public SimplePostBuilder commitCount(long commitCount) {
            this.commitCount = commitCount;
            return this;
        }

        public SimplePostBuilder parentPid(long parentPid) {
            this.parentPid = parentPid;
            return this;
        }

        public SimplePostBuilder isFavor(boolean isFavor) {
            this.isFavor = isFavor;
            return this;
        }

        public SimplePostBuilder allowComment(boolean allowComment) {
            this.allowComment = allowComment;
            return this;
        }

        public SimplePost build() {
            return new SimplePost(pid, title, modifiedTime, createdTime, textSmp, authorId, avatar, nickname, account, attachPic, shareCount, viewsNum, favorCount, commitCount, parentPid, isFavor, allowComment);
        }

        public String toString() {
            return "SimplePost.SimplePostBuilder(pid=" + this.pid + ", title=" + this.title + ", modifiedTime=" + this.modifiedTime + ", createdTime=" + this.createdTime + ", textSmp=" + this.textSmp + ", authorId=" + this.authorId + ", avatar=" + this.avatar + ", nickname=" + this.nickname + ", account=" + this.account + ", attachPic=" + this.attachPic + ", shareCount=" + this.shareCount + ", viewsNum=" + this.viewsNum + ", favorCount=" + this.favorCount + ", commitCount=" + this.commitCount + ", parentPid=" + this.parentPid + ", isFavor=" + this.isFavor + ", allowComment=" + this.allowComment + ")";
        }
    }
}
