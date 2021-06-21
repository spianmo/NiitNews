package com.kirito666.niitnews.entity;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:NewsGroup.java
 * @LastModified:2021/06/21 08:04:21
 */

public class NewsGroup {
    long id;
    String name;
    String description;
    long adminId;

    public NewsGroup(long id, String name, String description, long adminId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.adminId = adminId;
    }

    public NewsGroup() {
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public long getAdminId() {
        return this.adminId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof NewsGroup)) return false;
        final NewsGroup other = (NewsGroup) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        if (this.getAdminId() != other.getAdminId()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof NewsGroup;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final long $adminId = this.getAdminId();
        result = result * PRIME + (int) ($adminId >>> 32 ^ $adminId);
        return result;
    }

    public String toString() {
        return "NewsGroup(id=" + this.getId() + ", name=" + this.getName() + ", description=" + this.getDescription() + ", adminId=" + this.getAdminId() + ")";
    }
}
