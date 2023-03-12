package com.zcb.pojo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
    private String name;
    private int age;
    private List<String> hobby;
    private Map<String,String> result;
    private Set<String> friends;
    private Address address;

    /*public Student(String name, int age, List<String> hobby, Map<String, String> result, Set<String> friends, Address address) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
        this.result = result;
        this.friends = friends;
        this.address = address;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    public Map<String, String> getResult() {
        return result;
    }

    public void setResult(Map<String, String> result) {
        this.result = result;
    }

    public Set<String> getFriends() {
        return friends;
    }

    public void setFriends(Set<String> friends) {
        this.friends = friends;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobby=" + hobby +
                ", result=" + result +
                ", friends=" + friends +
                ", address=" + address +
                '}';
    }
}
