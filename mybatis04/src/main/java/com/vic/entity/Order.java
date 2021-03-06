package com.vic.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 订单
 * @author Victor
 * date: 2020/4/10 16:15
 */
@Data
public class Order implements Serializable {

    private Long id;

    // 商品名称
    private String goodsName;

    // 商品数量
    private Integer quantity;

    // 用户id
    private Long userId;

    // 删除 1正常 2删除
    private Integer deleteFlag;

    // 所属用户
    private User user;

    public Order() {
    }

    public Order(Long id, String goodsName) {
        this.id = id;
        this.goodsName = goodsName;
//        System.out.println("id: " + id + ", goodsName: " + goodsName);
    }

}
