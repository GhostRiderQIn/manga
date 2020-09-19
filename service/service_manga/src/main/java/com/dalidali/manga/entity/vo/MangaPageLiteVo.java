package com.dalidali.manga.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: manga
 * @description: 数据量更少的page传输层
 * @author: qinda
 * @create: 2020-09-04 13:53
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MangaPageLiteVo {
    @ApiModelProperty(value = "页数")
    private Integer pageNum;

    @ApiModelProperty(value = "图片路径")
    private String contentPath;
}
