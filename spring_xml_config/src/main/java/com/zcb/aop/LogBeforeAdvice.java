package com.zcb.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/*日志通知 通知要实现spring的通知接口就可以了*/
public class LogBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(method.getName()+"方法执行了");
    }
}
