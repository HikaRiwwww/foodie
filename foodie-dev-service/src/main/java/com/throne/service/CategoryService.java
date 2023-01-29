package com.throne.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.throne.pojo.Category;
import com.throne.pojo.vo.CategoryVO;

import java.util.List;


public interface CategoryService extends IService<Category> {
    List<Category> queryRootCategory();

    List<CategoryVO> querySubCategory(Integer rootCatId);
}
