package com.timor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timor.entity.User;
import com.timor.mapper.UserMapper;
import com.timor.service.UserService;

/**
 * @Description 用户信息业务处理实现类（MyBatis注解）
 * @author YuanZhe
 * @date 2018年8月30日 下午4:21:10
 * 
 */
@Service(value="user4MyBatisService")
public class User4MyBatisServiceImpl implements UserService
{
	@Autowired
	private UserMapper userMapper;

	public User getUserById(Integer id)
	{
		return userMapper.getUserById(id);
	}

	public List<User> getUserList()
	{
		return userMapper.getUserList();
	}

	@Transactional
	public int add(User user)
	{
		return userMapper.add(user);
	}

	@Transactional
	public int update(User user)
	{
		return userMapper.update(user);
	}

	@Transactional
	public int delete(Integer id)
	{
		return userMapper.delete(id);
	}

}
