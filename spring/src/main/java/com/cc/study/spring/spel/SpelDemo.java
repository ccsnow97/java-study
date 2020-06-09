package com.cc.study.spring.spel;

import lombok.AllArgsConstructor;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.TypeConverter;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @Date: 2020/06/09 10:06
 */
public class SpelDemo {

    public static void main(String[] args) {
        Student tom = new Student(22, "tom");
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("false");
        StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext();
        standardEvaluationContext.setTypeConverter(new MyConvertor());
        Object value =  expression.getValue(standardEvaluationContext,Integer.class);
    }

    @AllArgsConstructor
    static class Student{
        public int age;
        public String name;
    }

    static class MyConvertor implements TypeConverter{

        @Override
        public boolean canConvert(TypeDescriptor sourceType, TypeDescriptor targetType) {
            if(sourceType.getType()==Boolean.class&&targetType.getType()==Integer.class){
                return true;
            }
            return false;
        }

        @Override
        public Object convertValue(Object value, TypeDescriptor sourceType, TypeDescriptor targetType) {
            if(sourceType.getType()==Boolean.class){
                Boolean aBoolean = (Boolean) value;
                return aBoolean?1:0;
            }
            return null;
        }
    }

}
