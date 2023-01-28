package com.throne.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.throne.service.ItemCommentsService;
import com.throne.mapper.ItemsCommentsMapper;
import com.throne.pojo.ItemsComments;
import org.springframework.stereotype.Service;

@Service
public class ItemCommentsServiceImpl extends ServiceImpl<ItemsCommentsMapper, ItemsComments> implements ItemCommentsService {
}
