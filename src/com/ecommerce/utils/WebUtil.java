package com.ecommerce.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

/**
 * @author HERO
 * @date 2016年1月17日
 */
public class WebUtil {

	/*
	 * 将request中的数据封装到对应的form中
	 */
	public static <T> T requestToBean(HttpServletRequest request,Class<T> beanClass){
		
		try {
			T bean = beanClass.newInstance();
			
			Enumeration e = request.getParameterNames();
			while(e.hasMoreElements()){
				String name = (String) e.nextElement();
				String values = request.getParameter(name);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}
