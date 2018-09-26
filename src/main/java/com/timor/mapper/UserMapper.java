package com.timor.mapper;

import com.timor.entity.User;

import java.util.List;

import org.apache.ibatis.annotations.*;

/**
 * @Description 这里使用@Mapper注解，但是每个mapper都加注解比较麻烦，所以统一配置@MapperScan在扫描路径在application类中
 * @author YuanZhe
 * @date 2018年8月30日 下午5:13:05
 * 
 */
@Mapper
public interface UserMapper
{
	/**
	 * @Description 根据用户id查询用户信息
	 * @param id 用户id
	 * @return 用户信息
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:11:18
	 */
	@Select("select * from user where id = #{id}")
	User getUserById(Integer id);

	/**
	 * @Description 获取所有用户信息
	 * @return 用户信息集合
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:11:45
	 */
	@Select("select * from user")
	public List<User> getUserList();

	/**
	 * @Description 新增用户
	 * @param user 需新增的用户信息对象
	 * @return 新增结果
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:12:06
	 */
	@Insert("insert into user(user_name, password) values(#{userName}, #{password})")
	public int add(User user);

	/**
	 * @Description 修改用户信息
	 * @param user 需修改的用户信息对象
	 * @return 修改结果
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:12:32
	 */
	@Update("update user set user_name = #{user.userName} , password = #{user.password} where id = #{user.id}")
	public int update(@Param("user") User user);

	/**
	 * @Description 根据用户id删除用户信息
	 * @param id 用户id
	 * @return 删除结果
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:13:31
	 */
	@Delete("delete from user where id = #{id} ")
	public int delete(Integer id);
}
