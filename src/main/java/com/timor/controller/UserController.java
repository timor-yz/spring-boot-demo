package com.timor.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.timor.common.JsonResult;
import com.timor.entity.User;
import com.timor.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Description 用户信息处理控制器
 * @author YuanZhe
 * @date 2018年8月30日 下午4:24:19
 * 
 */
@RestController
@Api("UserController相关的API")
public class UserController
{
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource(name = "userServiceImpl")
	private UserService userService;

	/**
	 * @Description 根据用户id查询用户信息
	 * @param id 用户id
	 * @return JsonResult
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:25:41
	 */
	@ApiOperation(value = "根据用户id查询用户信息", notes = "根据url的id来获取用户详细信息")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
	@RequestMapping(value = "user/{id}", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> getUserById(@PathVariable(value = "id") Integer id)
	{
		logger.info("根据用户id查询用户信息，id：{}", id);
		JsonResult r = new JsonResult();
		try
		{
			User user = userService.getUserById(id);
			r.setResult(user);
			r.setStatus("ok");
		} catch (Exception e)
		{
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");
			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}

	/**
	 * @Description 获取所有用户信息
	 * @return JsonResult
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:26:24
	 */
	@ApiOperation(value = "获取所有用户信息", notes = "获取所有用户信息")
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> getUserList()
	{
		logger.info("获取所有用户信息");
		JsonResult r = new JsonResult();
		try
		{
			List<User> users = userService.getUserList();
			r.setResult(users);
			r.setStatus("ok");
		} catch (Exception e)
		{
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");
			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}

	/**
	 * @Description 新增用户
	 * @param 需新增的用户信息对象
	 * @return JsonResult
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:26:52
	 */
	@ApiOperation(value = "新增用户", notes = "根据User对象创建用户")
	@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
	@RequestMapping(value = "user", method = RequestMethod.POST)
	public ResponseEntity<JsonResult> add(@RequestBody User user)
	{
		JsonResult r = new JsonResult();
		try
		{
			int orderId = userService.add(user);
			if (orderId < 0)
			{
				r.setResult(orderId);
				r.setStatus("fail");
			} else
			{
				r.setResult(orderId);
				r.setStatus("ok");
			}
		} catch (Exception e)
		{
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");

			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}

	/**
	 * @Description 修改用户信息
	 * @param user 需修改的用户信息对象
	 * @return JsonResult
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:27:40
	 */
	@ApiOperation(value = "修改用户信息", notes = "根据url的id来指定更新用户信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path"),
			@ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User") })
	@RequestMapping(value = "user", method = RequestMethod.PUT)
	public ResponseEntity<JsonResult> update(@RequestBody User user)
	{
		JsonResult r = new JsonResult();
		try
		{
			int ret = userService.update(user);
			if (ret < 0)
			{
				r.setResult(ret);
				r.setStatus("fail");
			} else
			{
				r.setResult(ret);
				r.setStatus("ok");
			}
		} catch (Exception e)
		{
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");

			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}

	/**
	 * @Description 根据用户id删除用户信息
	 * @param id 用户id
	 * @return JsonResult
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:27:35
	 */
	@ApiOperation(value = "根据用户id删除用户信息", notes = "根据url的id来指定删除用户")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
	@RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<JsonResult> delete(@PathVariable(value = "id") Integer id)
	{
		JsonResult r = new JsonResult();
		try
		{
			int ret = userService.delete(id);
			if (ret < 0)
			{
				r.setResult(ret);
				r.setStatus("fail");
			} else
			{
				r.setResult(ret);
				r.setStatus("ok");
			}
		} catch (Exception e)
		{
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");

			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}

	/**
	 * @Description 可使用@ApiIgnore注解忽略Swagger2 API
	 * @return
	 * 
	 * @author YuanZhe
	 * @date 2018年9月3日 上午9:37:42
	 */
	@ApiIgnore
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String jsonTest()
	{
		return "hi you!";
	}

}
