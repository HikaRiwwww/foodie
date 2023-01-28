package com.throne.controller;

import com.throne.CarouselService;
import com.throne.pojo.Carousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
public class HelloController {
    @Autowired
    private CarouselService carouselService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }

    @GetMapping("/carousel/{id}")
    public Carousel stu(@PathVariable String id){
        return carouselService.getById(id);
    }

}
