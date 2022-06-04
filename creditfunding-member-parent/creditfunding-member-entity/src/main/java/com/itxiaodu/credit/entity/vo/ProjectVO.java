package com.itxiaodu.credit.entity.vo;
import java.io.Serializable;
import java.util.List;
import java.sql.Date;
public class ProjectVO implements Serializable {
    ProjectVO() {

    }
    private List<Integer> typeIdList;
    private List<Integer> tagIdList;
    private String projectName;
    private String projectDescription;
    private Integer money;
    private Integer days;
    private Date createDate;
    private String headerPicturePath;
    private ProjectMemberInfoVO projectMemberInfoVO;
    private List<String> detailPicturePathList;
    private List<MessageReturnVO> messageReturnList;
    private MemberConfirmInfoVO memberConfirmInfoVO;

    public List<String> getDetailPicturePathList() {
        return detailPicturePathList;
    }

    public void setDetailPicturePathList(List<String> detailPicturePathList) {
        this.detailPicturePathList = detailPicturePathList;
    }

    public List<Integer> getTypeIdList() {
        return typeIdList;
    }

    public void setTypeIdList(List<Integer> typeIdList) {
        this.typeIdList = typeIdList;
    }

    public List<Integer> getTagIdList() {
        return tagIdList;
    }

    public void setTagIdList(List<Integer> tagIdList) {
        this.tagIdList = tagIdList;
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

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getHeaderPicturePath() {
        return headerPicturePath;
    }

    public void setHeaderPicturePath(String headerPicturePath) {
        this.headerPicturePath = headerPicturePath;
    }

    public ProjectMemberInfoVO getProjectMemberInfoVO() {
        return projectMemberInfoVO;
    }

    public void setProjectMemberInfoVO(ProjectMemberInfoVO projectMemberInfoVO) {
        this.projectMemberInfoVO = projectMemberInfoVO;
    }

    public List<MessageReturnVO> getMessageReturnList() {
        return messageReturnList;
    }

    public void setMessageReturnList(List<MessageReturnVO> messageReturnList) {
        this.messageReturnList = messageReturnList;
    }

    public MemberConfirmInfoVO getMemberConfirmInfoVO() {
        return memberConfirmInfoVO;
    }

    public void setMemberConfirmInfoVO(MemberConfirmInfoVO memberConfirmInfoVO) {
        this.memberConfirmInfoVO = memberConfirmInfoVO;
    }

    public ProjectVO(List<Integer> typeIdList, List<Integer> tagIdList, String projectName, String projectDescription, Integer money, Integer days, Date createDate, String headerPicturePath, ProjectMemberInfoVO projectMemberInfoVO, List<String> detailPicturePathList, List<MessageReturnVO> messageReturnList, MemberConfirmInfoVO memberConfirmInfoVO) {
        this.typeIdList = typeIdList;
        this.tagIdList = tagIdList;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.money = money;
        this.days = days;
        this.createDate = createDate;
        this.headerPicturePath = headerPicturePath;
        this.projectMemberInfoVO = projectMemberInfoVO;
        this.detailPicturePathList = detailPicturePathList;
        this.messageReturnList = messageReturnList;
        this.memberConfirmInfoVO = memberConfirmInfoVO;
    }

    @Override
    public String toString() {
        return "ProjectVO{" +
                "typeIdList=" + typeIdList +
                ", tagIdList=" + tagIdList +
                ", projectName='" + projectName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", money=" + money +
                ", days=" + days +
                ", createDate=" + createDate +
                ", headerPicturePath='" + headerPicturePath + '\'' +
                ", projectMemberInfoVO=" + projectMemberInfoVO +
                ", detailPicturePathList=" + detailPicturePathList +
                ", messageReturnList=" + messageReturnList +
                ", memberConfirmInfoVO=" + memberConfirmInfoVO +
                '}';
    }
}
