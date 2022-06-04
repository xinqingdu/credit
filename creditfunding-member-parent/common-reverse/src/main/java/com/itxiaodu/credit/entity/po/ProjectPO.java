package com.itxiaodu.credit.entity.po;

import java.util.Date;

public class ProjectPO {
    private Integer id;

    private String projectName;

    private String projectDescription;

    private Long money;

    private Integer days;

    private Integer projectStatus;

    private Date deployDate;

    private Date createDate;

    private Long supportMoney;

    private Integer support;

    private Integer completions;

    private Integer memberId;

    private Integer follower;

    private String headerPicturePath;

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
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription == null ? null : projectDescription.trim();
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Integer projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Date getDeployDate() {
        return deployDate;
    }

    public void setDeployDate(Date deployDate) {
        this.deployDate = deployDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getSupportMoney() {
        return supportMoney;
    }

    public void setSupportMoney(Long supportMoney) {
        this.supportMoney = supportMoney;
    }

    public Integer getSupport() {
        return support;
    }

    public void setSupport(Integer support) {
        this.support = support;
    }

    public Integer getCompletions() {
        return completions;
    }

    public void setCompletions(Integer completions) {
        this.completions = completions;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getFollower() {
        return follower;
    }

    public void setFollower(Integer follower) {
        this.follower = follower;
    }

    public String getHeaderPicturePath() {
        return headerPicturePath;
    }

    public void setHeaderPicturePath(String headerPicturePath) {
        this.headerPicturePath = headerPicturePath == null ? null : headerPicturePath.trim();
    }
}