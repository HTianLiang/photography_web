package com.tl.photo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 开启 Mapper 接口扫描
@MapperScan("com.tl.photo.mapper")
public class PhotographyWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotographyWebApplication.class, args);
	}

}
