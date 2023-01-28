package com.throne.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.throne.service.ItemsImgService;
import com.throne.mapper.ItemsImgMapper;
import com.throne.pojo.ItemsImg;
import org.springframework.stereotype.Service;

@Service
public class ItemsImgServiceImpl extends ServiceImpl<ItemsImgMapper, ItemsImg> implements ItemsImgService {
}
