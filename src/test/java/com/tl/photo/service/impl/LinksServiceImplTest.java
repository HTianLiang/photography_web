package com.tl.photo.service.impl;

import com.tl.photo.domain.Links;
import com.tl.photo.service.LinksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author tl
 * @Date 2021/11/7 9:00 下午
 * @Version 1.0
 * @Description
 */
@SpringBootTest
class LinksServiceImplTest {

    @Autowired
    private LinksService linksService;

    @Test
    void addLinks() {
        List<Links> linksList = new ArrayList<>();
        Links links = new Links();
        links.setLinksName("百度");
        links.setLinksAddress("www.baidu.com");
        links.setLinksStatus(0);
        linksList.add(links);

        linksService.addLinks(linksList);
    }

    @Test
    void findAll() {
        List<Links> linksList = linksService.findAll();
        System.out.println(linksList);
    }

    @Test
    void findById() {
        Links links = linksService.findByLinksId(3);
        System.out.println(links.getLinksAddress());
    }

    @Test
    void updateLinksTest() {
        Links links = new Links();
        links.setLinksName("百度");
        links.setLinksAddress("http://www.baidu.com");
        links.setLinksStatus(0);
        links.setLinksId(1);
        linksService.updateLinks(links);
    }

    @Test
    void deleteLinksByIdTest() {
        linksService.deleteLinksById(1);
    }
}