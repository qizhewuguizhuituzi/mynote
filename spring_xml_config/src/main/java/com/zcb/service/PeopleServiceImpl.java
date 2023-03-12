package com.zcb.service;

import com.zcb.dao.PeopleMapperImpl;
import com.zcb.pojo.People;

public class PeopleServiceImpl implements PeopleService {
    private PeopleMapperImpl peopleMapper;

    public void setPeopleMapper(PeopleMapperImpl peopleMapper) {
        this.peopleMapper = peopleMapper;
    }

    @Override
    public void addPeopleAndDeletePeople(People addPeople, int deletePeopleId) {
        System.out.println("添加"+addPeople);
        peopleMapper.addPeople(addPeople);
        System.out.println("看addPeople是否添加成功"+addPeople);
        System.out.println("让代码故意出错");
        System.out.println("删除的peopleId为"+deletePeopleId);
        int i = 100 / 0;
        boolean b = peopleMapper.deletePeople(deletePeopleId);
        if(b){
            System.out.println("删除成功");
        }
    }
}
