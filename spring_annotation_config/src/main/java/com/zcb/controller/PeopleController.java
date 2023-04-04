package com.zcb.controller;

import com.zcb.Service.PeopleService;
import com.zcb.Service.PeopleServiceImpl;
import com.zcb.pojo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PeopleController {
    @Autowired
    private PeopleService peopleService;

    public void addAndDeletePeople(){
        People people = new People();
        people.setName("annotation");
        people.setAge(66);
        int deleteId = 43;
        peopleService.addAndDeletePeople(people,deleteId);
    }
}
