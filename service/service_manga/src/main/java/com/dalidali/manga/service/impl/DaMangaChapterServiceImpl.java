package com.dalidali.manga.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dalidali.manga.entity.DaMangaChapter;
import com.dalidali.manga.entity.vo.MangaChapterVo;
import com.dalidali.manga.mapper.DaMangaChapterMapper;
import com.dalidali.manga.service.DaMangaChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qinda
 * @since 2020-08-26
 */
@Service
public class DaMangaChapterServiceImpl extends ServiceImpl<DaMangaChapterMapper, DaMangaChapter> implements DaMangaChapterService {

    @Override
    public List<MangaChapterVo> getChaptersByMangaId(String mangaId) {
        QueryWrapper<DaMangaChapter> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("manga_id",mangaId);
        List<DaMangaChapter> res = this.list(queryWrapper);
        List<MangaChapterVo> returnRes = new LinkedList<>();
        for(DaMangaChapter chapter : res){
            MangaChapterVo chapterVo = new MangaChapterVo();
            BeanUtils.copyProperties(chapter,chapterVo);
            returnRes.add(chapterVo);
        }

        return returnRes;
    }
}
