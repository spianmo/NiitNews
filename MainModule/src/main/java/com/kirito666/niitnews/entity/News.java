package com.kirito666.niitnews.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:News.java
 * @LastModified:2021/06/29 02:16:29
 */

public class News implements Serializable {
    long id;
    String title;
    String hint;
    String content;
    Timestamp postTime;
    long authorId;
    long groupId;
    String coverImg;
    int visitCount;
    String feedSource;
    String sourceUrl;

    public News(long id, String title, String hint, String content, Timestamp postTime, long authorId, long groupId, String coverImg, int visitCount, String feedSource, String sourceUrl) {
        this.id = id;
        this.title = title;
        this.hint = hint;
        this.content = content;
        this.postTime = postTime;
        this.authorId = authorId;
        this.groupId = groupId;
        this.coverImg = coverImg;
        this.visitCount = visitCount;
        this.feedSource = feedSource;
        this.sourceUrl = sourceUrl;
    }

    public News() {
    }

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getHint() {
        return this.hint;
    }

    public String getContent() {
        return this.content;
    }

    public Timestamp getPostTime() {
        return this.postTime;
    }

    public long getAuthorId() {
        return this.authorId;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public String getCoverImg() {
        return this.coverImg;
    }

    public int getVisitCount() {
        return this.visitCount;
    }

    public String getFeedSource() {
        return this.feedSource;
    }

    public String getSourceUrl() {
        return this.sourceUrl;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public void setFeedSource(String feedSource) {
        this.feedSource = feedSource;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof News)) return false;
        final News other = (News) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title))
            return false;
        final Object this$hint = this.getHint();
        final Object other$hint = other.getHint();
        if (this$hint == null ? other$hint != null : !this$hint.equals(other$hint)) return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (this$content == null ? other$content != null : !this$content.equals(other$content))
            return false;
        final Object this$postTime = this.getPostTime();
        final Object other$postTime = other.getPostTime();
        if (this$postTime == null ? other$postTime != null : !this$postTime.equals(other$postTime))
            return false;
        if (this.getAuthorId() != other.getAuthorId()) return false;
        if (this.getGroupId() != other.getGroupId()) return false;
        final Object this$coverImg = this.getCoverImg();
        final Object other$coverImg = other.getCoverImg();
        if (this$coverImg == null ? other$coverImg != null : !this$coverImg.equals(other$coverImg))
            return false;
        if (this.getVisitCount() != other.getVisitCount()) return false;
        final Object this$feedSource = this.getFeedSource();
        final Object other$feedSource = other.getFeedSource();
        if (this$feedSource == null ? other$feedSource != null : !this$feedSource.equals(other$feedSource))
            return false;
        final Object this$sourceUrl = this.getSourceUrl();
        final Object other$sourceUrl = other.getSourceUrl();
        if (this$sourceUrl == null ? other$sourceUrl != null : !this$sourceUrl.equals(other$sourceUrl))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof News;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $hint = this.getHint();
        result = result * PRIME + ($hint == null ? 43 : $hint.hashCode());
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        final Object $postTime = this.getPostTime();
        result = result * PRIME + ($postTime == null ? 43 : $postTime.hashCode());
        final long $authorId = this.getAuthorId();
        result = result * PRIME + (int) ($authorId >>> 32 ^ $authorId);
        final long $groupId = this.getGroupId();
        result = result * PRIME + (int) ($groupId >>> 32 ^ $groupId);
        final Object $coverImg = this.getCoverImg();
        result = result * PRIME + ($coverImg == null ? 43 : $coverImg.hashCode());
        result = result * PRIME + this.getVisitCount();
        final Object $feedSource = this.getFeedSource();
        result = result * PRIME + ($feedSource == null ? 43 : $feedSource.hashCode());
        final Object $sourceUrl = this.getSourceUrl();
        result = result * PRIME + ($sourceUrl == null ? 43 : $sourceUrl.hashCode());
        return result;
    }

    public String toString() {
        return "News(id=" + this.getId() + ", title=" + this.getTitle() + ", hint=" + this.getHint() + ", content=" + this.getContent() + ", postTime=" + this.getPostTime() + ", authorId=" + this.getAuthorId() + ", groupId=" + this.getGroupId() + ", coverImg=" + this.getCoverImg() + ", visitCount=" + this.getVisitCount() + ", feedSource=" + this.getFeedSource() + ", sourceUrl=" + this.getSourceUrl() + ")";
    }
}
