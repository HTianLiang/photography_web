package com.tl.photo.domain;

/**
 * @Author tl
 * @Date 2021/11/10 5:14 下午
 * @Version 1.0
 * @Description 文案实体类
 */
public class Copywriting {
    /*文案id*/
    private Integer copywritingId;
    /*文案标题*/
    private String copywritingTitle;
    /*文案内容*/
    private String copywritingContent;
    /*文案状态（0-未启用，1-已启用）*/
    private Integer copywritingStatus;

    public Integer getCopywritingId() {
        return copywritingId;
    }

    public void setCopywritingId(Integer copywritingId) {
        this.copywritingId = copywritingId;
    }

    public String getCopywritingTitle() {
        return copywritingTitle;
    }

    public void setCopywritingTitle(String copywritingTitle) {
        this.copywritingTitle = copywritingTitle;
    }

    public String getCopywritingContent() {
        return copywritingContent;
    }

    public void setCopywritingContent(String copywritingContent) {
        this.copywritingContent = copywritingContent;
    }

    public Integer getCopywritingStatus() {
        return copywritingStatus;
    }

    public void setCopywritingStatus(Integer copywritingStatus) {
        this.copywritingStatus = copywritingStatus;
    }

    @Override
    public String toString() {
        return "Copywriting{" +
                "copywritingId=" + copywritingId +
                ", copywritingTitle='" + copywritingTitle + '\'' +
                ", copywritingContent='" + copywritingContent + '\'' +
                ", copywritingStatus=" + copywritingStatus +
                '}';
    }
}
