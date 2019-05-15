package com.vic.user.dao;

import com.vic.user.entity.User;

import java.util.List;
import java.util.Map;


/**
 * 用户dao
 * @author Victor
 */
public interface UserDao {
	
	/**
	 * 根据用户id查询用户
	 * @param id
	 * @return
	 */
	User queryById(int id);
	
	/**
	 * 新增用户
	 * @param user
	 */
	Integer insert(User user);
	
	/**
	 * 更新用户
	 * @param user
	 */
	Integer update(User user);
	
	/**
	 * 选择更新
	 * @param user
	 */
	Integer updateBySelective(User user);
	
	/**
	 * 逻辑删除用户
	 * @param id
	 * @return
	 */
	Integer delete(int id);
	
	/**
	 * 根据ids查询用户列表
	 * @return
	 */
	List<User> queryByIds(List<Integer> idList);
	
	/**
	 * 模糊分页查询
	 * @param param
	 * @return
	 */
	List<User> fuzzyByCondition(Map<String, Object> param);
	
}
