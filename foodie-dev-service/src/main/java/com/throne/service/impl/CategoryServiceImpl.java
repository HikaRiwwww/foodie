package com.throne.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.throne.pojo.vo.CategoryVO;
import com.throne.service.CategoryService;
import com.throne.mapper.CategoryMapper;
import com.throne.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryRootCategory() {
        return categoryMapper.queryRootCategory();
    }

    @Override
    public List<CategoryVO> querySubCategory(Integer rootCatId) {
        return categoryMapper.querySubCategory(rootCatId);
    }


}
