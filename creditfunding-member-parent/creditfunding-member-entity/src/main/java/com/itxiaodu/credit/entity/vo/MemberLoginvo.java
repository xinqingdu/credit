package com.itxiaodu.credit.entity.vo;

import java.io.Serializable;

public class MemberLoginvo implements Serializable {
    public MemberLoginvo() {

    }
    private String loginAccount;
    private Integer id;
    private String userName;
    private String email;

    public MemberLoginvo(Integer id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "MemberLoginvo{" +
            "loginAccount='" + loginAccount + '\'' +
            ", id=" + id +
            ", userName='" + userName + '\'' +
            ", email='" + email + '\'' +
            '}';
    }
}
