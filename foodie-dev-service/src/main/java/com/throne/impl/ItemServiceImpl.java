package com.throne.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.throne.ItemService;
import com.throne.mapper.ItemsMapper;
import com.throne.pojo.Items;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends ServiceImpl<ItemsMapper, Items> implements ItemService {
}
