package com.liberarysystem.util;
/**
 * �Զ���Request�࣬����Java web ������HttpServletRequest.�����ģ������֮��Ĵ�ֵ����
 */
import java.io.Serializable;
/**
 * ģ��Java web�����е�HttpServletRequest��ʵ�ֽ���֮�����Ϣ���ݹ���
 */
import java.util.HashMap;
import java.util.Map;

public class MyRequest  {
	/**
	 * ��map�ķ�ʽ��Ž���֮��Ҫ���ݵĲ�����������Java web�����е�HttpServletRequest
	 */
	private static Map<String, Object> request = new HashMap<String, Object>();
	// ��ù�ϣͼ��key��Ӧ�Ķ���ֵ��
	public Object getAttribute(String key) {
		Object obj = request.get(key);
		return obj;
	}
	/**
	 * ����ϣͼ������µļ�ֵ�����ݣ�������ظ���key����������
	 * @param key
	 * @param value
	 */
	public void setAttribute(String key, Object value) {
		request.put(key, value);
	}
}
