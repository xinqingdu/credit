package com.itxiaodu.credit.entity.po;

public class ProjectItemPO {
    private Integer id;

    private Integer projectId;

    private String itemPicturePath;

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

    public String getItemPicturePath() {
        return itemPicturePath;
    }

    public void setItemPicturePath(String itemPicturePath) {
        this.itemPicturePath = itemPicturePath == null ? null : itemPicturePath.trim();
    }
}