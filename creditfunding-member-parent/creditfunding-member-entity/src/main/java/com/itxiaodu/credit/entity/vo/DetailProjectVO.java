package com.itxiaodu.credit.entity.vo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class DetailProjectVO implements Serializable {
    private Integer projectId;
    private String projectName;
    private String projectDescription;
    private Integer follower;
    private Long money;
    private Long supportMoney;
    private Integer projectStatus;
    private Integer completions;
    private Date deployDate;
    private Integer lastDay;
    private Integer days;
    private Integer support;
    private String headerPicturePath;
    private List<String> detailPicturePathList;
    private List<DetailReturnVO> detailReturnVOList;


    public DetailProjectVO(){

    }
    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public Integer getFollower() {
        return follower;
    }

    public void setFollower(Integer follower) {
        this.follower = follower;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Long getSupportMoney() {
        return supportMoney;
    }

    public void setSupportMoney(Long supportMoney) {
        this.supportMoney = supportMoney;
    }

    public Integer getCompletions() {
        return completions;
    }

    public void setCompletions(Integer completions) {
        this.completions = completions;
    }

    public Date getDeployDate() {
        return deployDate;
    }

    public void setDeployDate(Date deployDate) {
        this.deployDate = deployDate;
    }

    public Integer getLastDay() {
        return lastDay;
    }

    public void setLastDay(Integer lastDay) {
        this.lastDay = lastDay;
    }

    public Integer getSupport() {
        return support;
    }

    public void setSupport(Integer support) {
        this.support = support;
    }

    public String getHeaderPicturePath() {
        return headerPicturePath;
    }

    public void setHeaderPicturePath(String headerPicturePath) {
        this.headerPicturePath = headerPicturePath;
    }

    public List<String> getDetailPicturePathList() {
        return detailPicturePathList;
    }

    public void setDetailPicturePathList(List<String> detailPicturePathList) {
        this.detailPicturePathList = detailPicturePathList;
    }

    public List<DetailReturnVO> getDetailReturnVOList() {
        return detailReturnVOList;
    }

    public void setDetailReturnVOList(List<DetailReturnVO> detailReturnVOList) {
        this.detailReturnVOList = detailReturnVOList;
    }

    @Override
    public String toString() {
        return "DetailProjectVO{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", follower=" + follower +
                ", money=" + money +
                ", supportMoney=" + supportMoney +
                ", projectStatus=" + projectStatus +
                ", completions=" + completions +
                ", deployDate=" + deployDate +
                ", lastDay=" + lastDay +
                ", days=" + days +
                ", support=" + support +
                ", headerPicturePath='" + headerPicturePath + '\'' +
                ", detailPicturePathList=" + detailPicturePathList +
                ", detailReturnVOList=" + detailReturnVOList +
                '}';
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public DetailProjectVO(Integer projectId, String projectName, String projectDescription, Integer follower, Long money, Long supportMoney, Integer projectStatus, Integer completions, Date deployDate, Integer lastDay, Integer days, Integer support, String headerPicturePath, List<String> detailPicturePathList, List<DetailReturnVO> detailReturnVOList) {

        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.follower = follower;
        this.money = money;
        this.supportMoney = supportMoney;
        this.projectStatus = projectStatus;
        this.completions = completions;
        this.deployDate = deployDate;
        this.lastDay = lastDay;
        this.days = days;
        this.support = support;
        this.headerPicturePath = headerPicturePath;
        this.detailPicturePathList = detailPicturePathList;
        this.detailReturnVOList = detailReturnVOList;
    }

    public Integer getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Integer projectStatus) {
        this.projectStatus = projectStatus;
    }
}
