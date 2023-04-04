package com.zcb.dao;

import com.zcb.pojo.People;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleMapper {
    void addPeople(People people);
    boolean deletePeople(int id);
    //List<People> queryAllPeople();
}
