package com.zcb.aop;
/*也可以自定以通知(增强方法)*/
public class DiyAdvice {
    public void before(){
        System.out.println("我想在方法执行前做点事情");
    }
    public void after(){
        System.out.println("我想在方法执行后做点事情");
    }
}
