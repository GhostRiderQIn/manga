package com.dalidali.manga.controller;


import com.dalidali.manga.entity.DaMangaDetail;
import com.dalidali.manga.service.DaMangaDetailService;
import com.dalidali.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qinda
 * @since 2020-08-26
 */
@RestController
@RequestMapping("/manga/detail")
public class DaMangaDetailController {
    @Autowired
    private DaMangaDetailService detailService;

    @GetMapping("/getDetailByMangaId/{id}")
    public Result getDetailByMangaId(@PathVariable("id") String id){
        DaMangaDetail manga = detailService.getById(id);
        return Result.ok().data("manga",manga);
    }
}

