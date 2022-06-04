package com.itxiaodu.credit.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    public Menu(Integer id, Integer pid, String name, String icon, String url) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.icon = icon;
        this.url = url;
//        this.children = children;
//        this.open = open;
    }

    private Integer id;

    private Integer pid;

    private String name;

    private String icon;

    private String url;

    private List<Menu> children = new ArrayList<>();

    private Boolean open = true;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    @Override
    public String toString() {
        return "Menu{" +
            "id=" + id +
            ", pid=" + pid +
            ", name='" + name + '\'' +
            ", icon='" + icon + '\'' +
            ", url='" + url + '\'' +
            ", children=" + children +
            ", open=" + open +
            '}';
    }
}