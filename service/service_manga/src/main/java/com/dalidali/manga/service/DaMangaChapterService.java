package com.dalidali.manga.service;

import com.dalidali.manga.entity.DaMangaChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dalidali.manga.entity.vo.MangaChapterVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qinda
 * @since 2020-08-26
 */
public interface DaMangaChapterService extends IService<DaMangaChapter> {
    List<MangaChapterVo> getChaptersByMangaId(String mangaId);
}
