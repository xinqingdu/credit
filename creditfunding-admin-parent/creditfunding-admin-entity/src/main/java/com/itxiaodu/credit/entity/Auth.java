package com.itxiaodu.credit.entity;

public class Auth {
    public Auth(Integer id, String name, String title, Integer pid) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.pid = pid;
    }

    private Integer id;

    private String name;

    private String title;

    private Integer pid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Auth{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", title='" + title + '\'' +
            ", pid=" + pid +
            '}';
    }
}