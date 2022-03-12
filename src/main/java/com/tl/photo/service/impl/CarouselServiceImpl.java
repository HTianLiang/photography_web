package com.tl.photo.service.impl;

import com.tl.photo.domain.Carousel;
import com.tl.photo.mapper.CarouselMapper;
import com.tl.photo.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author tl
 * @Date 2021/11/5 9:46 上午
 * @Version 1.0
 * @Description 轮播图接口实现类
 */
@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public void addCarousel(List<Carousel> carouselList) {
        carouselMapper.addCarousel(carouselList);
    }

    @Override
    public List<Carousel> findAll() {
        return carouselMapper.findAll();
    }

    @Override
    public Carousel findByCarouselId(Integer id) {
        return carouselMapper.findByCarouselId(id);
    }

    @Override
    public List<Carousel> findByCarouselStatusDistinct() {
        return carouselMapper.findByCarouselStatusDistinct();
    }

    @Override
    public void openStatusByCarouselId(Integer id) {
        carouselMapper.openStatusByCarouselId(id);
    }

    @Override
    public void closeStatusByCarouselId(Integer id) {
        carouselMapper.closeStatusByCarouselId(id);
    }

    @Override
    public void deleteCarouselById(Integer id) {
        carouselMapper.deleteCarouselById(id);
    }

    @Override
    public List<Carousel> findByCarouselTitle(String carouselTitle) {
        return carouselMapper.findByCarouselTitle(carouselTitle);
    }

    @Override
    public Carousel findByOpenStatus() {
        return carouselMapper.findByOpenStatus();
    }
}
