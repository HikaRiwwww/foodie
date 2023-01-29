package com.throne.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.throne.pojo.Carousel;

import java.util.List;

/**
 * @author: daimian
 * @date: 2023/1/5
 */
public interface CarouselService extends IService<Carousel> {
    List<Carousel> queryAll(Integer isShow);
}
