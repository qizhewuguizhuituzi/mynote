package com.zcb.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
/*日志后置通知 还有异常通知,环绕通知很少用这里就不展示了*/
public class LogAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println(method.getName()+"方法执行完毕");
    }
}
