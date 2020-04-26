package com.vic;

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
 * @author Victor
 * date: 2020/4/26 10:17
 */
public class WowTest {


    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
//    StudentMapper studentMapper = null;

    // 使用slf4j-api中的接口
    Logger log = LoggerFactory.getLogger(WowTest.class);

    @Before
    public void getSessionFactory() {
        String conf = "mybatis-config.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(conf);
            sqlSessionFactory  = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
//            studentMapper = sqlSession.getMapper(StudentMapper.class);
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
    }

}


