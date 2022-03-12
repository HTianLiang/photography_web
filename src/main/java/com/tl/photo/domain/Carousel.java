package com.tl.photo.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @Author tl
 * @Date 2021/11/5 9:06 上午
 * @Version 1.0
 * @Description 轮播图实体类
 */
public class Carousel implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer carouselId;
    /*轮播图标题*/
    private String carouselTitle;
    /*轮播图路径*/
    private String carouselPath;
    /*轮播图url*/
    private String carouselUrl;
    /*轮播图上传时间*/
    private String carouselUploadTime;
    /*当前状态*/
    private Integer carouselStatus;

    /*将carouselUrl按逗号分隔*/
    private List carouselUrlList;

    public Integer getCarouselId() {
        return carouselId;
    }

    public void setCarouselId(Integer carouselId) {
        this.carouselId = carouselId;
    }

    public String getCarouselTitle() {
        return carouselTitle;
    }

    public void setCarouselTitle(String carouselTitle) {
        this.carouselTitle = carouselTitle;
    }

    public String getCarouselPath() {
        return carouselPath;
    }

    public void setCarouselPath(String carouselPath) {
        this.carouselPath = carouselPath;
    }

    public String getCarouselUrl() {
        return carouselUrl;
    }

    public void setCarouselUrl(String carouselUrl) {
        this.carouselUrl = carouselUrl;
    }

    public String getCarouselUploadTime() {
        return carouselUploadTime;
    }

    public void setCarouselUploadTime(String carouselUploadTime) {
        this.carouselUploadTime = carouselUploadTime;
    }

    public Integer getCarouselStatus() {
        return carouselStatus;
    }

    public void setCarouselStatus(Integer carouselStatus) {
        this.carouselStatus = carouselStatus;
    }

    public List getCarouselUrlList() {
        return Arrays.asList(this.carouselUrl.trim().split(","));
    }

    public void setCarouselUrlList(List carouselUrlList) {
        this.carouselUrlList = carouselUrlList;
    }

    @Override
    public String toString() {
        return "Carousel{" +
                "carouselId=" + carouselId +
                ", carouselTitle='" + carouselTitle + '\'' +
                ", carouselPath='" + carouselPath + '\'' +
                ", carouselUrl='" + carouselUrl + '\'' +
                ", carouselUploadTime='" + carouselUploadTime + '\'' +
                ", carouselStatus=" + carouselStatus +
                ", carouselUrlList=" + carouselUrlList +
                '}';
    }
}
