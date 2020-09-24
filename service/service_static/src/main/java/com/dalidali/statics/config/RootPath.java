package com.dalidali.statics.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: manga
 * @description:
 * @author: qinda
 * @create: 2020-08-28 21:34
 **/
@Component
public class RootPath implements InitializingBean {

    // 漫画页物理路径
    @Value("${manga.page.root}")
    // --> RootPath:/xxx/yyy/zzz <--  mysql: /manganame/chapter/page
    private String mangaPageRoot;
    public static String MANGA_PAGE_ROOT;
    // 虚拟路径
    @Value("${manga.page.virtual}")
    private String mangaPageVirtual;
    public static String MANGA_PAGE_VIRTUAL;



    // 漫画小封面物理路径
    @Value("${manga.cover.root}")
    private String mangaCoverRoot;
    public static String MANGA_COVER_ROOT;
    // 虚拟路径
    @Value("${manga.cover.virtual}")
    private String mangaCoverVirtual;
    public static String MANGA_COVER_VIRTUAL;



    // 漫画轮播图物理路径
    @Value("${manga.banner.root}")
    private String mangaBannerRoot;
    public static String MANGA_BANNER_ROOT;
    @Value("${manga.banner.virtual}")
    private String mangaBannerVirtual;
    public static String MANGA_BANNER_VIRTUAL;



    @Override
    public void afterPropertiesSet() {
        MANGA_PAGE_ROOT = this.mangaPageRoot;
        MANGA_COVER_ROOT = this.mangaCoverRoot;
        MANGA_BANNER_ROOT = this.mangaBannerRoot;

        MANGA_BANNER_VIRTUAL = this.mangaBannerVirtual;
        MANGA_COVER_VIRTUAL = this.mangaCoverVirtual;
        MANGA_PAGE_VIRTUAL = this.mangaPageVirtual;
    }
}
