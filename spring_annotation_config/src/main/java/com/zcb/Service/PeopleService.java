package com.zcb.Service;

import com.zcb.pojo.People;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface PeopleService {
    void addAndDeletePeople(People addPeople,int deleteId);
}
