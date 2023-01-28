package com.throne.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.throne.service.ItemService;
import com.throne.mapper.ItemsMapper;
import com.throne.pojo.Items;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends ServiceImpl<ItemsMapper, Items> implements ItemService {
}
