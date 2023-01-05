package com.throne.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.throne.ItemsSpecService;
import com.throne.mapper.ItemsSpecMapper;
import com.throne.pojo.ItemsSpec;
import org.springframework.stereotype.Service;

@Service
public class ItemsSpecServiceImpl extends ServiceImpl<ItemsSpecMapper, ItemsSpec> implements ItemsSpecService {
}
