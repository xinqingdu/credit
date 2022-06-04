package com.itxiaodu.credit.entity.vo;

public class Membervo {
    Membervo() {

    }
    private String loginAccount;

    private String userPassword;
    private String userPasswordTemp;

    private String userName;
    private String email;
    private String telephone;
    private String code;

    public Membervo(String loginAccount, String userPasswordTemp, String userPassword, String userName, String email, String telephone, String code) {
        this.loginAccount = loginAccount;
        this.userPassword = userPassword;
        this.userPasswordTemp=userPasswordTemp;
        this.userName = userName;
        this.email = email;
        this.telephone = telephone;
        this.code = code;
    }

    public String getUserPasswordTemp() {
        return userPasswordTemp;
    }

    public void setUserPasswordTemp(String userPasswordTemp) {
        this.userPasswordTemp = userPasswordTemp;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getCode() {
        return code;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Membervo{" +
            "loginAccount='" + loginAccount + '\'' +
            ", userPassword='" + userPassword + '\'' +
            ", userPasswordTemp='" + userPasswordTemp + '\'' +
            ", userName='" + userName + '\'' +
            ", email='" + email + '\'' +
            ", telephone='" + telephone + '\'' +
            ", code='" + code + '\'' +
            '}';
    }
}
