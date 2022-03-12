package com.tl.photo.controller;

import com.tl.photo.domain.Copywriting;
import com.tl.photo.service.CopywritingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tl
 * @Date 2021/11/11 3:34 下午
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/copywriting")
public class CopywritingController {

    @Autowired
    private CopywritingService copywritingService;

    /*查询全部*/
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Copywriting> findAll() {
        return copywritingService.findAll();
    }

    /*新增文案*/
    @RequestMapping("/addCopywriting")
    public void addCopywriting(@RequestBody Copywriting copywriting) {
        //System.out.println(copywriting);
        List<Copywriting> copywritingList = new ArrayList<>();
        copywritingList.add(copywriting);
        copywritingService.addCopywriting(copywritingList);
    }

    /*编辑文案*/
    @PutMapping("/editCopywriting")
    public void editCopywriting(@RequestBody Copywriting copywriting) {
        System.out.println(copywriting);
        copywritingService.updateCopywriting(copywriting);
    }

    /*根据id删除文案*/
    @DeleteMapping("/deleteCopywritingById/{copywritingId}")
    public void deleteCopywritingById(@PathVariable("copywritingId") Integer copywritingId) {
        System.out.println(copywritingId);
        copywritingService.deleteCopywritingById(copywritingId);
    }

    /*查询状态是否有不同的值*/
    @RequestMapping("/findByStatusDistinct")
    public List<Copywriting> findByStatusDistinct(){
        return copywritingService.findByCopywritingStatusDistinct();
    }

    /**
     * 开启启用状态
     * @param copywriting
     */
    @PutMapping("/openStatusByCopywritingId")
    public void openStatusByLinksId(@RequestBody Copywriting copywriting) {
        copywritingService.openStatusByCopywritingId(copywriting.getCopywritingId());
    }

    /**
     * 关闭启用状态
     * @param copywriting
     */
    @PutMapping("/closeStatusByCopywritingId")
    public void closeStatusByLinksId(@RequestBody Copywriting copywriting) {
        copywritingService.closeStatusByCopywritingId(copywriting.getCopywritingId());
    }

    /**
     * 根据文案标题查询
     * @param copywritingTitle
     * @return
     */
    @GetMapping("/findByCopywritingTitle/{copywritingTitle}")
    public List<Copywriting> findByCopywritingTitle(@PathVariable("copywritingTitle") String copywritingTitle) {
        return copywritingService.findByCopywritingTitle(copywritingTitle);
    }

    /**
     * 查询开启状态
     * @return
     */
    @GetMapping("/findByOpenStatus")
    public List<Copywriting> findByOpenStatus() {
        return copywritingService.findByOpenStatus();
    }

}
