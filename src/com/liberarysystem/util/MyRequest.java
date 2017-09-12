package com.liberarysystem.util;
/**
 * 自定义Request类，类似Java web 开发的HttpServletRequest.来完成模块或界面之间的传值工作
 */
import java.io.Serializable;
/**
 * 模仿Java web开发中的HttpServletRequest来实现界面之间的信息传递功能
 */
import java.util.HashMap;
import java.util.Map;

public class MyRequest  {
	/**
	 * 以map的方式存放界面之间要传递的参数。类似于Java web开发中的HttpServletRequest
	 */
	private static Map<String, Object> request = new HashMap<String, Object>();
	// 获得哈希图里key对应的对象（值）
	public Object getAttribute(String key) {
		Object obj = request.get(key);
		return obj;
	}
	/**
	 * 往哈希图里添加新的键值对数据，如果有重复的key，将被覆盖
	 * @param key
	 * @param value
	 */
	public void setAttribute(String key, Object value) {
		request.put(key, value);
	}
}
