package com.throne.com.throne.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.throne.StuService;
import com.throne.mapper.StuMapper;
import com.throne.pojo.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudServiceImpl extends ServiceImpl<StuMapper, Stu> implements StuService {
    @Autowired
    private StuMapper stuMapper;
}
