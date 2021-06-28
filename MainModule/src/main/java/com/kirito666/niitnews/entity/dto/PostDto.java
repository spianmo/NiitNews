package com.kirito666.niitnews.entity.dto;

import com.kirito666.niitnews.entity.Commit;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:PostDto.java
 * @LastModified:2021/06/29 02:16:29
 */

public class PostDto implements Serializable {
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
    boolean isSourceAuthor;
    long score;
    List<Commit> commits;

    public PostDto() {
    }

    PostDto(long pid, String title, Timestamp createdTime, Timestamp modifiedTime, String text, long authorId, List<String> attachPic, long shareCount, long viewsNum, long favorCount, long commitCount, long parentPid, boolean allowComment, boolean allowFeed, boolean isSourceAuthor, long score, List<Commit> commits) {
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
        this.isSourceAuthor = isSourceAuthor;
        this.score = score;
        this.commits = commits;
    }

    public static PostDtoBuilder builder() {
        return new PostDtoBuilder();
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

    public boolean isSourceAuthor() {
        return this.isSourceAuthor;
    }

    public long getScore() {
        return this.score;
    }

    public List<Commit> getCommits() {
        return this.commits;
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

    public void setSourceAuthor(boolean isSourceAuthor) {
        this.isSourceAuthor = isSourceAuthor;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public void setCommits(List<Commit> commits) {
        this.commits = commits;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PostDto)) return false;
        final PostDto other = (PostDto) o;
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
        if (this.isSourceAuthor() != other.isSourceAuthor()) return false;
        if (this.getScore() != other.getScore()) return false;
        final Object this$commits = this.getCommits();
        final Object other$commits = other.getCommits();
        if (this$commits == null ? other$commits != null : !this$commits.equals(other$commits))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PostDto;
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
        result = result * PRIME + (this.isSourceAuthor() ? 79 : 97);
        final long $score = this.getScore();
        result = result * PRIME + (int) ($score >>> 32 ^ $score);
        final Object $commits = this.getCommits();
        result = result * PRIME + ($commits == null ? 43 : $commits.hashCode());
        return result;
    }

    public String toString() {
        return "PostDto(pid=" + this.getPid() + ", title=" + this.getTitle() + ", createdTime=" + this.getCreatedTime() + ", modifiedTime=" + this.getModifiedTime() + ", text=" + this.getText() + ", authorId=" + this.getAuthorId() + ", attachPic=" + this.getAttachPic() + ", shareCount=" + this.getShareCount() + ", viewsNum=" + this.getViewsNum() + ", favorCount=" + this.getFavorCount() + ", commitCount=" + this.getCommitCount() + ", parentPid=" + this.getParentPid() + ", allowComment=" + this.isAllowComment() + ", allowFeed=" + this.isAllowFeed() + ", isSourceAuthor=" + this.isSourceAuthor() + ", score=" + this.getScore() + ", commits=" + this.getCommits() + ")";
    }

    public static class PostDtoBuilder {
        private long pid;
        private String title;
        private Timestamp createdTime;
        private Timestamp modifiedTime;
        private String text;
        private long authorId;
        private List<String> attachPic;
        private long shareCount;
        private long viewsNum;
        private long favorCount;
        private long commitCount;
        private long parentPid;
        private boolean allowComment;
        private boolean allowFeed;
        private boolean isSourceAuthor;
        private long score;
        private List<Commit> commits;

        PostDtoBuilder() {
        }

        public PostDtoBuilder pid(long pid) {
            this.pid = pid;
            return this;
        }

        public PostDtoBuilder title(String title) {
            this.title = title;
            return this;
        }

        public PostDtoBuilder createdTime(Timestamp createdTime) {
            this.createdTime = createdTime;
            return this;
        }

        public PostDtoBuilder modifiedTime(Timestamp modifiedTime) {
            this.modifiedTime = modifiedTime;
            return this;
        }

        public PostDtoBuilder text(String text) {
            this.text = text;
            return this;
        }

        public PostDtoBuilder authorId(long authorId) {
            this.authorId = authorId;
            return this;
        }

        public PostDtoBuilder attachPic(List<String> attachPic) {
            this.attachPic = attachPic;
            return this;
        }

        public PostDtoBuilder shareCount(long shareCount) {
            this.shareCount = shareCount;
            return this;
        }

        public PostDtoBuilder viewsNum(long viewsNum) {
            this.viewsNum = viewsNum;
            return this;
        }

        public PostDtoBuilder favorCount(long favorCount) {
            this.favorCount = favorCount;
            return this;
        }

        public PostDtoBuilder commitCount(long commitCount) {
            this.commitCount = commitCount;
            return this;
        }

        public PostDtoBuilder parentPid(long parentPid) {
            this.parentPid = parentPid;
            return this;
        }

        public PostDtoBuilder allowComment(boolean allowComment) {
            this.allowComment = allowComment;
            return this;
        }

        public PostDtoBuilder allowFeed(boolean allowFeed) {
            this.allowFeed = allowFeed;
            return this;
        }

        public PostDtoBuilder isSourceAuthor(boolean isSourceAuthor) {
            this.isSourceAuthor = isSourceAuthor;
            return this;
        }

        public PostDtoBuilder score(long score) {
            this.score = score;
            return this;
        }

        public PostDtoBuilder commits(List<Commit> commits) {
            this.commits = commits;
            return this;
        }

        public PostDto build() {
            return new PostDto(pid, title, createdTime, modifiedTime, text, authorId, attachPic, shareCount, viewsNum, favorCount, commitCount, parentPid, allowComment, allowFeed, isSourceAuthor, score, commits);
        }

        public String toString() {
            return "PostDto.PostDtoBuilder(pid=" + this.pid + ", title=" + this.title + ", createdTime=" + this.createdTime + ", modifiedTime=" + this.modifiedTime + ", text=" + this.text + ", authorId=" + this.authorId + ", attachPic=" + this.attachPic + ", shareCount=" + this.shareCount + ", viewsNum=" + this.viewsNum + ", favorCount=" + this.favorCount + ", commitCount=" + this.commitCount + ", parentPid=" + this.parentPid + ", allowComment=" + this.allowComment + ", allowFeed=" + this.allowFeed + ", isSourceAuthor=" + this.isSourceAuthor + ", score=" + this.score + ", commits=" + this.commits + ")";
        }
    }
}
