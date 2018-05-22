/**
 * 
 */
package com.greatwqs.mubian.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author greatwqs
 *
 */
public class DateUtils {
	
	/**
	 * 默认使用
	 */
	public static final DateFormat DATEFORMAT_DEFAULT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 供图片保存使用,用于作为文件名称.
	 */
	public static final DateFormat DATEFORMAT_IMAGES  = new SimpleDateFormat("yyyyMMddHHmmss");
	
	public static String getFormatedDate(Date date){
		return DATEFORMAT_DEFAULT.format(date);
	}
	
	public static String getFormatedDate(){
		return getFormatedDate(new Date());
	}
	
	public static int getYear(){
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR);
	}
	
	/***
	 * 用于上传图片时,图片的文件名称之用.
	 * @return
	 */
	public static String getImageNameDate(){
		return DATEFORMAT_IMAGES.format(new Date());
	}
	
	public static void main(String[] fds){
		System.out.println(getImageNameDate());
	}

}
