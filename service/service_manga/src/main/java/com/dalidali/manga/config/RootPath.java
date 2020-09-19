package com.dalidali.manga.config;

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

    @Value("${manga.rootpath}")
    // --> RootPath:/xxx/yyy/zzz <--  mysql: /manganame/chapter/page
    private String mangaRootPath;
    public static String MANGA_ROOT_PATH;

    @Value("${manga.cover.rootpath}")
    private String mangaCoverRootPath;
    public static String MANGA_COVER_ROOT_PATH;

    @Override
    public void afterPropertiesSet() throws Exception {
        MANGA_ROOT_PATH = this.mangaRootPath;
        MANGA_COVER_ROOT_PATH = this.mangaCoverRootPath;

    }
}
