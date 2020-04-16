package com.vic.mapper;

import com.vic.entity.Order;


/**
 * 订单dao
 * @author Victor
 */
public interface OrderMapper {

	Order queryById(Long id);
	
	int insert(Order order);

	int insertAndGetId1(Order order);

}
