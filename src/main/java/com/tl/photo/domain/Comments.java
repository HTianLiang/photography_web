package com.tl.photo.domain;

import java.io.Serializable;

/**
 * @Author tl
 * @Date 2022/2/8 2:53 下午
 * @Version 1.0
 * @Description 评论实体类
 */
public class Comments implements Serializable {
    private static final long serialVersionUID = 1L;
    /*评论id*/
    private Integer id;
    /*用户id*/
    private Integer usersId;
    /*用户名*/
    private String username;
    /*用户头像*/
    private String avatarPic;
    /*作品id*/
    private Integer worksId;
    /*评论内容*/
    private String content;
    /*评论时间*/
    private String createTime;
    /*评论者所在ip地址*/
    private String commentIp;
    /*评论审核状态*/
    private Integer commentStatus;
    /*审核时间*/
    private String auditTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatarPic() {
        return avatarPic;
    }

    public void setAvatarPic(String avatarPic) {
        this.avatarPic = avatarPic;
    }

    public Integer getWorksId() {
        return worksId;
    }

    public void setWorksId(Integer worksId) {
        this.worksId = worksId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getCommentIp() {
        return commentIp;
    }

    public void setCommentIp(String commentIp) {
        this.commentIp = commentIp;
    }

    public String getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(String auditTime) {
        this.auditTime = auditTime;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", usersId=" + usersId +
                ", username='" + username + '\'' +
                ", avatarPic='" + avatarPic + '\'' +
                ", worksId=" + worksId +
                ", content='" + content + '\'' +
                ", createTime='" + createTime + '\'' +
                ", commentIp='" + commentIp + '\'' +
                ", commentStatus=" + commentStatus +
                ", auditTime='" + auditTime + '\'' +
                '}';
    }
}
