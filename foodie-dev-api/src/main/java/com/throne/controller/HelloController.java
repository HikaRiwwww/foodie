package com.throne.controller;

import com.throne.StuService;
import com.throne.pojo.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private StuService stuService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }

    @GetMapping("/stu/{id}")
    public Stu stu(@PathVariable Integer id){
        return stuService.getById(id);
    }

}
