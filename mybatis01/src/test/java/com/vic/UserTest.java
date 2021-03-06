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
import java.util.Date;


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
			log.info("加载mybatis-config.xml完成");
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
		log.info("关闭session完成");
	}

	@Test
	public void testQueryById() {
		User user = userMapper.queryById(1L);
		System.out.println(user);
		
		Assert.assertNotNull("没找到数据", user);
	}

	@Test
	public void testInsert() {
		User user = new User();
		user.setAddress("add");
		user.setAge(12);
		user.setBirthday(new Date());
		user.setName("name1");
		userMapper.insert(user);
	}

}
