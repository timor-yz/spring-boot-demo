package com.timor.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.timor.dao.UserDao;
import com.timor.entity.User;

/**
 * @Description 用户信息数据处理实现类
 * @author YuanZhe
 * @date 2018年8月30日 下午4:14:58
 * 
 */
@Repository
public class UserDaoImpl implements UserDao
{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public User getUserById(Integer id)
	{
		List<User> list = jdbcTemplate.query("select * from user where id = ?", new Object[] { id },
				new BeanPropertyRowMapper(User.class));
		if (list != null && list.size() > 0)
			return list.get(0);
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<User> getUserList()
	{
		List<User> list = jdbcTemplate.query("select * from user", new Object[] {},
				new BeanPropertyRowMapper(User.class));
		if (list != null && list.size() > 0)
			return list;
		return null;
	}

	public int add(User user)
	{
		return jdbcTemplate.update("insert into user(user_name, password) values(?, ?)", user.getUserName(),
				user.getPassword());
	}

	public int update(User user)
	{
		return jdbcTemplate.update("update user set user_name = ? , password = ? where id = ?", user.getUserName(),
				user.getPassword(), user.getId());
	}

	public int delete(Integer id)
	{
		return jdbcTemplate.update("delete from user where id = ?", id);
	}

}
