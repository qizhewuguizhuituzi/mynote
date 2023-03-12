package com.zcb.pojo.dao;

import com.zcb.dao.PeopleMapperImpl;
import com.zcb.pojo.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PeopleMapperImplTest {
    /*测试spring整合mybatis后*/
    @Test
    public void testPeopleMapperImpl(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        PeopleMapperImpl peopleMapper = app.getBean("peopleMapper", PeopleMapperImpl.class);
        People people = new People();
        people.setName("垃圾");
        people.setAge(22);
        peopleMapper.addPeople(people);
        System.out.println(people);
        boolean b = peopleMapper.deletePeople(22);
        System.out.println(b);
        List<People> people1 = peopleMapper.queryAllPeople();
        System.out.println(people1);
    }
}
