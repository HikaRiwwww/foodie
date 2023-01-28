package com.throne.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.throne.service.ItemsParamService;
import com.throne.mapper.ItemsParamMapper;
import com.throne.pojo.ItemsParam;
import org.springframework.stereotype.Service;

@Service
public class ItemsParamServiceImpl extends ServiceImpl<ItemsParamMapper, ItemsParam> implements ItemsParamService {
}
