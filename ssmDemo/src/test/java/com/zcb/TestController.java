package com.zcb;

import com.zcb.controller.BookController;
import com.zcb.pojo.Books;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestController {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        BookController bookController = context.getBean("bookController", BookController.class);
        System.out.println(bookController);
        //List<Books> test = bookController.test();
        //System.out.println(test);
    }
}
