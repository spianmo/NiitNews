package com.kirito666.niitnews.entity.dto;

import com.kirito666.niitnews.entity.News;

import java.util.List;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:NewsPageData.java
 * @LastModified:2021/06/21 08:04:21
 */

public class NewsPageData {
    int pageId;
    int pageSize;
    int count;
    List<News> newsData;

    public NewsPageData() {
    }

    public int getPageId() {
        return this.pageId;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getCount() {
        return this.count;
    }

    public List<News> getNewsData() {
        return this.newsData;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setNewsData(List<News> newsData) {
        this.newsData = newsData;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof NewsPageData)) return false;
        final NewsPageData other = (NewsPageData) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getPageId() != other.getPageId()) return false;
        if (this.getPageSize() != other.getPageSize()) return false;
        if (this.getCount() != other.getCount()) return false;
        final Object this$newsData = this.getNewsData();
        final Object other$newsData = other.getNewsData();
        if (this$newsData == null ? other$newsData != null : !this$newsData.equals(other$newsData))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof NewsPageData;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getPageId();
        result = result * PRIME + this.getPageSize();
        result = result * PRIME + this.getCount();
        final Object $newsData = this.getNewsData();
        result = result * PRIME + ($newsData == null ? 43 : $newsData.hashCode());
        return result;
    }

    public String toString() {
        return "NewsPageData(pageId=" + this.getPageId() + ", pageSize=" + this.getPageSize() + ", count=" + this.getCount() + ", newsData=" + this.getNewsData() + ")";
    }
}
