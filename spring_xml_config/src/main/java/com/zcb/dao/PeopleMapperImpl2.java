package com.zcb.dao;

import com.zcb.pojo.People;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class PeopleMapperImpl2 extends SqlSessionDaoSupport implements PeopleMapper {
    @Override
    public int addPeople(People people) {
        return getSqlSession().getMapper(PeopleMapper.class).addPeople(people);
    }

    @Override
    public boolean deletePeople(int peopleId) {
        return getSqlSession().getMapper(PeopleMapper.class).deletePeople(peopleId);
    }

    @Override
    public List<People> queryAllPeople() {
        return getSqlSession().getMapper(PeopleMapper.class).queryAllPeople();
    }
}
