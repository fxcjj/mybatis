package com.vic.mapper;

import com.vic.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
	User queryUserById(Long id);

	User queryUserById1(Long id);

	User queryUserById2(Long id);

	/**
	 * 新增用户
	 * @param user
	 */
	int insert(User user);

	/**
	 * 插入多条数据
	 * @param users
	 * @return
	 */
	int batchInsert(List<User> users);

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
	Integer delete(Long id);
	
	/**
	 * 根据ids查询用户列表
	 * @return
	 */
	List<User> queryByIds(List<Long> idList);
	
	/**
	 * 模糊分页查询
	 * @param param
	 * @return
	 */
	List<User> fuzzyByCondition(Map<String, Object> param);

	/**
	 * 根据用户id查询用户，返回hashmap
	 * @param id
	 * @return
	 */
    HashMap<String, Object> selectUserById4Map(long id);

}
