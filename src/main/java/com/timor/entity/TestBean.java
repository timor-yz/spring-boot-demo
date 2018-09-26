package com.timor.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description 用于测试
 * @author YuanZhe
 * @date 2018年8月30日 下午3:47:56
 * 
 */
@Component
public class TestBean
{
	@Value("${test.user.username}")
	private String username;
 
	@Value("${test.user.age}")
	private String age;
	
	@Value("${test.user.toString}")
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
