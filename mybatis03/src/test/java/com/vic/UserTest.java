package com.vic;


import com.vic.entity.User;
import com.vic.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.*;


/**
 * user模块测试
 * @author Victor
 */
public class UserTest {
	
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession sqlSession = null;
	UserMapper userMapper = null;

	// 使用slf4j-api中的接口
	Logger log = LoggerFactory.getLogger(UserTest.class);
	
	@Before
	public void getSessionFactory() {
		String conf = "mybatis-config.xml";
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(conf);
			sqlSessionFactory  = new SqlSessionFactoryBuilder().build(reader);
			sqlSession = sqlSessionFactory.openSession();
			userMapper = sqlSession.getMapper(UserMapper.class);
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

	@Test
	public void testQueryById() {
		User user = userMapper.queryById(1L);
		System.out.println(user);
		Assert.assertNotNull("没找到数据", user);
	}

	/**
	 * 插入用户
	 */
	@Test
	public void testInsert() {
		User user = new User();
		user.setAddress("add7");
		user.setAge(7);
		user.setBirthday(new Date());
		user.setName("name7");
		userMapper.insert(user);
	}

	/**
	 * 插入用户后返回id
	 */
	@Test
	public void testInsertAndGetId1() {
		User user = new User();
		user.setAddress("add9");
		user.setAge(9);
		user.setBirthday(new Date());
		user.setName("name9");
		userMapper.insertAndGetId1(user);
		log.info("testInsertAndGetId1 返回用户ID：{}", user.getId());
	}

	/**
	 * 插入用户后返回id
	 */
	@Test
	public void testInsertAndGetId2() {
		User user = new User();
		user.setAddress("add11");
		user.setAge(11);
		user.setBirthday(new Date());
		user.setName("name11");
		userMapper.insertAndGetId2(user);
		log.info("testInsertAndGetId2 返回用户ID：{}", user.getId());
	}

}
