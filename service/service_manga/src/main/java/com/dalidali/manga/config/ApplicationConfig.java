package com.dalidali.manga.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * @program: manga
 * @description:
 * @author: qinda
 * @create: 2020-08-29 23:33
 **/
@Configuration
public class ApplicationConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // 漫画虚拟路径
        registry.addResourceHandler("/page/**").addResourceLocations("file:"+RootPath.MANGA_ROOT_PATH);

        registry.addResourceHandler("/mangacover/**").addResourceLocations("file:"+RootPath.MANGA_COVER_ROOT_PATH);
    }



}
