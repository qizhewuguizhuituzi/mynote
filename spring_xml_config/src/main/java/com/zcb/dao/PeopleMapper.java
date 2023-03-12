package com.zcb.dao;

import com.zcb.pojo.People;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PeopleMapper {
     int addPeople(People people);
     boolean deletePeople(@Param("id") int peopleId);
     List<People> queryAllPeople();
}
