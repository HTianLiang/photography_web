package com.tl.photo.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @Author tl
 * @Date 2021/11/15 4:21 下午
 * @Version 1.0
 * @Description 作品表
 */
public class WorksVo implements Serializable {
    private static final long serialVersionUID = 1L;
    /*作品id*/
    private Integer worksId;
    /*作品标题*/
    private String worksTitle;
    /*作品描述*/
    private String worksDesc;
    /*作品属性（0-不公开，1-公开）*/
    private Integer worksProp;
    /*作品图片路径*/
    private String worksPath;
    /*作品图片地址*/
    private String worksUrl;
    /*作品发布时间*/
    private String worksPublishTime;
    /*发布作品ip地址*/
    private String worksPublishIp;
    /*作品审核时间*/
    private String worksAuditTime;
    /*作品审核状态（0-不通过，1-通过）*/
    private Integer worksStatus;
    /*用户id*/
    private Integer usersId;
    /*浏览量*/
    private Integer watchNum;

    // 用户
    private Users users;

    /*将worksUrl按逗号分隔*/
    private List worksUrlList;
    /*将worksDesc按#分隔*/
    private List worksDescList;

    public Integer getWorksId() {
        return worksId;
    }

    public void setWorksId(Integer worksId) {
        this.worksId = worksId;
    }

    public String getWorksTitle() {
        return worksTitle;
    }

    public void setWorksTitle(String worksTitle) {
        this.worksTitle = worksTitle;
    }

    public String getWorksDesc() {
        return worksDesc;
    }

    public void setWorksDesc(String worksDesc) {
        this.worksDesc = worksDesc;
    }

    public Integer getWorksProp() {
        return worksProp;
    }

    public void setWorksProp(Integer worksProp) {
        this.worksProp = worksProp;
    }

    public String getWorksPath() {
        return worksPath;
    }

    public void setWorksPath(String worksPath) {
        this.worksPath = worksPath;
    }

    public String getWorksUrl() {
        return worksUrl;
    }

    public void setWorksUrl(String worksUrl) {
        this.worksUrl = worksUrl;
    }

    public String getWorksPublishTime() {
        return worksPublishTime;
    }

    public void setWorksPublishTime(String worksPublishTime) {
        this.worksPublishTime = worksPublishTime;
    }

    public String getWorksPublishIp() {
        return worksPublishIp;
    }

    public void setWorksPublishIp(String worksPublishIp) {
        this.worksPublishIp = worksPublishIp;
    }

    public String getWorksAuditTime() {
        return worksAuditTime;
    }

    public void setWorksAuditTime(String worksAuditTime) {
        this.worksAuditTime = worksAuditTime;
    }

    public Integer getWorksStatus() {
        return worksStatus;
    }

    public void setWorksStatus(Integer worksStatus) {
        this.worksStatus = worksStatus;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public List getWorksUrlList() {
        return Arrays.asList(this.worksUrl.trim().split(","));
    }

    public void setWorksUrlList(List worksUrlList) {
        this.worksUrlList = worksUrlList;
    }

    public List getWorksDescList() {
        return Arrays.asList(this.worksDesc.trim().split("#"));
    }

    public void setWorksDescList(List worksDescList) {
        this.worksDescList = worksDescList;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Integer getWatchNum() {
        return watchNum;
    }

    public void setWatchNum(Integer watchNum) {
        this.watchNum = watchNum;
    }

    @Override
    public String toString() {
        return "WorksVo{" +
                "worksId=" + worksId +
                ", worksTitle='" + worksTitle + '\'' +
                ", worksDesc='" + worksDesc + '\'' +
                ", worksProp=" + worksProp +
                ", worksPath='" + worksPath + '\'' +
                ", worksUrl='" + worksUrl + '\'' +
                ", worksPublishTime='" + worksPublishTime + '\'' +
                ", worksPublishIp='" + worksPublishIp + '\'' +
                ", worksAuditTime='" + worksAuditTime + '\'' +
                ", worksStatus=" + worksStatus +
                ", usersId=" + usersId +
                ", watchNum=" + watchNum +
                ", users=" + users +
                ", worksUrlList=" + worksUrlList +
                ", worksDescList=" + worksDescList +
                '}';
    }
}
