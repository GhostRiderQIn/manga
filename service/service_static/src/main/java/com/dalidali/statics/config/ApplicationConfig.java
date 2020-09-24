package com.dalidali.statics.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApplicationConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 轮播图
        registry.addResourceHandler("/mangabanner/**")
                .addResourceLocations("file:"+RootPath.MANGA_BANNER_ROOT);

        // 漫画页
        registry.addResourceHandler("/page/**")
                .addResourceLocations("file:"+RootPath.MANGA_PAGE_ROOT);

        // 漫画主页的小封面
        registry.addResourceHandler("/mangacover/**")
                .addResourceLocations("file:"+RootPath.MANGA_COVER_ROOT);

    }
}
