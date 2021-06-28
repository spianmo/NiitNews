package com.kirito666.niitnews.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:Post.java
 * @LastModified:2021/06/29 01:56:29
 */
public class Post implements Serializable {
    long pid;
    String title;
    Timestamp createdTime;
    Timestamp modifiedTime;
    String text;
    long authorId;
    List<String> attachPic;
    long shareCount;
    long viewsNum;
    long favorCount;
    long commitCount;
    long parentPid;
    boolean allowComment;
    boolean allowFeed;

    public Post(long pid, String title, Timestamp createdTime, Timestamp modifiedTime, String text, long authorId, List<String> attachPic, long shareCount, long viewsNum, long favorCount, long commitCount, long parentPid, boolean allowComment, boolean allowFeed) {
        this.pid = pid;
        this.title = title;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
        this.text = text;
        this.authorId = authorId;
        this.attachPic = attachPic;
        this.shareCount = shareCount;
        this.viewsNum = viewsNum;
        this.favorCount = favorCount;
        this.commitCount = commitCount;
        this.parentPid = parentPid;
        this.allowComment = allowComment;
        this.allowFeed = allowFeed;
    }

    public Post() {
    }

    public long getPid() {
        return this.pid;
    }

    public String getTitle() {
        return this.title;
    }

    public Timestamp getCreatedTime() {
        return this.createdTime;
    }

    public Timestamp getModifiedTime() {
        return this.modifiedTime;
    }

    public String getText() {
        return this.text;
    }

    public long getAuthorId() {
        return this.authorId;
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

    public boolean isAllowComment() {
        return this.allowComment;
    }

    public boolean isAllowFeed() {
        return this.allowFeed;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
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

    public void setAllowComment(boolean allowComment) {
        this.allowComment = allowComment;
    }

    public void setAllowFeed(boolean allowFeed) {
        this.allowFeed = allowFeed;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Post)) return false;
        final Post other = (Post) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getPid() != other.getPid()) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title))
            return false;
        final Object this$createdTime = this.getCreatedTime();
        final Object other$createdTime = other.getCreatedTime();
        if (this$createdTime == null ? other$createdTime != null : !this$createdTime.equals(other$createdTime))
            return false;
        final Object this$modifiedTime = this.getModifiedTime();
        final Object other$modifiedTime = other.getModifiedTime();
        if (this$modifiedTime == null ? other$modifiedTime != null : !this$modifiedTime.equals(other$modifiedTime))
            return false;
        final Object this$text = this.getText();
        final Object other$text = other.getText();
        if (this$text == null ? other$text != null : !this$text.equals(other$text)) return false;
        if (this.getAuthorId() != other.getAuthorId()) return false;
        final Object this$attachPic = this.getAttachPic();
        final Object other$attachPic = other.getAttachPic();
        if (this$attachPic == null ? other$attachPic != null : !this$attachPic.equals(other$attachPic))
            return false;
        if (this.getShareCount() != other.getShareCount()) return false;
        if (this.getViewsNum() != other.getViewsNum()) return false;
        if (this.getFavorCount() != other.getFavorCount()) return false;
        if (this.getCommitCount() != other.getCommitCount()) return false;
        if (this.getParentPid() != other.getParentPid()) return false;
        if (this.isAllowComment() != other.isAllowComment()) return false;
        if (this.isAllowFeed() != other.isAllowFeed()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Post;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $pid = this.getPid();
        result = result * PRIME + (int) ($pid >>> 32 ^ $pid);
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $createdTime = this.getCreatedTime();
        result = result * PRIME + ($createdTime == null ? 43 : $createdTime.hashCode());
        final Object $modifiedTime = this.getModifiedTime();
        result = result * PRIME + ($modifiedTime == null ? 43 : $modifiedTime.hashCode());
        final Object $text = this.getText();
        result = result * PRIME + ($text == null ? 43 : $text.hashCode());
        final long $authorId = this.getAuthorId();
        result = result * PRIME + (int) ($authorId >>> 32 ^ $authorId);
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
        result = result * PRIME + (this.isAllowComment() ? 79 : 97);
        result = result * PRIME + (this.isAllowFeed() ? 79 : 97);
        return result;
    }

    public String toString() {
        return "Post(pid=" + this.getPid() + ", title=" + this.getTitle() + ", createdTime=" + this.getCreatedTime() + ", modifiedTime=" + this.getModifiedTime() + ", text=" + this.getText() + ", authorId=" + this.getAuthorId() + ", attachPic=" + this.getAttachPic() + ", shareCount=" + this.getShareCount() + ", viewsNum=" + this.getViewsNum() + ", favorCount=" + this.getFavorCount() + ", commitCount=" + this.getCommitCount() + ", parentPid=" + this.getParentPid() + ", allowComment=" + this.isAllowComment() + ", allowFeed=" + this.isAllowFeed() + ")";
    }
}
