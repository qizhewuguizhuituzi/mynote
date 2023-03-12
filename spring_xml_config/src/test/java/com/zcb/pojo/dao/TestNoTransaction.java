package com.zcb.pojo.dao;

import com.zcb.dao.PeopleMapperImpl;
import com.zcb.pojo.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*如果没有添加事务会有什么情况发生*/
public class TestNoTransaction {
    @Test
    public void testNoTransaction() {
        //先删除数据库中的一条数据然后再添加一条数据
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        PeopleMapperImpl peopleMapper = app.getBean("peopleMapper", PeopleMapperImpl.class);
        boolean b = peopleMapper.deletePeople(36);
        System.out.println(b);
        int a = 100 / 0;
        People people = new People();
        people.setName("甲天下");
        people.setAge(100);
        peopleMapper.addPeople(people);
        System.out.println(people);
        /*这里面肯定会有一个问题在数据库中存在 就是删除成功过了但是因为删除后出错导致后面的没有添加成功 这就不符合原子性的操作会导致数据不一致 事务的重要性就体现出来了*/
    }
}
