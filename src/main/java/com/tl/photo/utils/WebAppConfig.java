package com.tl.photo.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;

/*
 * 上传配置
 * @Author tl
 * @Date 2021/10/31 11:25 上午
 * @Version 1.0
*/

@Configuration
public class WebAppConfig implements WebMvcConfigurer {
    //图片放到/Users/tl/fileUpload/photos后，从磁盘读取的图片数据src将会变成photos/picturename.jpg的格式

    /*
     * 在配置文件中配置的文件保存路径
     */
    @Value("${cbs.imagesPath}")
    private String mImagesPath;

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 文件最大 KB,MB
        factory.setMaxFileSize(DataSize.parse("1024MB"));
        // 设置总上传数据大小
        factory.setMaxRequestSize(DataSize.parse("1024MB"));
        return factory.createMultipartConfig();
    }

    /**
     * 资源映射路径
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (mImagesPath.equals("") || mImagesPath.equals("${cbs.imagesPath}")){
            String imagesPath = WebAppConfig.class.getClassLoader().getResource("").getPath();
            System.out.print("1.上传配置类imagesPath=="+imagesPath+"\n");
            if(imagesPath.indexOf(".jar")>0){
                imagesPath = imagesPath.substring(0, imagesPath.indexOf(".jar"));
            }else if(imagesPath.indexOf("classes")>0){
                imagesPath = "file:"+imagesPath.substring(0, imagesPath.indexOf("classes"));
            }
            imagesPath = imagesPath.substring(0, imagesPath.lastIndexOf("/"))+"/photos/";
            mImagesPath = imagesPath;
        }
        System.out.print("imagesPath= "+mImagesPath+"\n");

        String os = System.getProperty("os.name");
        /**
         * 虚拟路径映射文件磁盘路径 读取磁盘文件 预览文件
         * 实现 WebMvcConfigurer 类，才能成功映射
         */
        if (os.toLowerCase().startsWith("win")) {
            //如果是Windows系统
            registry.addResourceHandler("/photos/**").
                    addResourceLocations("file:D:/fileUpload/");
        }else{
            //linux和mac系统
            registry.addResourceHandler("/photos/**").
                    addResourceLocations(mImagesPath+"/");
        }

        //registry.addResourceHandler("/photos/**").addResourceLocations(mImagesPath);

        System.out.print("2.上传配置类mImagesPath= "+mImagesPath+"\n");

       // super.addResourceHandlers(registry);
    }

}
