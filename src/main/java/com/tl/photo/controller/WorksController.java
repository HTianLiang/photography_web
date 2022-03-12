package com.tl.photo.controller;

import com.tl.photo.domain.Works;
import com.tl.photo.domain.WorksVo;
import com.tl.photo.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author tl
 * @Date 2022/1/21 11:14 上午
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/works")
public class WorksController {
    @Autowired
    private WorksService worksService;

    // 作品发布
    @RequestMapping("/publish")
    public void worksPublish(@RequestParam("files") MultipartFile[] files,
                             @RequestParam("worksTitle") String worksTitle,
                             @RequestParam("worksDesc") String worksDesc,
                             @RequestParam("worksProp") Integer worksProp,
                             @RequestParam("worksPublishIp") String worksPublishIp,
                             @RequestParam("usersId") Integer usersId) {
        System.out.print("******************************发布作品******************************\n");
        // 存储绝对路径
        String path = "";
        // 存储图片名称
        String imgName = "";
        // 图片url
        String url = "";

        System.out.println("标题："+worksTitle+" 描述"+worksDesc+" 属性："+worksProp+" 用户id："+usersId+" ip："+worksPublishIp);
        for (MultipartFile file : files) {
            // 获取文件名
            String fileName = file.getOriginalFilename();
            // 生成 1 到 99 之间随机数+文件名
//            fileName = (int) (Math.random() * 99) + 1 + "_" + fileName;
            fileName = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(new Date()) + "_" + fileName;
            System.out.print("（加个随机数，尽量避免文件名称重复）保存的文件名为: " + fileName + "\n");
            // 存储图片名称
            imgName += fileName + ",";
            System.out.println("图片名称：" + imgName);

            // 存储图片绝对路径
            String imgPath = "/Users/tl/fileUpload/photos/works/" + fileName;
            // 存储绝对路径
            path += imgPath + ",";
            //文件绝对路径
            //System.out.print("保存文件绝对路径" + path + "\n");

            //创建文件路径
            File dest = new File(imgPath);

            //判断文件是否已经存在
            if (dest.exists()) {
                System.out.println("文件已经存在");
            }
            //判断文件父目录是否存在
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdir();
            }

            try {
                //上传文件
                file.transferTo(dest); //保存文件
                System.out.print("保存文件绝对路径:" + path + "\n");
                //url="http://你自己的域名/项目名/photos/"+fileName;//正式项目
                url += "http://localhost:8089/photos/works/" + fileName+",";//本地运行项目

                System.out.print("保存的完整url：" + url + "\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 创建当前时间
        String publishDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        List<Works> worksList = new ArrayList<>();
        // trim() 去除开头和结尾的空格
        Works works = new Works();
        works.setWorksTitle(worksTitle.trim());
        works.setWorksDesc(worksDesc.trim());
        works.setWorksProp(worksProp);
        works.setWorksPath(path.trim());
        works.setWorksUrl(url.trim());
        works.setWorksPublishTime(publishDate);
        works.setWorksPublishIp(worksPublishIp.trim());
        works.setWorksStatus(-1); //默认状态-未审核（-1-未审核，0-未通过，1-通过）
        works.setUsersId(usersId);
        worksList.add(works);

        // 存储到数据库
        worksService.worksPublish(worksList);

    }

    /**
     * 查询全部作品
     * @return
     */
    @GetMapping("/findByWorksAll")
    public List<Works> findByWorksAll() {
        return worksService.findByWorksAll();
    }

    /**
     * 审核通过
     * @param worksId
     */
    @GetMapping("/auditPass/{worksId}")
    public void auditPass(@PathVariable("worksId") Integer worksId) {
        worksService.auditPassWorksByWorksId(worksId);
    }

    /**
     * 审核不通过
     * @param works
     */
    @PutMapping("/auditNotPass")
    public void auditNotPass(@RequestBody Works works) {
        worksService.auditNotPassWorksByWorksId(works.getWorksId());
    }

    /**
     * 根据作品id查询
     * @param worksId
     * @return
     */
    @GetMapping("/findByWorksId/{worksId}")
    public Works findByWorksId(@PathVariable("worksId") Integer worksId) {
        return worksService.findByWorksId(worksId);
    }

    /**
     * 根据作品条件查询内容
     * @param works
     * @return
     */
    @PutMapping("/findByWorksOption")
    public List<Works> findByWorksOption(@RequestBody Works works) {
        return worksService.findByWorksOption(works);
    }

    /**
     * 编辑作品
     * @param works
     */
    @PutMapping("/editWorks")
    public void editWorks(@RequestBody Works works) {
        worksService.updateWorks(works);
    }

    /**
     * 根据用户ID查询用户作品总条数
     * @param usersId
     * @return
     */
    @GetMapping("/findWorksCountByUsersId/{usersId}")
    public Integer findWorksCountByUsersId(@PathVariable("usersId") Integer usersId) {
        return worksService.findWorksCountByUsersId(usersId);
    }

    /**
     * 根据用户ID查询作品
     * @param usersId
     * @return
     */
    @GetMapping("/findByUsersId/{usersId}")
    public List<Works> findByUsersId(@PathVariable("usersId") Integer usersId) {
        return worksService.findByUsersId(usersId);
    }

    /**
     * 查询审核通过的全部用户作品
     * @return
     */
    @GetMapping("/findAuditPassAllByUsers")
    public List<WorksVo> findAuditPassAllByUsers() {
        return worksService.findAuditPassAllByUsers();
    }

    /**
     * 更新作品浏览量
     * @param worksId
     */
    @GetMapping("/updateWatchNumById/{worksId}")
    public void updateWatchNumById(@PathVariable("worksId") Integer worksId) {
        worksService.updateWorksWatchNum(worksId);
    }

    /**
     * 查询浏览量大于1的内容
     * @return
     */
    @GetMapping("/findByWatchNumBiggerOne")
    public List<Works> findByWatchNumBiggerOne() {
        return worksService.findByWatchNumBiggerOne();
    }


}
