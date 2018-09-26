package com.timor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Description
 *              <ul>
 *              Swagger启动配置类
 *              <li>参考：https://blog.csdn.net/saytime/article/details/74937664</li>
 *              <li>@Configuration：等价于XML中配置beans</li>
 *              <li>@Bean：标注方法等价于XML中配置bean</li>
 *              <li>@EnableSwagger2：表示开启Swagger</li>
 *              <li>swagger通过注解表明该接口会生成文档，包括接口名、请求方法、参数、返回信息的等等。
 *              <ul>
 *              <li>@Api：修饰整个类，描述Controller的作用</li>
 *              <li>@ApiOperation：描述一个类的一个方法，或者说一个接口</li>
 *              <li>@ApiParam：单个参数描述</li>
 *              <li>@ApiModel：用对象来接收参数</li>
 *              <li>@ApiProperty：用对象接收参数时，描述对象的一个字段</li>
 *              <li>@ApiResponse：HTTP响应其中1个描述</li>
 *              <li>@ApiResponses：HTTP响应整体描述</li>
 *              <li>@ApiIgnore：使用该注解忽略这个API</li>
 *              <li>@ApiError：发生错误返回的信息</li>
 *              <li>@ApiImplicitParam：一个请求参数</li>
 *              <li>@ApiImplicitParams：多个请求参数</li>
 *              </ul>
 *              </li>
 *              </ul>
 * @author YuanZhe
 * @date 2018年9月3日 上午9:32:04
 * 
 */
@Configuration
public class Swagger2Config
{
	@Bean
	public Docket createRestApi()
	{
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				// 为当前包路径
				.apis(RequestHandlerSelectors.basePackage("com.timor")).paths(PathSelectors.any()).build();
	}

	/**
	 * @Description 构建API文档的详细信息函数
	 * @return
	 * 
	 * @author YuanZhe
	 * @date 2018年9月3日 上午10:17:00
	 */
	private ApiInfo apiInfo()
	{
		return new ApiInfoBuilder()
				// 页面标题
				.title("springboot利用swagger2构建api文档")
				// 创建人
				.contact(new Contact("Timor", "https://blog.csdn.net/qq_34968660", ""))
				// 描述
				.description("简单优雅的restful风格，https://blog.csdn.net/qq_34968660")
				// 服务条款网址
				.termsOfServiceUrl("https://blog.csdn.net/qq_34968660")
				// 版本号
				.version("1.0").build();
	}
}
