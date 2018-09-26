package com.timor.entity;

/**
 * @Description 用户信息实体类
 * @author YuanZhe
 * @date 2018年8月30日 下午4:09:14
 * 
 */
public class User extends BaseBean
{
	private static final long serialVersionUID = -8223254969427713716L;

	private Integer id; // 编号
	private String userName; // 用户名
	private String password; // 密码

	/**
	 * 无参构造
	 */
	public User()
	{
		super();
	}

	/**
	 * 带参构造
	 * 
	 * @param id       编号
	 * @param userName 用户名
	 * @param password 密码
	 */
	public User(Integer id, String userName, String password)
	{
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder("User{");
		sb.append("id : " + (id != null ? id : "null"));
		sb.append("、userName : " + (userName != null ? userName : "null"));
		sb.append("、password : " + (password != null ? password : "null"));
		sb.append("}");
		return sb.toString();
	}
}
