package com.throne.controller;
import com.throne.common.enums.YesOrNo;
import com.throne.common.utils.CommonResp;
import com.throne.pojo.Carousel;
import com.throne.pojo.Category;
import com.throne.pojo.vo.CategoryVO;
import com.throne.service.CarouselService;
import com.throne.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "首页", tags = {"首页展示相关接口"})
@RestController
@RequestMapping("index")
public class IndexController {
    @Autowired
    private CarouselService carouselService;
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "首页轮播图列表", httpMethod = "GET")
    @GetMapping("/carousel")
    public CommonResp carousel(){
        List<Carousel> carousels = carouselService.queryAll(YesOrNo.YES.type);
        return CommonResp.ok(carousels);
    }

    @ApiOperation(value = "获取一级商品分类", httpMethod = "GET")
    @GetMapping("/cats")
    public CommonResp categories(){
        List<Category> categories = categoryService.queryRootCategory();
        return CommonResp.ok(categories);
    }

    @ApiOperation(value = "获取商品子分类", httpMethod = "GET")
    @GetMapping("/subCat/{rootCatId}")
    public CommonResp categories(@PathVariable Integer rootCatId){
        List<CategoryVO> categoryVOList = categoryService.querySubCategory(rootCatId);
        return CommonResp.ok(categoryVOList);
    }
}
