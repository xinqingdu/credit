package com.itxiaodu.credit.entity.vo;

import java.io.Serializable;

public class CreditOrderVO implements Serializable {
    private String orderNum;

    private String payOrderNum;

    private Double orderAmount;

    private Integer invoice;

    private String invoiceTitle;

    private String orderRemark;

    private Integer addressId;

    private CreditOrderProjectVO creditOrderProjectVO;

    public CreditOrderVO() {
    }

    @Override
    public String toString() {
        return "CreditOrderVO{" +
                "orderNum='" + orderNum + '\'' +
                ", payOrderNum='" + payOrderNum + '\'' +
                ", orderAmount=" + orderAmount +
                ", invoice=" + invoice +
                ", invoiceTitle='" + invoiceTitle + '\'' +
                ", orderRemark='" + orderRemark + '\'' +
                ", addressId=" + addressId +
                ", creditOrderProjectVO=" + creditOrderProjectVO +
                '}';
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getPayOrderNum() {
        return payOrderNum;
    }

    public void setPayOrderNum(String payOrderNum) {
        this.payOrderNum = payOrderNum;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getInvoice() {
        return invoice;
    }

    public void setInvoice(Integer invoice) {
        this.invoice = invoice;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public CreditOrderProjectVO getCreditOrderProjectVO() {
        return creditOrderProjectVO;
    }

    public void setCreditOrderProjectVO(CreditOrderProjectVO creditOrderProjectVO) {
        this.creditOrderProjectVO = creditOrderProjectVO;
    }

    public CreditOrderVO(String orderNum, String payOrderNum, Double orderAmount, Integer invoice, String invoiceTitle, String orderRemark, Integer addressId, CreditOrderProjectVO creditOrderProjectVO) {

        this.orderNum = orderNum;
        this.payOrderNum = payOrderNum;
        this.orderAmount = orderAmount;
        this.invoice = invoice;
        this.invoiceTitle = invoiceTitle;
        this.orderRemark = orderRemark;
        this.addressId = addressId;
        this.creditOrderProjectVO = creditOrderProjectVO;
    }
}
