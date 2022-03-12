package com.tl.photo.controller;

import com.tl.photo.domain.Carousel;
import com.tl.photo.service.CarouselService;
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
 * @Date 2021/11/4 12:54 上午
 * @Version 1.0
 */
@RestController
@RequestMapping("/carousel")
public class CarouselController {

    @Autowired
    private CarouselService carouselService;

    // 轮播图上传
    @RequestMapping("/upload")
    public void carouselUpload(@RequestParam("files") MultipartFile[] files, @RequestParam("title") String title, @RequestParam("status") Integer status){
        System.out.print("******************************上传文件******************************\n");

        // 存储绝对路径
        String path = "";
        // 存储图片名称
        String imgName = "";
        // 图片url
        String url = "";
        for (MultipartFile file : files) {
            // 获取文件名
            String fileName = file.getOriginalFilename();
            // 生成 1 到 99 之间随机数+文件名
            fileName = (int) (Math.random() * 99) + 1 +"_"+ fileName;
//            fileName = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(new Date()) + "_" + fileName;
            System.out.print("（加个随机数，尽量避免文件名称重复）保存的文件名为: " + fileName + "\n");
            // 存储图片名称
            imgName += fileName+",";
            System.out.println("图片名称："+imgName);

            // 存储图片绝对路径
            String imgPath = "/Users/tl/fileUpload/photos/" + fileName;
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
                url += "http://localhost:8089/photos/" + fileName+",";//本地运行项目
                //url="http://119.29.5.184:8089/photos/"+fileName;//运行项目

                System.out.print("保存的完整url：" + url + "\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 创建当前时间
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        List<Carousel> carouselList = new ArrayList<>();
        // trim() 去除开头和结尾的空格
        Carousel carousel = new Carousel();
        carousel.setCarouselTitle(title.trim());
        carousel.setCarouselPath(path.trim());
        carousel.setCarouselUrl(url.trim());
        carousel.setCarouselUploadTime(date);
        carousel.setCarouselStatus(status);
        carouselList.add(carousel);

        //保存到数据库
        carouselService.addCarousel(carouselList);

    }

    /*查询全部*/
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Carousel> findAll(){
        return carouselService.findAll();
    }

    /*根据轮播图 id 查询*/
    @GetMapping("/findByCarouselId/{id}")
    public Carousel findByCarouselId(@PathVariable("id") Integer id){
        return carouselService.findByCarouselId(id);
    }

    /*查询状态是否有不同的值*/
    @RequestMapping("/findByStatusDistinct")
    @ResponseBody
    public List<Carousel> findByCarouselStatusDistinct(){
        List<Carousel> carouselStatusDistinct = carouselService.findByCarouselStatusDistinct();
        System.out.println(carouselStatusDistinct);
        return carouselStatusDistinct;
    }

    /**
     * 开启启用状态
     * @param carousel
     */
    @PutMapping("/openStatusByCarouselId")
    public void openStatusByCarouselId(@RequestBody Carousel carousel) {
        carouselService.openStatusByCarouselId(carousel.getCarouselId());
    }

    /**
     * 关闭启用状态
     * @param carousel
     */
    @PutMapping("/closeStatusByCarouselId")
    public void closeStatusByCarouselId(@RequestBody Carousel carousel) {
        carouselService.closeStatusByCarouselId(carousel.getCarouselId());
    }

    /**
     * 根据轮播图标题查询内容
     * @param carouselTitle
     * @return
     */
    @GetMapping("/findByCarouselTitle/{carouselTitle}")
    public List<Carousel> findByCarouselTitle(@PathVariable("carouselTitle") String carouselTitle) {
        return carouselService.findByCarouselTitle(carouselTitle);
    }

    /**
     * 查询启用状态的轮播图
     * @return
     */
    @GetMapping("/findByOpenStatus")
    public Carousel findByOpenStatus() {
        return carouselService.findByOpenStatus();
    }

}
