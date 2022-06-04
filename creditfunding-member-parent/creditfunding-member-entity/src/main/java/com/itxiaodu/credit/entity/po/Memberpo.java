package com.itxiaodu.credit.entity.po;

import java.util.Date;

public class Memberpo {
    public Memberpo(){

    }
    public Memberpo(Integer id, String loginAccount, String userPassword, String userName, String email, Integer authstatus, Integer usertype, String realname, String cardnum, Integer accttype, String telephone, Date createTime, String backup1, String backup2) {
        this.id = id;
        this.loginAccount = loginAccount;
        this.userPassword = userPassword;
        this.userName = userName;
        this.email = email;
        this.authstatus = authstatus;
        this.usertype = usertype;
        this.realname = realname;
        this.cardnum = cardnum;
        this.accttype = accttype;
        this.telephone = telephone;
        this.createTime = createTime;
        this.backup1 = backup1;
        this.backup2 = backup2;
    }

    private Integer id;

    private String loginAccount;

    private String userPassword;

    private String userName;

    private String email;

    private Integer authstatus;

    private Integer usertype;

    private String realname;

    private String cardnum;

    private Integer accttype;

    private String telephone;

    private Date createTime;

    private String backup1;

    private String backup2;

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

    public Integer getAuthstatus() {
        return authstatus;
    }

    public void setAuthstatus(Integer authstatus) {
        this.authstatus = authstatus;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum == null ? null : cardnum.trim();
    }

    public Integer getAccttype() {
        return accttype;
    }

    public void setAccttype(Integer accttype) {
        this.accttype = accttype;
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

    @Override
    public String toString() {
        return "Memberpo{" +
            "id=" + id +
            ", loginAccount='" + loginAccount + '\'' +
            ", userPassword='" + userPassword + '\'' +
            ", userName='" + userName + '\'' +
            ", email='" + email + '\'' +
            ", authstatus=" + authstatus +
            ", usertype=" + usertype +
            ", realname='" + realname + '\'' +
            ", cardnum='" + cardnum + '\'' +
            ", accttype=" + accttype +
            ", telephone='" + telephone + '\'' +
            ", createTime=" + createTime +
            ", backup1='" + backup1 + '\'' +
            ", backup2='" + backup2 + '\'' +
            '}';
    }
}