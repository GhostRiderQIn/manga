package com.dalidali.manga;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @program: manga
 * @description:
 * @author: qinda
 * @create: 2020-08-26 18:35
 **/

@SpringBootApplication
@MapperScan("com.dalidali.manga.mapper")
@ComponentScan(basePackages = {"com.dalidali"})
public class MangaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MangaApplication.class,args);
    }

}
