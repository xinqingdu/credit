package com.itxiaodu.credit.entity.vo;

import java.util.List;

public class CreditTypeVO {
    private Integer id;

    private String typeName;

    private String remark;
    private List<PortalProjectVO> portalProjectVOList;

    public CreditTypeVO() {

    }

    public List<PortalProjectVO> getPortalProjectVOList() {
        return portalProjectVOList;
    }

    public void setPortalProjectVOList(List<PortalProjectVO> portalProjectVOList) {
        this.portalProjectVOList = portalProjectVOList;
    }

    @Override
    public String toString() {
        return "CreditTypeVO{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", remark='" + remark + '\'' +
                ", portalProjectVOList=" + portalProjectVOList +
                '}';
    }

    public CreditTypeVO(Integer id, String typeName, String remark, List<PortalProjectVO> portalProjectVOList) {
        this.id = id;
        this.typeName = typeName;
        this.remark = remark;
        this.portalProjectVOList = portalProjectVOList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


}
