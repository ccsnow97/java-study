package com.cc.study.spring.entity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Date: 2020/07/23 11:38
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class StudentServiceTrans implements StudentService{

    @Override
    public String getName() {
        return "StudentServiceTrans";
    }
}
