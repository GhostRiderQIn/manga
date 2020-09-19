package com.dalidali.manga.mapper;

import com.dalidali.manga.entity.DaMangaPage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qinda
 * @since 2020-08-26
 */
@Repository
public interface DaMangaPageMapper extends BaseMapper<DaMangaPage> {
    void insertBatch(@Param("list") List<DaMangaPage> pageList);
}
