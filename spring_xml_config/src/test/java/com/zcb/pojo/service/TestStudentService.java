package com.zcb.pojo.service;

import com.zcb.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudentService {
    @Test
    public void testStudentService(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService service = app.getBean("studentService", StudentService.class);
        service.addStudent();
        service.deleteStudent();
        service.queryStudent();
        service.updateStudent();
    }

}
