package com.dalidali.banner.config;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RootPath implements InitializingBean {

    @Value("${manga.banner.root}")
    // --> RootPath:/xxx/yyy/zzz <--  mysql: /manganame/chapter/page
    private String mangaBannerRootPath;
    public static String MANGA_BANNER_ROOT_PATH;

    @Override
    public void afterPropertiesSet() throws Exception {
        MANGA_BANNER_ROOT_PATH = this.mangaBannerRootPath;
    }
}