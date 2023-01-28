package com.throne.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.throne.service.CarouselService;
import com.throne.mapper.CarouselMapper;
import com.throne.pojo.Carousel;
import org.springframework.stereotype.Service;

@Service
public class CarouselServiceImpl extends ServiceImpl<CarouselMapper, Carousel> implements CarouselService {
}
