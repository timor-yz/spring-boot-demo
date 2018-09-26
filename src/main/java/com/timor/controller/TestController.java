package com.timor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.timor.entity.TestBean;
import com.timor.entity.TestTwoBean;

/**
 * @Description 用于测试
 * @author YuanZhe
 * @date 2018年8月30日 下午3:41:24
 * 
 */
@RestController
public class TestController
{

	@RequestMapping("/")
	public String home()
	{
		return "Hello Word!";
	}

	@RequestMapping(value = "sayhello", method = RequestMethod.GET)
	public String sayhello()
	{
		return "Hello SpringBoot!";
	}

	@Autowired
	private TestBean testBean;

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String test()
	{
		return testBean.getToString();
	}

	@Autowired
	private TestTwoBean testTwoBean;

	@RequestMapping(value = "test2", method = RequestMethod.GET)
	public String test2()
	{
		return testTwoBean.getUsername() + ":" + testTwoBean.getAge();
	}

}