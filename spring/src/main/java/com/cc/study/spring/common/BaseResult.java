package com.cc.study.spring.common;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BaseResult<T> {

    T data;

    public static <T> BaseResult<T> success(T data) {
        return new BaseResult<>(data);
    }

}
