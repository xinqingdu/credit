package com.itxiaodu.credit.entity.vo;

import java.io.Serializable;

public class CreditAddressVO  implements Serializable{
    private Integer id;
    private String recipientName;

    private String phoneNum;

    private String address;

    private Integer memberId;

    @Override
    public String toString() {
        return "CreditAddressVO{" +
                "id=" + id +
                ", recipientName='" + recipientName + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", address='" + address + '\'' +
                ", memberId=" + memberId +
                '}';
    }

    public CreditAddressVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public CreditAddressVO(Integer id, String recipientName, String phoneNum, String address, Integer memberId) {
        this.id = id;
        this.recipientName = recipientName;
        this.phoneNum = phoneNum;
        this.address = address;
        this.memberId = memberId;
    }
}
