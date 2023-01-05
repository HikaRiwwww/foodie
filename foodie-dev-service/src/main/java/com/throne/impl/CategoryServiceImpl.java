package com.throne.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.throne.CategoryService;
import com.throne.mapper.CategoryMapper;
import com.throne.pojo.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}
