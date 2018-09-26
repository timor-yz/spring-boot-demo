package com.timor.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.timor.common.JsonResult;
import com.timor.entity.User;
import com.timor.service.UserService;

/**
 * @Description 用户信息处理控制器
 * @author YuanZhe
 * @date 2018年8月30日 下午4:24:19
 * 
 */
// @CrossOrigin，跨域请求注解，参考：https://blog.csdn.net/saytime/article/details/74937204
// @CrossOrigin(origins = "http://localhost:8080", maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
public class TestUserController
{
	/*------------------------------ JDBC start ------------------------------*/

	@Resource(name = "userServiceImpl")
	private UserService userService;

	/**
	 * @Description 根据用户id查询用户信息（JDBC）
	 * @param id 用户id
	 * @return JsonResult
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:25:41
	 */
	@RequestMapping(value = "/jdbc/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> getUserById(@PathVariable(value = "id") Integer id)
	{
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
	 * @Description 获取所有用户信息（JDBC）
	 * @return JsonResult
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:26:24
	 */
	@RequestMapping(value = "/jdbc/users", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> getUserList()
	{
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
	 * @Description 新增用户（JDBC）
	 * @param 需新增的用户信息对象
	 * @return JsonResult
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:26:52
	 */
	@RequestMapping(value = "/jdbc/user", method = RequestMethod.POST)
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
	 * @Description 修改用户信息（JDBC）
	 * @param user 需修改的用户信息对象
	 * @return JsonResult
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:27:40
	 */
	@RequestMapping(value = "/jdbc/user", method = RequestMethod.PUT)
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
	 * @Description 根据用户id删除用户信息（JDBC）
	 * @param id 用户id
	 * @return JsonResult
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:27:35
	 */
	@RequestMapping(value = "/jdbc/user/{id}", method = RequestMethod.DELETE)
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

	/*------------------------------ JDBC end ------------------------------*/

	/*------------------------------ MyBatis 注解 start ------------------------------*/

	@Resource
	private UserService user4MyBatisService;

	/**
	 * @Description 根据用户id查询用户信息（MyBatis注解）
	 * @param id 用户id
	 * @return JsonResult
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:25:41
	 */
	@RequestMapping(value = "/mybatis/anno/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> getUserById2(@PathVariable(value = "id") Integer id)
	{
		JsonResult r = new JsonResult();
		try
		{
			User user = user4MyBatisService.getUserById(id);
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
	 * @Description 获取所有用户信息（MyBatis注解）
	 * @return JsonResult
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:26:24
	 */
	@RequestMapping(value = "/mybatis/anno/users", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> getUserList2()
	{
		JsonResult r = new JsonResult();
		try
		{
			List<User> users = user4MyBatisService.getUserList();
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
	 * @Description 新增用户（MyBatis注解）
	 * @param 需新增的用户信息对象
	 * @return JsonResult
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:26:52
	 */
	@RequestMapping(value = "/mybatis/anno/user", method = RequestMethod.POST)
	public ResponseEntity<JsonResult> add2(@RequestBody User user)
	{
		JsonResult r = new JsonResult();
		try
		{
			int orderId = user4MyBatisService.add(user);
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
	 * @Description 修改用户信息（MyBatis注解）
	 * @param user 需修改的用户信息对象
	 * @return JsonResult
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:27:40
	 */
	@RequestMapping(value = "/mybatis/anno/user", method = RequestMethod.PUT)
	public ResponseEntity<JsonResult> update2(@RequestBody User user)
	{
		JsonResult r = new JsonResult();
		try
		{
			int ret = user4MyBatisService.update(user);
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
	 * @Description 根据用户id删除用户信息（MyBatis注解）
	 * @param id 用户id
	 * @return JsonResult
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:27:35
	 */
	@RequestMapping(value = "/mybatis/anno/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<JsonResult> delete2(@PathVariable(value = "id") Integer id)
	{
		JsonResult r = new JsonResult();
		try
		{
			int ret = user4MyBatisService.delete(id);
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

	/*------------------------------ MyBatis 注解 end ------------------------------*/

	/*------------------------------ MyBatis 配置文件 start ------------------------------*/

	@Resource
	private UserService user4MyBatisXmlService;

	/**
	 * @Description 根据用户id查询用户信息（MyBatis配置文件）
	 * @param id 用户id
	 * @return JsonResult
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:25:41
	 */
	@RequestMapping(value = "/mybatis/xml/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> getUserById3(@PathVariable(value = "id") Integer id)
	{
		JsonResult r = new JsonResult();
		try
		{
			User user = user4MyBatisXmlService.getUserById(id);
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
	 * @Description 获取所有用户信息（MyBatis配置文件）
	 * @return JsonResult
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:26:24
	 */
	@RequestMapping(value = "/mybatis/xml/users", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> getUserList3()
	{
		JsonResult r = new JsonResult();
		try
		{
			List<User> users = user4MyBatisXmlService.getUserList();
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
	 * @Description 新增用户（MyBatis配置文件）
	 * @param 需新增的用户信息对象
	 * @return JsonResult
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:26:52
	 */
	@RequestMapping(value = "/mybatis/xml/user", method = RequestMethod.POST)
	public ResponseEntity<JsonResult> add3(@RequestBody User user)
	{
		JsonResult r = new JsonResult();
		try
		{
			int orderId = user4MyBatisXmlService.add(user);
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
	 * @Description 修改用户信息（MyBatis配置文件）
	 * @param user 需修改的用户信息对象
	 * @return JsonResult
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:27:40
	 */
	@RequestMapping(value = "/mybatis/xml/user", method = RequestMethod.PUT)
	public ResponseEntity<JsonResult> update3(@RequestBody User user)
	{
		JsonResult r = new JsonResult();
		try
		{
			int ret = user4MyBatisXmlService.update(user);
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
	 * @Description 根据用户id删除用户信息（MyBatis配置文件）
	 * @param id 用户id
	 * @return JsonResult
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:27:35
	 */
	@RequestMapping(value = "/mybatis/xml/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<JsonResult> delete3(@PathVariable(value = "id") Integer id)
	{
		JsonResult r = new JsonResult();
		try
		{
			int ret = user4MyBatisXmlService.delete(id);
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

	/*------------------------------ MyBatis 配置文件 end ------------------------------*/

	/*------------------------------ Others start ------------------------------*/

	/**
	 * @Description 用于JSONP跨域请求
	 * @return 后台返回数据
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:26:24
	 */
	@RequestMapping(value = "/jsonp")
	public String jsonp(HttpServletRequest request)
	{
		String params = request.getParameter("params");
		String callback = request.getParameter("callback");
		String data = "{'result':'" + params + "'}";
		return callback + "(" + data + ")";
	}

	/**
	 * @Description 用于CORS跨域请求
	 * @return 后台返回数据
	 * 
	 * @author YuanZhe
	 * @date 2018年8月30日 下午4:26:24
	 */
	@RequestMapping(value = "/cors")
	public ResponseEntity<JsonResult> cors(HttpServletRequest request, HttpServletResponse response)
	{
		// 相关参考：https://developer.mozilla.org/zh-CN/docs/Web/HTTP
		// Access-Control-Allow-Origin
		// 这里*为通配符，表示允许所有的域请求来源。一般情况下，为了安全，设置为自己信任的域名，表示仅供信任的域名访问，其他域名也就访问不了了
		// response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");

		// Access-Control-Allow-Methods
		// 表示允许请求的请求类型，比如GET,POST,OPTIONS,PUT等
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");

		response.setHeader("Access-Control-Allow-Credentials", "true");

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

	/*------------------------------ Others end ------------------------------*/

}
