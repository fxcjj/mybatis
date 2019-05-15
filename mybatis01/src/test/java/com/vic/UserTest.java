package com.vic;


import com.vic.user.dao.UserDao;
import com.vic.user.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.util.Map.Entry;


/**
 * user模块测试
 * @author Victor
 */
public class UserTest {
	
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession sqlSession = null;
	UserDao userDao = null;
	
	@Before
	public void getSessionFactory() {
		String conf = "mybatis-config.xml";
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(conf);
			sqlSessionFactory  = new SqlSessionFactoryBuilder().build(reader);
			sqlSession = sqlSessionFactory.openSession();
			userDao = sqlSession.getMapper(UserDao.class);
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
		System.out.println("done...");
	}

	@Test
	public void testQueryById() {
		User user = userDao.queryById(1);
		System.out.println(user);
		
		Assert.assertNotNull("没找到数据", user);
	}
	
	@Test
	public void testQueryByIds() {
		List<Integer> idList = new ArrayList<Integer>();
		idList.add(1);
		idList.add(2);
		idList.add(3);
		List<User> userList = userDao.queryByIds(idList);
		System.out.println(userList);
	}
	
	@Test
	public void testFuzzyByCondition() {
		Map<String, Object> param = new HashMap<String, Object>();
//		param.put("hello", "上海");
		param.put("startIndex", 0);
		param.put("pageSize", 10);
		List<User> fuzzyByCondition = userDao.fuzzyByCondition(param);
		System.out.println(fuzzyByCondition);
	}
	
	@Test
	public void testInsert() {
		User user = new User();
		user.setAddress("add");
		user.setAge(12);
		user.setBirthday(new Date());
		user.setName("name1");
		userDao.insert(user);
	}
	
	@Test
	public void testUpdate() {
		User user = new User();
		user.setId(3);
		user.setAddress("上海静安区1");
		user.setAge(0);
		user.setBirthday(new Date());
		user.setName("marti11n");
		user.setDeleteFlag(1);
		userDao.update(user);
	}
	
	
	@Test
	public void testAliases() {
		Configuration conf = sqlSessionFactory.getConfiguration();
		Map<String, Class<?>> typeAliases = conf.getTypeAliasRegistry().getTypeAliases();
		for(Entry<String, Class<?>> entry : typeAliases.entrySet()) {
		    System.out.println(entry.getKey() + " ================> " + entry.getValue().getSimpleName());
		}
		
	}
	
	
}
