package com.throne.controller;
import com.throne.common.enums.YesOrNo;
import com.throne.common.utils.CommonResp;
import com.throne.pojo.Carousel;
import com.throne.service.CarouselService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "首页", tags = {"首页展示相关接口"})
@RestController
@RequestMapping("index")
public class IndexController {
    @Autowired
    private CarouselService carouselService;

    @ApiOperation(value = "首页轮播图列表", httpMethod = "GET")
    @GetMapping("/carousel")
    public CommonResp carousel(){
        List<Carousel> carousels = carouselService.queryAll(YesOrNo.YES.type);
        return CommonResp.ok(carousels);
    }
}
