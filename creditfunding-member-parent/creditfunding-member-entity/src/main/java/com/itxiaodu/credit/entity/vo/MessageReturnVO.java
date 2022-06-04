package com.itxiaodu.credit.entity.vo;

import java.io.Serializable;

public class MessageReturnVO implements Serializable {
    MessageReturnVO() {

    }
    private Integer returnType;

    private Long supportMoney;

    private String content;

    private Integer count;

    private Integer limitPurchase;

    private Integer purchase;

    private Integer freight;

    private Integer invoice;

    private Integer returnDays;

    private String describPicturePath;


    public MessageReturnVO(Integer returnType, Long supportMoney, String content, Integer count, Integer limitPurchase, Integer purchase, Integer freight, Integer invoice, Integer returnDays, String describPicturePath) {
        this.returnType = returnType;
        this.supportMoney = supportMoney;
        this.content = content;
        this.count = count;
        this.limitPurchase = limitPurchase;
        this.purchase = purchase;
        this.freight = freight;
        this.invoice = invoice;
        this.returnDays = returnDays;
        this.describPicturePath = describPicturePath;
    }

    @Override
    public String toString() {
        return "MessageReturnVO{" +
            "returnType=" + returnType +
            ", supportMoney=" + supportMoney +
            ", content='" + content + '\'' +
            ", count=" + count +
            ", limitPurchase=" + limitPurchase +
            ", purchase=" + purchase +
            ", freight=" + freight +
            ", invoice=" + invoice +
            ", returnDays=" + returnDays +
            ", describPicturePath='" + describPicturePath + '\'' +
            '}';
    }

    public Integer getReturnType() {
        return returnType;
    }

    public void setReturnType(Integer returnType) {
        this.returnType = returnType;
    }

    public Long getSupportMoney() {
        return supportMoney;
    }

    public void setSupportMoney(Long supportMoney) {
        this.supportMoney = supportMoney;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getLimitPurchase() {
        return limitPurchase;
    }

    public void setLimitPurchase(Integer limitPurchase) {
        this.limitPurchase = limitPurchase;
    }

    public Integer getPurchase() {
        return purchase;
    }

    public void setPurchase(Integer purchase) {
        this.purchase = purchase;
    }

    public Integer getFreight() {
        return freight;
    }

    public void setFreight(Integer freight) {
        this.freight = freight;
    }

    public Integer getInvoice() {
        return invoice;
    }

    public void setInvoice(Integer invoice) {
        this.invoice = invoice;
    }

    public Integer getReturnDays() {
        return returnDays;
    }

    public void setReturnDays(Integer returnDays) {
        this.returnDays = returnDays;
    }

    public String getDescribPicturePath() {
        return describPicturePath;
    }

    public void setDescribPicturePath(String describPicturePath) {
        this.describPicturePath = describPicturePath;
    }
}
