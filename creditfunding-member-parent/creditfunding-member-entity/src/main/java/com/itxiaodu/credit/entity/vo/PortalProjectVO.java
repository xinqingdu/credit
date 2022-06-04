package com.itxiaodu.credit.entity.vo;

import java.sql.Date;

public class PortalProjectVO {
    private Integer id;
    private String projectName;
    private String headerPicturePath;
    private Integer money;
    private Date deployDate;
    private Integer completions;
    private Integer support;

    public PortalProjectVO() {

    }

    @Override
    public String toString() {
        return "PortalProjectVO{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", headerPicturePath='" + headerPicturePath + '\'' +
                ", money=" + money +
                ", deployDate=" + deployDate +
                ", completions=" + completions +
                ", support=" + support +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getHeaderPicturePath() {
        return headerPicturePath;
    }

    public void setHeaderPicturePath(String headerPicturePath) {
        this.headerPicturePath = headerPicturePath;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getDeployDate() {
        return deployDate;
    }

    public void setDeployDate(Date deployDate) {
        this.deployDate = deployDate;
    }

    public Integer getSupport() {
        return support;
    }

    public void setSupport(Integer support) {
        this.support = support;
    }

    public PortalProjectVO(Integer id, String projectName, String headerPicturePath, Integer money, Date deployDate, Integer completions, Integer support) {
        this.id = id;
        this.projectName = projectName;
        this.headerPicturePath = headerPicturePath;
        this.money = money;
        this.deployDate = deployDate;
        this.completions = completions;
        this.support = support;
    }

    public Integer getCompletions() {
        return completions;
    }

    public void setCompletions(Integer completions) {
        this.completions = completions;
    }
}
