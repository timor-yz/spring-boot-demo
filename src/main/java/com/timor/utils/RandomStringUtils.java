package com.timor.utils;

/**
 * @Description
 *              <ul>
 *              随机字符串工具类，继承org.apache.commons.lang3.RandomStringUtils
 *              <hr>
 *              <li>commons-lang3中RandomStringUtils类方法介绍参考：
 *              <ol>
 *              <li>官方PAI
 *              <ul>
 *              <li><i>http://commons.apache.org/proper/commons-lang/javadocs/api-release/</i></li>
 *              </ul>
 *              </li>
 *              <li>“随风yy”提供
 *              <ul>
 *              <li><i>https://blog.csdn.net/yaomingyang/article/details/79107764</i></li>
 *              </ul>
 *              </li>
 *              </ol>
 *              </li>
 *              </ul>
 * @author YuanZhe
 * @date 2018年9月26日 上午9:20:43
 * 
 */
public class RandomStringUtils extends org.apache.commons.lang3.RandomStringUtils
{
	public static void main(String[] args)
	{
		System.out.println(random(20, true, true));
	}
}
