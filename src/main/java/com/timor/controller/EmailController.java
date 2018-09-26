package com.timor.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.timor.utils.EmailUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 用于测试邮件发送
 * @author YuanZhe
 * @date 2018年9月3日 下午4:06:34
 * 
 */
@RestController
public class EmailController
{
	private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

	@RequestMapping("sendEmail")
	public String sendEmail() throws JsonProcessingException
	{
		boolean isSend = EmailUtils.sendEmail(new String[] { "yuanzhe13579@163.com" },
				new String[] { "411535707@qq.com" }, "这是一封测试邮件",
				"<h3><a href='http://www.baidu.com'>Timor</a></h3>这是一封“痛宁吗”的测试邮件！", null);
		logger.info("发送邮件 : {}", isSend);
		return "发送邮件 : " + isSend;
	}

}