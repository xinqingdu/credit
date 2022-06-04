package com.itxiaodu.credit.entity;

import java.util.Date;

public class Admin {
    private Integer id;

    private String loginAccount;

    private String userPassword;

    private String userName;

    private String email;

    private String telephone;

    private Date createTime;

    private String backup1;

    private String backup2;

    public Admin() {
    }

    public Admin(Integer id, String loginAccount, String userPassword, String userName, String email, String telephone, Date createTime, String backup1, String backup2) {
        this.id = id;
        this.loginAccount = loginAccount;
        this.userPassword = userPassword;
        this.userName = userName;
        this.email = email;
        this.telephone = telephone;
        this.createTime = createTime;
        this.backup1 = backup1;
        this.backup2 = backup2;
    }

    @Override
    public String toString() {
        return "Admin{" +
            "id=" + id +
            ", loginAccount='" + loginAccount + '\'' +
            ", userPassword='" + userPassword + '\'' +
            ", userName='" + userName + '\'' +
            ", email='" + email + '\'' +
            ", telephone='" + telephone + '\'' +
            ", createTime=" + createTime +
            ", backup1='" + backup1 + '\'' +
            ", backup2='" + backup2 + '\'' +
            '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount == null ? null : loginAccount.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBackup1() {
        return backup1;
    }

    public void setBackup1(String backup1) {
        this.backup1 = backup1 == null ? null : backup1.trim();
    }

    public String getBackup2() {
        return backup2;
    }

    public void setBackup2(String backup2) {
        this.backup2 = backup2 == null ? null : backup2.trim();
    }
}