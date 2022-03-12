package com.tl.photo.service;

import com.tl.photo.domain.Carousel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author tl
 * @Date 2021/11/5 9:46 上午
 * @Version 1.0
 * @Description 轮播图接口
 */
public interface CarouselService {
    // 添加轮播图
    void addCarousel(List<Carousel> carouselList);
    // 查询全部
    List<Carousel> findAll();
    // 根据轮播图id查询
    Carousel findByCarouselId(Integer id);
    // 查询状态是否有不同的值
    List<Carousel> findByCarouselStatusDistinct();
    // 根据id开启状态
    void openStatusByCarouselId(Integer id);
    // 根据id关闭启用状态
    void closeStatusByCarouselId(Integer id);
    // 根据id删除轮播图
    void deleteCarouselById(Integer id);
    // 根据轮播图查询内容
    List<Carousel> findByCarouselTitle(String carouselTitle);
    // 查询启用状态的轮播图
    Carousel findByOpenStatus();
}
