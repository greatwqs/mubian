/**
 * 
 */
package com.greatwqs.mubian.utils;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;

/**
 * @author greatwqs
 *
 */
public class PublicUtils {
	
	/***
	 * 取得从客户端浏览器过来的UTF-8编码的字符串
	 * @param str
	 * @return
	 */
	public static String getFormTextUTF8(String str){
		try {
			return new String (str.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	/***
	 * 判断是否为数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){
		if(str==null || str.trim().length()==0){
			return false;
		}
		return StringUtils.isNumeric(str);
	}
	
	/**
	 * 如果str为null,进行处理返回.
	 * @param str
	 * @return
	 */
	public static String getBlankIfNull(String str){
		if(str==null || str.trim().length()==0){
			return "";
		}
		return str.trim();
	}
	
}
