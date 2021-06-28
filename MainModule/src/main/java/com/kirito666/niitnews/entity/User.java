package com.kirito666.niitnews.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:User.java
 * @LastModified:2021/06/29 01:56:29
 */

public class User implements Serializable {
    long id;
    String account;
    String nickname;
    String passwd;
    String avatar;
    String studentId;
    Role role;
    Timestamp regTime;

    public User(long id, String account, String nickname, String passwd, String avatar, String studentId, Role role, Timestamp regTime) {
        this.id = id;
        this.account = account;
        this.nickname = nickname;
        this.passwd = passwd;
        this.avatar = avatar;
        this.studentId = studentId;
        this.role = role;
        this.regTime = regTime;
    }

    public User() {
    }

    public long getId() {
        return this.id;
    }

    public String getAccount() {
        return this.account;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getPasswd() {
        return this.passwd;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public Role getRole() {
        return this.role;
    }

    public Timestamp getRegTime() {
        return this.regTime;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$account = this.getAccount();
        final Object other$account = other.getAccount();
        if (this$account == null ? other$account != null : !this$account.equals(other$account))
            return false;
        final Object this$nickname = this.getNickname();
        final Object other$nickname = other.getNickname();
        if (this$nickname == null ? other$nickname != null : !this$nickname.equals(other$nickname))
            return false;
        final Object this$passwd = this.getPasswd();
        final Object other$passwd = other.getPasswd();
        if (this$passwd == null ? other$passwd != null : !this$passwd.equals(other$passwd))
            return false;
        final Object this$avatar = this.getAvatar();
        final Object other$avatar = other.getAvatar();
        if (this$avatar == null ? other$avatar != null : !this$avatar.equals(other$avatar))
            return false;
        final Object this$studentId = this.getStudentId();
        final Object other$studentId = other.getStudentId();
        if (this$studentId == null ? other$studentId != null : !this$studentId.equals(other$studentId))
            return false;
        final Object this$role = this.getRole();
        final Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) return false;
        final Object this$regTime = this.getRegTime();
        final Object other$regTime = other.getRegTime();
        if (this$regTime == null ? other$regTime != null : !this$regTime.equals(other$regTime))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $account = this.getAccount();
        result = result * PRIME + ($account == null ? 43 : $account.hashCode());
        final Object $nickname = this.getNickname();
        result = result * PRIME + ($nickname == null ? 43 : $nickname.hashCode());
        final Object $passwd = this.getPasswd();
        result = result * PRIME + ($passwd == null ? 43 : $passwd.hashCode());
        final Object $avatar = this.getAvatar();
        result = result * PRIME + ($avatar == null ? 43 : $avatar.hashCode());
        final Object $studentId = this.getStudentId();
        result = result * PRIME + ($studentId == null ? 43 : $studentId.hashCode());
        final Object $role = this.getRole();
        result = result * PRIME + ($role == null ? 43 : $role.hashCode());
        final Object $regTime = this.getRegTime();
        result = result * PRIME + ($regTime == null ? 43 : $regTime.hashCode());
        return result;
    }

    public String toString() {
        return "User(id=" + this.getId() + ", account=" + this.getAccount() + ", nickname=" + this.getNickname() + ", passwd=" + this.getPasswd() + ", avatar=" + this.getAvatar() + ", studentId=" + this.getStudentId() + ", role=" + this.getRole() + ", regTime=" + this.getRegTime() + ")";
    }

    public enum Role {
        ADMIN("ADMIN"), USER("USER"), GUEST("GUEST");

        private final String value;

        Role(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }
}
