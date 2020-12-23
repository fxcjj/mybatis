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
	 * 插入用户
	 */
	@Test
	public void testInsert() {
		Student student = new Student();
		student.setAddress("ad2");
		student.setAge(2);
		student.setBirthday(new Date());
		student.setName("vic2");
		studentMapper.insert(student);
	}

	@Test
	public void testQueryById() {
		Student student = studentMapper.queryUserById(1L);
		System.out.println(student);
	}

	/**
	 * foreach
	 */
	@Test
	public void testForeach1() {
		List<Long> idList = new ArrayList<Long>();
		idList.add(1L);
		idList.add(2L);
		idList.add(3L);
		List<Student> list = studentMapper.findStudentIn1(idList);
		System.out.println(list);
	}

	/**
	 * foreach
	 */
	@Test
	public void testForeach2() {
		List<Long> idList = new ArrayList<Long>();
		idList.add(1L);
		idList.add(2L);
		idList.add(3L);
		List<Student> list = studentMapper.findStudentIn2(idList);
		System.out.println(list);
	}

	/**
	 * if
	 */
	@Test
	public void testFindNormalStudentWithNameLike() {
		Student s = new Student();
		s.setName("name");
		List<Student> list = studentMapper.findNormalStudentWithNameLike(s);
		System.out.println(list);
	}

	/**
	 * choose、when、otherwise
	 */
	@Test
	public void testChoose() {
		Student s = new Student();
//		s.setName("name");
//		s.setAddress("add");
		List<Student> list = studentMapper.testChoose(s);
		System.out.println(list);
	}

	/**
	 * choose、when、otherwise
	 * 测试传入固定值
	 */
	@Test
	public void testChoose2() {
		String s = "2";
		List<Student> list = studentMapper.testChoose2(s);
		System.out.println(list);
	}

	/**
	 * trim、where、set
	 */
	@Test
	public void testWhere() {
		Student s = new Student();
		s.setName("vic");
//		s.setAddress("add");
		List<Student> list1 = studentMapper.testWhere(s);
		System.out.println("where语句结果：");
		System.out.println(list1);

		List<Student> list2 = studentMapper.testTrimInsteadOfWhere(s);
		System.out.println("使用trim代替where语句结果：");
		System.out.println(list2);
	}

	/**
	 * trim、where、set
	 */
	@Test
	public void testSet() {
		Student s = new Student();
		s.setId(1L);
		s.setName("martin");
		s.setAge(18);
		s.setAddress("shanghai");
		int row1 = studentMapper.testSet(s);
		System.out.println("set语句结果：");
		System.out.println(row1);
	}

	/**
	 * trim、where、set
	 */
	@Test
	public void testTrimInsteadOfSet() {
		Student s = new Student();
		s.setId(2L);
		s.setName("dina");
		s.setAge(20);
		s.setAddress("american");
		int row1 = studentMapper.testTrimInsteadOfSet(s);
		System.out.println("使用trim代替set语句结果：");
		System.out.println(row1);
	}

	/**
	 * 强制更新
	 */
	@Test
	public void testUpdate() {
		Student student = new Student();
//		student.setId(3L);
		student.setAddress("上海静安区1");
		student.setAge(0);
		student.setBirthday(new Date());
		student.setName("marti11n");
		student.setDeleteFlag(1);
		studentMapper.updateAnyway(student);
	}

	/**
	 * 使用@Update注解中的script元素
	 * 未测试通过，语法错误！
	 */
	@Test
	public void testUpdateWithScriptElement() {
		Student s = new Student();
		s.setId(3L);
		s.setName("jack");
		s.setAge(21);
		s.setAddress("shangdong");
		int row = studentMapper.testUpdateWithScriptElement(s);
		System.out.println("使用@Update注解中的script元素：" + row);
	}

	/**
	 * 测试bind元素
	 */
	@Test
	public void testBindElement() {
		Student s = new Student();
		s.setName("vic");
		List<Student> list = studentMapper.testBindElement(s);
		System.out.println(list);
	}
}
