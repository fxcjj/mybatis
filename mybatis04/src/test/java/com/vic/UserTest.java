package com.vic;


import com.vic.entity.User;
import com.vic.mapper.UserMapper;
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

	/**
	 * 返回map
	 */
	@Test
	public void testSelectUserById4Map() {
		HashMap<String, Object> userMap = userMapper.selectUserById4Map(1L);
		System.out.println(userMap);
	}

	/**
	 * 批量插入用户
	 */
	@Test
	public void testBatchInsert() {
		List<User> users = new ArrayList<>();
		users.add(new User("name1", 1, new Date(), "addr1"));
		users.add(new User("name2", 2, new Date(), "addr2"));
		users.add(new User("name3", 3, new Date(), "addr3"));
		int row = userMapper.batchInsert(users);
		System.out.println(row); //3
	}

	@Test
	public void testQueryById() {
		User user = userMapper.queryById(1L);
		System.out.println(user);
	}

	@Test
	public void testQueryByIds() {
		List<Long> idList = new ArrayList<Long>();
		idList.add(1L);
		idList.add(2L);
		idList.add(3L);
		List<User> userList = userMapper.queryByIds(idList);
		System.out.println(userList);
	}
	
	@Test
	public void testFuzzyByCondition() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", "name");
		param.put("startIndex", 0);
		param.put("pageSize", 10);
		List<User> fuzzyByCondition = userMapper.fuzzyByCondition(param);
		System.out.println(fuzzyByCondition);
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

	@Test
	public void testUpdate() {
		User user = new User();
//		user.setId(3L);
		user.setAddress("上海静安区1");
		user.setAge(0);
		user.setBirthday(new Date());
		user.setName("marti11n");
		user.setDeleteFlag(1);
		userMapper.update(user);
	}
	
}
