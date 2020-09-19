package com.dalidali.manga.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 漫画
 * </p>
 *
 * @author qinda
 * @since 2020-08-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="DaMangaDetail对象", description="")
public class DaMangaDetail implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "漫画id")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "漫画名")
    private String title;

    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "漫画封面url或者path")
    private String cover;

    @ApiModelProperty(value = "漫画简介")
    private String intro;

    @ApiModelProperty(value = "漫画主页背景音乐")
    private String music;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "总话数")
    private Integer chapterNum;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "观看人数")
    private Long viewCount;

    @ApiModelProperty(value = "漫画发布日期")
    private Date releaseTime;

    @ApiModelProperty(value = "是否完结")
    private Boolean isFinished;

    @ApiModelProperty(value = "是否删除")
    @TableLogic
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
