package com.itxiaodu.credit.entity.vo;

import java.io.Serializable;

public class MemberConfirmInfoVO implements Serializable {
    MemberConfirmInfoVO() {

    }
    private String payAccount;

    private String idCard;

    @Override
    public String toString() {
        return "MemberConfirmInfoVO{" +
            "payAccount='" + payAccount + '\'' +
            ", idCard='" + idCard + '\'' +
            '}';
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public MemberConfirmInfoVO(String payAccount, String idCard) {
        this.payAccount = payAccount;
        this.idCard = idCard;
    }
}
