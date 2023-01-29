package com.throne.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.throne.mapper.CategoryMapper;
import com.throne.service.CarouselService;
import com.throne.mapper.CarouselMapper;
import com.throne.pojo.Carousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarouselServiceImpl extends ServiceImpl<CarouselMapper, Carousel> implements CarouselService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Carousel> queryAll(Integer isShow) {
        return categoryMapper.queryAll(isShow);
    }
}
