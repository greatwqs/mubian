package com.greatwqs.mubian.test;

import com.greatwqs.mubian.utils.MD5Utils;

public class Md5CodeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MD5Utils md5 = new MD5Utils();
		String password = "greatwqs";
		String encodePassword = md5.getMD5(password);
		System.out.println(encodePassword);
	}

}
