package com.timor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timor.dao.UserDao;
import com.timor.entity.User;
import com.timor.service.UserService;

/**
 * @Description 用户信息业务处理实现类（JDBC）
 * @author YuanZhe
 * @date 2018年8月30日 下午4:21:10
 * 
 */
@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao userDao;


	@Cacheable(value = "user/getbyid", key = "'user.id:'+#id")
	public User getUserById(Integer id)
	{
		System.out.println("======================进入getbyid方法, 参数为: " + id);
		return userDao.getUserById(id);
	}

	public List<User> getUserList()
	{
		return userDao.getUserList();
	}

	@Transactional
	public int add(User user)
	{
		return userDao.add(user);
	}

	@Transactional
	public int update(User user)
	{
		return userDao.update(user);
	}

	@Transactional
	public int delete(Integer id)
	{
		return userDao.delete(id);
	}

}
