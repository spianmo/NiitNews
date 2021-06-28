package com.kirito666.niitnews.entity.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:PostPageData.java
 * @LastModified:2021/06/29 01:56:29
 */

public class PostPageData implements Serializable {
    int pageId;
    int pageSize;
    int count;
    List<SimplePost> postData;

    public PostPageData() {
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

    public List<SimplePost> getPostData() {
        return this.postData;
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

    public void setPostData(List<SimplePost> postData) {
        this.postData = postData;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PostPageData)) return false;
        final PostPageData other = (PostPageData) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getPageId() != other.getPageId()) return false;
        if (this.getPageSize() != other.getPageSize()) return false;
        if (this.getCount() != other.getCount()) return false;
        final Object this$postData = this.getPostData();
        final Object other$postData = other.getPostData();
        if (this$postData == null ? other$postData != null : !this$postData.equals(other$postData))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PostPageData;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getPageId();
        result = result * PRIME + this.getPageSize();
        result = result * PRIME + this.getCount();
        final Object $postData = this.getPostData();
        result = result * PRIME + ($postData == null ? 43 : $postData.hashCode());
        return result;
    }

    public String toString() {
        return "PostPageData(pageId=" + this.getPageId() + ", pageSize=" + this.getPageSize() + ", count=" + this.getCount() + ", postData=" + this.getPostData() + ")";
    }
}
