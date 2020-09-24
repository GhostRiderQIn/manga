package com.dalidali.banner.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dalidali.banner.entity.DaMangaBanner;
import com.dalidali.banner.service.DaMangaBannerService;
import com.dalidali.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qinda
 * @since 2020-09-23
 */
@RestController
@RequestMapping("/banner")
@CrossOrigin
public class DaMangaBannerController {

    @Autowired
    private DaMangaBannerService bannerService;

    @GetMapping("/getBannerList/{num}")
    public Result getBannerList(@PathVariable int num){
        if(num < 0){
            return Result.error().message("请求参数错误");
        }
        if(num > 5){
            return Result.error().message("请求的轮播图不得超过5个");
        }
        QueryWrapper<DaMangaBanner> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("sort");
        wrapper.last("limit 0,"+num);
        List<DaMangaBanner> list = bannerService.list(wrapper);

        return Result.ok().data("banners",list);
    }
}

