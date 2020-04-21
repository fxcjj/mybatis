package com.vic;


import com.vic.entity.Order;
import com.vic.mapper.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;


/**
 * user模块测试
 * @author Victor
 */
public class OrderTest {
	
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession sqlSession = null;
	OrderMapper orderMapper = null;

	// 使用slf4j-api中的接口
	Logger log = LoggerFactory.getLogger(OrderTest.class);
	
	@Before
	public void getSessionFactory() {
		String conf = "mybatis-config.xml";
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(conf);
			sqlSessionFactory  = new SqlSessionFactoryBuilder().build(reader);
			sqlSession = sqlSessionFactory.openSession();
			orderMapper = sqlSession.getMapper(OrderMapper.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭session
	 */
	@After
	public void closeSessionFactory() {
		sqlSession.close();
	}

	/**
	 * 插入
	 */
	@Test
	public void testInsert() {
		Order order = new Order();
		order.setGoodsName("gn2");
		order.setQuantity(5);
		order.setUserId(13L);
		int row = orderMapper.insert(order);
		System.out.println(row);
	}

	/**
	 * 只查询Order
	 */
	@Test
	public void testQueryById() {
		Order order = orderMapper.queryById(1L);
		System.out.println(order);
	}

	/**
	 * 测试使用association元素的select属性
	 */
	@Test
	public void testOrderResultMap1() {
		Order order = orderMapper.queryById1(1L);
		System.out.println(order); // ok, 注意User中的orders属性为null
	}

	/**
	 * 测试使用association元素的resultMap属性
	 * 未测试通过！
	 */
	@Test
	public void testOrderResultMap2() {
		Order order = orderMapper.queryById2(1L);
		System.out.println(order);
	}

	/**
	 * 测试使用association元素下指定关联的领域模型与表关系
	 * 未测试通过！
	 */
	@Test
	public void testOrderResultMap3() {
		Order order = orderMapper.queryById3(1L);
		System.out.println(order);
	}



}
