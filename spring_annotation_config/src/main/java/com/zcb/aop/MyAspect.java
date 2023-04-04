package com.zcb.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component("myAspect")
public class MyAspect {
    /*使用增强的注解*/
    /*使用注解实现切点*/
    @Pointcut("execution(* com.zcb.Service.PeopleServiceImpl.* (..))")
    public void pointcut(){

    }
    //前置增强,JoinPoint该参数可要可不要
    @Before("pointcut()")
    public void before(JoinPoint joinPoint){
        System.out.println("注解实现前置增强");
        /*System.out.println("增强类为:"+joinPoint.getTarget().getClass());
        System.out.println(joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getKind());
        System.out.println(joinPoint.getSignature());*/
    }
    //被增强的方法无论是否执行过程中出错都会执行该方法
    @After("pointcut()")
    public void after(JoinPoint joinPoint){
        System.out.println("注解实现后置增强");
    }
    //被增强的方法返回结果后执行该方法,该方法还可以获得执行方法的返回值
    @AfterReturning(pointcut = "pointcut()",returning = "rt")
    public void afterReturning(JoinPoint joinPoint,Object rt){
        System.out.println("注解实现返回值后增强");
        System.out.println(joinPoint);
        System.out.println(rt);
    }

    //使用 @AfterThrowing 注解，表示【被增强的方法】出错抛异常后，执行下面的代码
    //如果【被增强的方法】没有出错抛异常，将不会执行下面的代码
    //该注解修饰的方法，可以有一个 Throwable 参数，用于获取【被增强的方法】出错时的异常对象
    @AfterThrowing(pointcut = "pointcut()", throwing = "t")
    public void afterThrowing(Throwable t) {
        //通过参数，可以获取到异常对象，从而获取异常信息
        System.out.println("抛出异常后 afterThrowing 执行了，异常信息为：" + t.getMessage());
    }
}
