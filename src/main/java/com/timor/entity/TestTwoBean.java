package com.timor.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description 用于测试
 * @author YuanZhe
 * @date 2018年8月30日 下午3:47:56
 * 
 */
@Component
@ConfigurationProperties(prefix = "test.user")
public class TestTwoBean
{
	private String username;
 
	private String age;
	
	private String toString;

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getAge()
	{
		return age;
	}

	public void setAge(String age)
	{
		this.age = age;
	}

	public String getToString()
	{
		return toString;
	}

	public void setToString(String toString)
	{
		this.toString = toString;
	}
	
}
