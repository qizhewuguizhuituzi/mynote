package com.zcb.pojo.dao;

import com.zcb.dao.PeopleMapperImpl;
import com.zcb.dao.PeopleMapperImpl2;
import com.zcb.pojo.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PeopleMapperImpl2Test {
    @Test
    public void testPeopleMapperImpl2(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        PeopleMapperImpl2 peopleMapper = app.getBean("peopleDao", PeopleMapperImpl2.class);
        People people = new People();
        people.setName("垃圾");
        people.setAge(22);
        peopleMapper.addPeople(people);
        System.out.println(people);
        boolean b = peopleMapper.deletePeople(34);
        System.out.println(b);
        List<People> people1 = peopleMapper.queryAllPeople();
        System.out.println(people1);
    }
}
