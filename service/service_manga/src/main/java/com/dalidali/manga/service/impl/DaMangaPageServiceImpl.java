package com.dalidali.manga.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dalidali.manga.entity.DaMangaChapter;
import com.dalidali.manga.entity.DaMangaPage;
import com.dalidali.manga.entity.vo.MangaPageLiteVo;
import com.dalidali.manga.entity.vo.MangaPageVo;
import com.dalidali.manga.mapper.DaMangaPageMapper;
import com.dalidali.manga.service.DaMangaPageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class DaMangaPageServiceImpl extends ServiceImpl<DaMangaPageMapper, DaMangaPage> implements DaMangaPageService {

    @Override
    public List<MangaPageVo> getPagesByChapterId(String chapterId) {
        QueryWrapper<DaMangaPage> wrapper = new QueryWrapper<>();
        wrapper.eq("chapter_id",chapterId);
        wrapper.orderByAsc("page_num");
        List<DaMangaPage> res = this.list(wrapper);
        List<MangaPageVo> returnRes = new ArrayList<>();
        for(DaMangaPage page : res){
            MangaPageVo vo = new MangaPageVo();
            BeanUtils.copyProperties(page,vo);
            returnRes.add(vo);
        }
        return returnRes;
    }

    @Override
    public List<MangaPageLiteVo> getLitePagesByChapterId(String chapterId) {
        QueryWrapper<DaMangaPage> wrapper = new QueryWrapper<>();
        wrapper.select("page_num","content_path");
        wrapper.eq("chapter_id",chapterId);
        wrapper.orderByAsc("page_num");
        List<DaMangaPage> res = this.list(wrapper);
        List<MangaPageLiteVo> returnRes = new ArrayList<>();
        for(DaMangaPage page : res){
            MangaPageLiteVo vo = new MangaPageLiteVo();
            BeanUtils.copyProperties(page,vo);
            returnRes.add(vo);
        }
        return returnRes;
    }
}
