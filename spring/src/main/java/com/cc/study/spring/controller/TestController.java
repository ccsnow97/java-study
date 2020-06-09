package com.cc.study.spring.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2020/06/09 11:16
 */
@RestController
@RequestMapping("test")
public class TestController {

    @PostMapping("fish")
    public Fish getFish(@RequestBody Fish fish){
        fish.age+=100;
        fish.name+=" ,处理了";
        return fish;
    }


    @AllArgsConstructor
    @Data
    static class Fish{
        Integer age;
        String name;
    }

}
