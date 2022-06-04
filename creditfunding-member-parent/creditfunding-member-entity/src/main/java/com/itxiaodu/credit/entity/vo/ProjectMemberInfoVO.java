package com.itxiaodu.credit.entity.vo;

import java.io.Serializable;

public class ProjectMemberInfoVO implements Serializable {
    ProjectMemberInfoVO() {

    }
    private String descriptionSimple;

    private String descriptionDetail;

    private String phoneNum;

    private String serviceNum;

    @Override
    public String toString() {
        return "ProjectMemberInfoVO{" +
            "descriptionSimple='" + descriptionSimple + '\'' +
            ", descriptionDetail='" + descriptionDetail + '\'' +
            ", phoneNum='" + phoneNum + '\'' +
            ", serviceNum='" + serviceNum + '\'' +
            '}';
    }

    public ProjectMemberInfoVO(String descriptionSimple, String descriptionDetail, String phoneNum, String serviceNum) {
        this.descriptionSimple = descriptionSimple;
        this.descriptionDetail = descriptionDetail;
        this.phoneNum = phoneNum;
        this.serviceNum = serviceNum;
    }

    public String getDescriptionSimple() {
        return descriptionSimple;
    }

    public void setDescriptionSimple(String descriptionSimple) {
        this.descriptionSimple = descriptionSimple;
    }

    public String getDescriptionDetail() {
        return descriptionDetail;
    }

    public void setDescriptionDetail(String descriptionDetail) {
        this.descriptionDetail = descriptionDetail;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getServiceNum() {
        return serviceNum;
    }

    public void setServiceNum(String serviceNum) {
        this.serviceNum = serviceNum;
    }
}
