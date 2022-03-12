package com.tl.photo.domain;

/**
 * @Author tl
 * @Date 2021/11/7 8:35 下午
 * @Version 1.0
 * @Description 友情链接实体类
 */
public class Links {
    /*友情链接ID*/
    private Integer linksId;
    /*友情链接名称*/
    private String linksName;
    /*友情链接地址*/
    private String linksAddress;
    /*当前状态*/
    private Integer linksStatus;
    private String linksStatusStr;

    public Integer getLinksId() {
        return linksId;
    }

    public void setLinksId(Integer linksId) {
        this.linksId = linksId;
    }

    public String getLinksName() {
        return linksName;
    }

    public void setLinksName(String linksName) {
        this.linksName = linksName;
    }

    public String getLinksAddress() {
        return linksAddress;
    }

    public void setLinksAddress(String linksAddress) {
        this.linksAddress = linksAddress;
    }

    public Integer getLinksStatus() {
        return linksStatus;
    }

    public void setLinksStatus(Integer linksStatus) {
        this.linksStatus = linksStatus;
    }

    public String getLinksStatusStr() {
        return linksStatusStr;
    }

    public void setLinksStatusStr(String linksStatusStr) {
        this.linksStatusStr = linksStatusStr;
    }

    @Override
    public String toString() {
        return "Links{" +
                "linksId=" + linksId +
                ", linksName='" + linksName + '\'' +
                ", linksAddress='" + linksAddress + '\'' +
                ", linksStatus=" + linksStatus +
                ", linksStatusStr='" + linksStatusStr + '\'' +
                '}';
    }
}
