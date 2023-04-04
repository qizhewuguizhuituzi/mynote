package com.zcb.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Setter
@Getter
public class People {
    private Integer id;
    private String name;
    private int age;
}
