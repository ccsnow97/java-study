package com.cc.study.spring.dao;

import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MyInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String sql = method.getAnnotation(Select.class).value()[0];
        System.out.println(sql);
        Connection connection = DriverManager.getConnection("jdbc:postgresql://10.202.42.78:5000/test"
                , "admin", "postgres");
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString(1) + "--------" + rs.getString(2));
        }
        return null;
    }
}
