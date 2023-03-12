package com.zcb.pojo.dao;

import com.zcb.dao.PeopleMapper;
import com.zcb.pojo.People;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PeoPleMapperTest {
    public SqlSession getSqlSession() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        return sqlSession;
    }

    @Test
    public void TestPeopleMapperAdd() throws IOException {
        People people = new People();
        people.setName("张三");
        people.setAge(18);
        People people1 = new People();
        people1.setName("李四");
        people1.setAge(20);
        People people2 = new People();
        people2.setName("王五");
        people2.setAge(21);
        SqlSession sqlSession = getSqlSession();
        PeopleMapper mapper = sqlSession.getMapper(PeopleMapper.class);
        mapper.addPeople(people);
        mapper.addPeople(people1);
        mapper.addPeople(people2);
        sqlSession.close();
        System.out.println(people);
        System.out.println(people1);
        System.out.println(people2);
    }

    @After
    public void TestPeopleMapperSelect() throws IOException {
        SqlSession sqlSession = getSqlSession();
        PeopleMapper mapper = sqlSession.getMapper(PeopleMapper.class);
        List<People> peoples = mapper.queryAllPeople();
        sqlSession.close();
        System.out.println(peoples);
    }
}
