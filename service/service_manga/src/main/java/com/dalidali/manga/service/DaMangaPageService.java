package com.dalidali.manga.service;

import com.dalidali.manga.entity.DaMangaPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dalidali.manga.entity.vo.MangaPageLiteVo;
import com.dalidali.manga.entity.vo.MangaPageVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qinda
 * @since 2020-08-26
 */
public interface DaMangaPageService extends IService<DaMangaPage> {
    List<MangaPageVo> getPagesByChapterId(String chapterId);

    List<MangaPageLiteVo> getLitePagesByChapterId(String chapterId);
}
