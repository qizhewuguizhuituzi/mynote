package com.zcb.controller;

import com.zcb.config.SpringConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PeopleControllerTest {
    @Test
    public void testPeopleControllerTest(){
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class);
        PeopleController peopleController = app.getBean("peopleController", PeopleController.class);
        peopleController.addAndDeletePeople();
    }
}
