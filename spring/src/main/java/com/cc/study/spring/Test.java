package com.cc.study.spring;

import lombok.Data;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @Date: 2020/08/04 10:16
 */
public class Test {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        MyContext myContext = new MyContext();
        myContext.setName("tom");
        Parent parent = new Parent();
        parent.setName("tony");
        myContext.setParent(parent);
        StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext(myContext);
        Expression expression = parser.parseExpression("#{name}", new TemplateParserContext());
        String value = expression.getValue(standardEvaluationContext, String.class);
    }

    @Data
    static class MyContext {
        String name;
        Parent parent;
    }

    @Data
    static class Parent {
        String name;
    }

}
