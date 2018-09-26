package com.timor.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description properties文件操作工具类
 * @author YuanZhe
 * @date 2018年8月8日 上午10:23:23
 * 
 */
public final class PropertiesUtils
{
	private static final Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);

	/**
	 * @Fields RESOURCE_NAME : 需读取的properties文件路径（相对路径）
	 */
	private static final String RESOURCE_NAME = "config/sysconfig.properties";

	/**
	 * @Fields property : java.util.Properties对象
	 */
	private static Properties property = new Properties();

	static
	{
		init();
	}

	/**
	 * @Description 初始化
	 * 
	 * @author YuanZhe
	 * @date 2018年8月8日 上午10:21:29
	 */
	public static void init()
	{
		setProperty(loadUrlProperties(RESOURCE_NAME));
	}

	/**
	 * @Description 加载读取properties文件
	 * @return java.util.Properties对象
	 * 
	 * @author YuanZhe
	 * @date 2018年8月8日 上午10:33:00
	 */
	public static Properties loadUrlProperties(String resourceName)
	{
		Properties props = new Properties();
		InputStream is = null;
		try
		{
			logger.info("PropertiesLoaderUtils 系统读取配置" + resourceName);
			is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceName);
			props.load(is);
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			if (is != null)
			{
				try
				{
					is.close();
					is = null;
				} catch (IOException e)
				{
					e.printStackTrace();
					logger.error("PropertiesLoaderUtils 系统读取配置“" + resourceName + "”失败：" + e.getMessage());
				}
			}
		}
		return props;
	}

	/**
	 * @Description 获取java.util.Properties对象
	 * @return java.util.Properties对象
	 * 
	 * @author YuanZhe
	 * @date 2018年8月8日 上午10:24:08
	 */
	public static Properties getProperty()
	{
		if (property == null || property.isEmpty() || property.size() == 0)
			init();
		return property;
	}

	/**
	 * @Description 设置java.util.Properties对象
	 * @param props java.util.Properties对象
	 * 
	 * @author YuanZhe
	 * @date 2018年8月8日 上午10:25:24
	 */
	public static void setProperty(Properties props)
	{
		property = props;
	}

	/**
	 * @Description 获取properties文件中对应的属性值
	 * @param key 属性名称（键）
	 * @return 属性值（值）
	 * @throws Exception 抛出异常
	 * 
	 * @author YuanZhe
	 * @date 2018年8月8日 上午10:25:44
	 */
	public static String getPropertyValue(String key) throws Exception
	{
		if (StringUtils.isEmpty(key))
			return "";
		return (String) getProperty().get(key);
	}

	/**
	 * @Description 获取properties文件中对应的属性值，若不存在或为空则返回默认值
	 * @param key          属性名称（键）
	 * @param defaultValue 默认值
	 * @return 属性值（值）
	 * @throws Exception 抛出异常
	 * 
	 * @author YuanZhe
	 * @date 2018年8月8日 上午10:26:50
	 */
	public static String getPropertyValueDefault(String key, String defaultValue) throws Exception
	{
		if (StringUtils.isEmpty(key))
			return "";
		Object valObj = getProperty().get(key);
		if (valObj != null && !StringUtils.isEmpty(valObj.toString()))
			return (String) valObj;
		return defaultValue;
	}

	public static void main(String[] args)
	{

	}
}
