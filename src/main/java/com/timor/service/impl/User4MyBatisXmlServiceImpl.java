package com.timor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timor.entity.User;
import com.timor.mapper.UserXmlMapper;
import com.timor.service.UserService;

/**
 * @Description 用户信息业务处理实现类（MyBatis配置文件）
 * @author YuanZhe
 * @date 2018年8月30日 下午4:21:10
 * 
 */
@Service(value="user4MyBatisXmlService")
public class User4MyBatisXmlServiceImpl implements UserService
{
	@Autowired
	private UserXmlMapper userXmlMapper;
	
	public User getUserById(Integer id)
	{
		return userXmlMapper.getUserById(id);
	}

	public List<User> getUserList()
	{
		return userXmlMapper.getUserList();
	}

	@Transactional
	public int add(User user)
	{
		return userXmlMapper.add(user);
	}

	@Transactional
	public int update(User user)
	{
		return userXmlMapper.update(user);
	}

	@Transactional
	public int delete(Integer id)
	{
		return userXmlMapper.delete(id);
	}

}
