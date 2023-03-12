package com.zcb.controller;

import com.zcb.pojo.People;
import com.zcb.service.PeopleServiceImpl;

public class PeopleController {
    private PeopleServiceImpl peopleService;

    public void setPeopleService(PeopleServiceImpl peopleService) {
        this.peopleService = peopleService;
    }

    public void addPeopleAndDeletePeople(People addPeople, int deletePeopleId){
        System.out.println(peopleService);
        peopleService.addPeopleAndDeletePeople(addPeople,deletePeopleId);
    }
}
