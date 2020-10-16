package com.cc.study.spring.entity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Date: 2020/07/24 15:21
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String getName() {
        return "我是实现";
    }
}
