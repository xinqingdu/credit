package com.itxiaodu.credit.entity.vo;

public class DetailReturnVO {
    private Integer id;
    private Long supportMoney;
    private Integer limitPurchase;
    private Integer purchase;
    private Integer freight;
    private Integer returnDays;
    private String content;

    public DetailReturnVO() {
    }

    @Override
    public String toString() {
        return "DetailReturnVO{" +
                "id=" + id +
                ", supportMoney=" + supportMoney +
                ", limitPurchase=" + limitPurchase +
                ", purchase=" + purchase +
                ", freight=" + freight +
                ", returnDays=" + returnDays +
                ", content='" + content + '\'' +
                '}';
    }

    public Integer getPurchase() {
        return purchase;
    }

    public void setPurchase(Integer purchase) {
        this.purchase = purchase;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getSupportMoney() {
        return supportMoney;
    }

    public void setSupportMoney(Long supportMoney) {
        this.supportMoney = supportMoney;
    }

    public Integer getLimitPurchase() {
        return limitPurchase;
    }

    public void setLimitPurchase(Integer limitPurchase) {
        this.limitPurchase = limitPurchase;
    }


    public Integer getFreight() {
        return freight;
    }

    public void setFreight(Integer freight) {
        this.freight = freight;
    }

    public Integer getReturnDays() {
        return returnDays;
    }

    public void setReturnDays(Integer returnDays) {
        this.returnDays = returnDays;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DetailReturnVO(Integer id, Long supportMoney, Integer limitPurchase, Integer purchase, Integer freight, Integer returnDays, String content) {
        this.id = id;
        this.supportMoney = supportMoney;
        this.limitPurchase = limitPurchase;
        this.purchase = purchase;
        this.freight = freight;
        this.returnDays = returnDays;
        this.content = content;
    }
}
