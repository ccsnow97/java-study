package com.cc.study.spring.entity;

import org.springframework.stereotype.Service;

/**
 * @Date: 2020/07/24 15:21
 */
//@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public String getName() {
        return "StudentServiceImpl";
    }
}
