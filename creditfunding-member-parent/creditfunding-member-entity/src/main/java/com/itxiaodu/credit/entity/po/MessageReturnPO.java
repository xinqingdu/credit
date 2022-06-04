package com.itxiaodu.credit.entity.po;

public class MessageReturnPO {
    private Integer id;

    private Integer projectId;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
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
        this.content = content == null ? null : content.trim();
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
        this.describPicturePath = describPicturePath == null ? null : describPicturePath.trim();
    }
}