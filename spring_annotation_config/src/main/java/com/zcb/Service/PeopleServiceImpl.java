package com.zcb.Service;

import com.zcb.dao.PeopleMapper;
import com.zcb.pojo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PeopleServiceImpl implements PeopleService{
    @Autowired
    private PeopleMapper peopleMapper;

    @Override
    //这里要注意使用事务失效,以及事务注解中的几个属性事务级别,事务的传播行为,遇到什么异常事务回滚,事务超时,甚至是事务
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout = 30)
    public void addAndDeletePeople(People addPeople, int deleteId) {
        System.out.println("1111111111111111");
        peopleMapper.addPeople(addPeople);
        System.out.println("添加的people的主键的id"+addPeople.getId());
        //如果该地方出现异常但是业务要求两次的数据库操作是原子性操作,那就应该引进事务
        int a = 1/0;
        boolean b = peopleMapper.deletePeople(deleteId);
        if(b){
            System.out.println("删除用户成功="+deleteId);
        }
    }
}
