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

	Order queryById1(Long id);

	Order queryById2(Long id);

	Order queryById3(Long id);
}
