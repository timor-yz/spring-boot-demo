package com.timor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description 通过第三方Tomcat启动
 * @author YuanZhe
 * @date 2018年9月26日 下午5:30:11
 * 
 */
@SpringBootApplication
@EnableTransactionManagement // 启注解事务管理
// @EnableSwagger2 // 加上注解@EnableSwagger2，表示开启Swagger
public class Application extends SpringBootServletInitializer
{
	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		return application.sources(Application.class);
	}
}