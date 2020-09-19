package com.dalidali.manga.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: manga
 * @description: 传输类，用于页面显示章节
 * @author: qinda
 * @create: 2020-09-04 12:59
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MangaChapterVo {

    @ApiModelProperty(value = "章节id")
    private String id;

    @ApiModelProperty(value = "章节名")
    private String title;

    @ApiModelProperty(value = "漫画id")
    private String mangaId;

    @ApiModelProperty(value = "章节封面")
    private String cover;
}
