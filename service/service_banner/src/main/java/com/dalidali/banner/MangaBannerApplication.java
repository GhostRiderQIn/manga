package com.dalidali.banner;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.dalidali.banner.mapper")
@ComponentScan(basePackages = {"com.dalidali"})
public class MangaBannerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MangaBannerApplication.class,args);
    }
}
