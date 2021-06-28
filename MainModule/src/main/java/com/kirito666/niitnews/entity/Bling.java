package com.kirito666.niitnews.entity;

import java.io.Serializable;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:Bling.java
 * @LastModified:2021/06/29 01:56:29
 */
public class Bling implements Serializable {
    long id;
    String splashPic;
    String bulletin;
    String bulletinLevel;
    boolean inMaintain;
    String oneTalk;

    public Bling(long id, String splashPic, String bulletin, String bulletinLevel, boolean inMaintain, String oneTalk) {
        this.id = id;
        this.splashPic = splashPic;
        this.bulletin = bulletin;
        this.bulletinLevel = bulletinLevel;
        this.inMaintain = inMaintain;
        this.oneTalk = oneTalk;
    }

    public Bling() {
    }

    public long getId() {
        return this.id;
    }

    public String getSplashPic() {
        return this.splashPic;
    }

    public String getBulletin() {
        return this.bulletin;
    }

    public String getBulletinLevel() {
        return this.bulletinLevel;
    }

    public boolean isInMaintain() {
        return this.inMaintain;
    }

    public String getOneTalk() {
        return this.oneTalk;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSplashPic(String splashPic) {
        this.splashPic = splashPic;
    }

    public void setBulletin(String bulletin) {
        this.bulletin = bulletin;
    }

    public void setBulletinLevel(String bulletinLevel) {
        this.bulletinLevel = bulletinLevel;
    }

    public void setInMaintain(boolean inMaintain) {
        this.inMaintain = inMaintain;
    }

    public void setOneTalk(String oneTalk) {
        this.oneTalk = oneTalk;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Bling)) return false;
        final Bling other = (Bling) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$splashPic = this.getSplashPic();
        final Object other$splashPic = other.getSplashPic();
        if (this$splashPic == null ? other$splashPic != null : !this$splashPic.equals(other$splashPic))
            return false;
        final Object this$bulletin = this.getBulletin();
        final Object other$bulletin = other.getBulletin();
        if (this$bulletin == null ? other$bulletin != null : !this$bulletin.equals(other$bulletin))
            return false;
        final Object this$bulletinLevel = this.getBulletinLevel();
        final Object other$bulletinLevel = other.getBulletinLevel();
        if (this$bulletinLevel == null ? other$bulletinLevel != null : !this$bulletinLevel.equals(other$bulletinLevel))
            return false;
        if (this.isInMaintain() != other.isInMaintain()) return false;
        final Object this$oneTalk = this.getOneTalk();
        final Object other$oneTalk = other.getOneTalk();
        if (this$oneTalk == null ? other$oneTalk != null : !this$oneTalk.equals(other$oneTalk))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Bling;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $splashPic = this.getSplashPic();
        result = result * PRIME + ($splashPic == null ? 43 : $splashPic.hashCode());
        final Object $bulletin = this.getBulletin();
        result = result * PRIME + ($bulletin == null ? 43 : $bulletin.hashCode());
        final Object $bulletinLevel = this.getBulletinLevel();
        result = result * PRIME + ($bulletinLevel == null ? 43 : $bulletinLevel.hashCode());
        result = result * PRIME + (this.isInMaintain() ? 79 : 97);
        final Object $oneTalk = this.getOneTalk();
        result = result * PRIME + ($oneTalk == null ? 43 : $oneTalk.hashCode());
        return result;
    }

    public String toString() {
        return "Bling(id=" + this.getId() + ", splashPic=" + this.getSplashPic() + ", bulletin=" + this.getBulletin() + ", bulletinLevel=" + this.getBulletinLevel() + ", inMaintain=" + this.isInMaintain() + ", oneTalk=" + this.getOneTalk() + ")";
    }
}
