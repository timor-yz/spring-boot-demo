package com.timor.mapper;

import com.timor.entity.User;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description 配置文件版
 * @author YuanZhe
 * @date 2018年8月30日 下午5:13:05
 * 
 */
@Mapper
public interface UserXmlMapper
{
	/**
	 * @Description 根据用户id查询用户信息
	 * @param id 用户id
	 * @return 用户信息
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:11:18
	 */
	User getUserById(Integer id);

	/**
	 * @Description 获取所有用户信息
	 * @return 用户信息集合
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:11:45
	 */
	public List<User> getUserList();

	/**
	 * @Description 新增用户
	 * @param user 需新增的用户信息对象
	 * @return 新增结果
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:12:06
	 */
	public int add(User user);

	/**
	 * @Description 修改用户信息
	 * @param user 需修改的用户信息对象
	 * @return 修改结果
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:12:32
	 */
	public int update(@Param("user") User user);

	/**
	 * @Description 根据用户id删除用户信息
	 * @param id 用户id
	 * @return 删除结果
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:13:31
	 */
	public int delete(Integer id);
}
