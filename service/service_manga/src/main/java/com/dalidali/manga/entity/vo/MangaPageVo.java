package com.dalidali.manga.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: manga
 * @description:
 * @author: qinda
 * @create: 2020-09-04 13:39
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MangaPageVo {
    @ApiModelProperty(value = "页id")
    private Long id;

    @ApiModelProperty(value = "漫画id")
    private String mangaId;

    @ApiModelProperty(value = "漫画章节id")
    private String chapterId;

    @ApiModelProperty(value = "页名")
    private String title;

    @ApiModelProperty(value = "页数")
    private Integer pageNum;

    @ApiModelProperty(value = "图片路径")
    private String contentPath;
}
