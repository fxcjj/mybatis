package com.vic;


import com.vic.entity.Student;
import com.vic.mapper.StudentMapper;
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
public class StudentTest {
	
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession sqlSession = null;
	StudentMapper studentMapper = null;

	// 使用slf4j-api中的接口
	Logger log = LoggerFactory.getLogger(StudentTest.class);
	
	@Before
	public void getSessionFactory() {
		String conf = "mybatis-config.xml";
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(conf);
			sqlSessionFactory  = new SqlSessionFactoryBuilder().build(reader);
			sqlSession = sqlSessionFactory.openSession();
			studentMapper = sqlSession.getMapper(StudentMapper.class);
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
	 * 仅仅查询单个
	 */
	@Test
	public void testQueryById() {
		Student student = studentMapper.queryUserById(1L);
		System.out.println(student);
	}

	@Test
	public void testQueryByIds() {
		List<Long> idList = new ArrayList<Long>();
		idList.add(1L);
		idList.add(2L);
		idList.add(3L);
		List<Student> list = studentMapper.queryByIds(idList);
		System.out.println(list);
	}
	
	@Test
	public void testFuzzyByCondition() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", "name");
		param.put("startIndex", 0);
		param.put("pageSize", 10);
		List<Student> fuzzyByCondition = studentMapper.fuzzyByCondition(param);
		System.out.println(fuzzyByCondition);
	}

	/**
	 * 插入用户
	 */
	@Test
	public void testInsert() {
		Student student = new Student();
		student.setAddress("add7");
		student.setAge(7);
		student.setBirthday(new Date());
		student.setName("name7");
		studentMapper.insert(student);
	}

	@Test
	public void testUpdate() {
		Student student = new Student();
//		student.setId(3L);
		student.setAddress("上海静安区1");
		student.setAge(0);
		student.setBirthday(new Date());
		student.setName("marti11n");
		student.setDeleteFlag(1);
		studentMapper.update(student);
	}
	
}
