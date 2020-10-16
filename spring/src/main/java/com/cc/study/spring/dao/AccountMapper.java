package com.cc.study.spring.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountMapper {

    @Select("select * from account")
    List<Account> query();

}
