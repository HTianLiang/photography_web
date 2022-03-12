package com.tl.photo.controller;

import com.tl.photo.domain.Links;
import com.tl.photo.service.LinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tl
 * @Date 2021/11/7 8:52 下午
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/links")
public class LinksController {

    @Autowired
    private LinksService linksService;

    /*新增友情链接*/
    @RequestMapping("/addLinks")
    public void addLinks(@RequestBody Links links){
        /*将数据存到集合中*/
        List<Links> linksList = new ArrayList<>();
        linksList.add(links);
        /*保存到数据库*/
        linksService.addLinks(linksList);
    }

    /*查询全部*/
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Links> findAll() {
        return linksService.findAll();
    }

    /*编辑友情链接*/
    @PutMapping("/editLinks")
    public void editLinks(@RequestBody Links links) {
        System.out.println(links);
        linksService.updateLinks(links);
    }

    /*修改友情链接状态*/
    @PutMapping("/updateLinksStatus")
    public void updateLinksStatus(@RequestBody Links links) {
        System.out.println(links);
        // 当状态是 0-未启用时，则修改成启用状态；当状态时 1-已启用时，则关闭启用状态
        if (links.getLinksStatus() == 0) {
            linksService.updateLinksStatusOpen(links);
        } else {
            linksService.updateLinksStatusClose(links);
        }
    }

    /*根据id删除友情链接*/
    @DeleteMapping("/deleteLinksById/{linksId}")
    public void deleteLinksById(@PathVariable("linksId") Integer linksId) {
        System.out.println(linksId);
        linksService.deleteLinksById(linksId);
    }

    /**
     * 根据友情链接名称查询内容
     * @param linksName
     * @return
     */
    @GetMapping("/findByLinksName/{linksName}")
    public List<Links> findByLinksName(@PathVariable("linksName") String linksName) {
        return linksService.findByLinksName(linksName);
    }

    /**
     * 查询开启状态
     * @return
     */
    @GetMapping("/findByOpenStatus")
    public List<Links> findByOpenStatus() {
        return linksService.findByOpenStatus();
    }

}
