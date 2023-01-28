package com.throne.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.throne.service.CategoryService;
import com.throne.mapper.CategoryMapper;
import com.throne.pojo.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}
