package com.throne.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.throne.pojo.Carousel;
import com.throne.pojo.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper extends BaseMapper<Category> {
    List<Carousel> queryAll (@Param("is_show") Integer isShow);
}