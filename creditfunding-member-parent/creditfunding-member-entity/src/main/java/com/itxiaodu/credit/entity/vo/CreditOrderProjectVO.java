package com.itxiaodu.credit.entity.vo;

import java.io.Serializable;

public class CreditOrderProjectVO implements Serializable {
    private String projectName;

    private String launchName;

    private String returnContent;

    private Integer returnCount;

    private Integer supportPrice;

    private Integer freight;

    private Integer orderId;

    private Integer limitPurchase;

    private Integer Purchase;

    public CreditOrderProjectVO() {
    }

    @Override
    public String toString() {
        return "CreditOrderProjectVO{" +
                "projectName='" + projectName + '\'' +
                ", launchName='" + launchName + '\'' +
                ", returnContent='" + returnContent + '\'' +
                ", returnCount=" + returnCount +
                ", supportPrice=" + supportPrice +
                ", freight=" + freight +
                ", orderId=" + orderId +
                ", limitPurchase=" + limitPurchase +
                ", Purchase=" + Purchase +
                '}';
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getLaunchName() {
        return launchName;
    }

    public void setLaunchName(String launchName) {
        this.launchName = launchName;
    }

    public String getReturnContent() {
        return returnContent;
    }

    public void setReturnContent(String returnContent) {
        this.returnContent = returnContent;
    }

    public Integer getReturnCount() {
        return returnCount;
    }

    public void setReturnCount(Integer returnCount) {
        this.returnCount = returnCount;
    }

    public Integer getSupportPrice() {
        return supportPrice;
    }

    public void setSupportPrice(Integer supportPrice) {
        this.supportPrice = supportPrice;
    }

    public Integer getFreight() {
        return freight;
    }

    public void setFreight(Integer freight) {
        this.freight = freight;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getLimitPurchase() {
        return limitPurchase;
    }

    public void setLimitPurchase(Integer limitPurchase) {
        this.limitPurchase = limitPurchase;
    }

    public Integer getPurchase() {
        return Purchase;
    }

    public void setPurchase(Integer purchase) {
        Purchase = purchase;
    }

    public CreditOrderProjectVO(String projectName, String launchName, String returnContent, Integer returnCount, Integer supportPrice, Integer freight, Integer orderId, Integer limitPurchase, Integer purchase) {
        this.projectName = projectName;
        this.launchName = launchName;
        this.returnContent = returnContent;
        this.returnCount = returnCount;
        this.supportPrice = supportPrice;
        this.freight = freight;
        this.orderId = orderId;
        this.limitPurchase = limitPurchase;
        Purchase = purchase;
    }
}
