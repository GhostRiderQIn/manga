package com.dalidali.manga.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dalidali.manga.entity.DaMangaChapter;
import com.dalidali.manga.entity.vo.MangaChapterVo;
import com.dalidali.manga.service.DaMangaChapterService;
import com.dalidali.utils.ImageUtils;
import com.dalidali.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qinda
 * @since 2020-08-26
 */
@RestController
@RequestMapping("/manga/chapter")
@CrossOrigin
public class DaMangaChapterController {

    @Autowired
    private DaMangaChapterService chapterService;

    @RequestMapping("/get/{mangaId}")
    public Result getChaptersByMangaId(@PathVariable String mangaId){
        List<MangaChapterVo> res = chapterService.getChaptersByMangaId(mangaId);
        return Result.ok().data("chapters",res);
    }

    @RequestMapping("/test")
    public void a() throws Exception {
        throw new Exception();
    }
}

