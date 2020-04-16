package com.vic.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户
 * @author Victor
 */
//@Alias("myUser")
@Data
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 7746297563607997685L;

    // id
    private Long id;
    // 姓名
    private String name;
    // 年龄
    private Integer age;
    // 出生日期
    private Date birthday;
    // 地址
    private String address;
    // 删除 1正常 2删除
    private Integer deleteFlag;

    // 用户订单列表
    private List<Order> orders;

    public User(String name, Integer age, Date birthday, String address) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.address = address;
    }
}
