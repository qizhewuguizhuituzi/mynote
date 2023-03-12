package com.zcb.controller;

import com.zcb.dao.PeopleMapperImpl;
import com.zcb.pojo.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*事务配置好了之后测试事务*/
public class TestTransaction {
    @Test
    public void testTransaction(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        PeopleController peopleController = app.getBean("peopleController", PeopleController.class);
        System.out.println(peopleController);
        People people = new People();
        people.setName("事务");
        people.setAge(99);
        int deleteId = 27;
        peopleController.addPeopleAndDeletePeople(people,deleteId);
    }
}
