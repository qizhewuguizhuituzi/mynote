package com.zcb.dao;

import com.zcb.pojo.People;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;
/*除了这种将SqlSessionTemplate注入到mapper实现类中的方法还用另外一种方法*/
public class PeopleMapperImpl implements PeopleMapper{
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public int addPeople(People people) {
        return sqlSession.getMapper(PeopleMapper.class).addPeople(people);
    }

    @Override
    public boolean deletePeople(int peopleId) {
        return sqlSession.getMapper(PeopleMapper.class).deletePeople(peopleId);
    }

    @Override
    public List<People> queryAllPeople() {
        return sqlSession.getMapper(PeopleMapper.class).queryAllPeople();
    }
}
