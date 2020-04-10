package com.vic.mapper;

import com.vic.entity.User;


/**
 * 用户dao
 * @author Victor
 */
public interface UserMapper {
	
	/**
	 * 根据用户id查询用户
	 * @param id
	 * @return
	 */
	User queryById(Long id);
	
	/**
	 * 新增用户
	 * @param user
	 */
	Integer insert(User user);

	/**
	 * 插入用户后返回id
	 * @param user
	 * @return
	 */
	Long insertAndGetId1(User user);

	/**
	 * 插入用户后返回id
	 * @param user
	 * @return
	 */
	Long insertAndGetId2(User user);

}
