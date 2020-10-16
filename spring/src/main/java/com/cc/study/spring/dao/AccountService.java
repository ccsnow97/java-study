package com.cc.study.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private InnerAccountService innerAccountService;

}
