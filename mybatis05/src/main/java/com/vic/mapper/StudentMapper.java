package com.vic.mapper;

import com.vic.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * @author Victor
 */
public interface StudentMapper {
	
	/**
	 * 根据用户id查询
	 * @param id
	 * @return
	 */
	Student queryUserById(Long id);

	/**
	 * 根据ids查询用户列表
	 * @return
	 */
	List<Student> queryByIds(List<Long> idList);

	/**
	 * 新增
	 * @param student
	 */
	int insert(Student student);

	/**
	 * 更新用户
	 * @param student
	 */
	Integer update(Student student);
	
	/**
	 * 选择更新
	 * @param student
	 */
	Integer updateBySelective(Student student);
	
	/**
	 * 逻辑删除用户
	 * @param id
	 * @return
	 */
	Integer delete(Long id);

	/**
	 * 模糊分页查询
	 * @param param
	 * @return
	 */
	List<Student> fuzzyByCondition(Map<String, Object> param);

}
