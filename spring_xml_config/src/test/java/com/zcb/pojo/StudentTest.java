package com.zcb.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {
    @Test
    public void testStudent() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = app.getBean("student", Student.class);
        System.out.println(student.toString());
    }
}
