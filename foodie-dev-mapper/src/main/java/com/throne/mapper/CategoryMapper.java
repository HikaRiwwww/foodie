package com.throne.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.throne.pojo.Carousel;
import com.throne.pojo.Category;
import com.throne.pojo.vo.CategoryVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper extends BaseMapper<Category> {
    List<Carousel> queryAll (@Param("is_show") Integer isShow);

    List<Category> queryRootCategory();

    List<CategoryVO> querySubCategory(@Param("rootCatId") Integer rootCatId);
}