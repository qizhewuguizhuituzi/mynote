package com.zcb.service;

public class StudentServiceImpl implements StudentService{
    @Override
    public void addStudent() {
        System.out.println("添加了一个学生");
    }

    @Override
    public void deleteStudent() {
        System.out.println("删除一个学生");
    }

    @Override
    public void queryStudent() {
        System.out.println("查询学生");
    }

    @Override
    public void updateStudent() {
        System.out.println("更新学生");
    }
}
