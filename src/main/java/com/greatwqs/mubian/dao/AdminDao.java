package com.greatwqs.mubian.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.greatwqs.mubian.bean.AdminBean;
import com.greatwqs.mubian.conn.MySqlConnection;
import com.greatwqs.mubian.utils.DateUtils;
import com.greatwqs.mubian.utils.MD5Utils;
import com.greatwqs.mubian.utils.PublicUtils;

/***
 * 
 * @author greatwqs
 *
 */
public class AdminDao {
	
	public static final String SQL_LOGIN_BY_AUTH     = "SELECT COUNT(ID) AS TOTALCOUNT FROM MuBian_admin WHERE USERNAME=#USERNAME# AND PASSWORD=#PASSWORD#";
	public static final String SQL_QUERY_BY_USERNAME = "SELECT ID,USERNAME,LOGINTIME,UPDATETIME,CREATETIME FROM MuBian_admin WHERE USERNAME=#USERNAME#";
	public static final String SQL_UPDATE_LOGINTIME  = "UPDATE MuBian_admin SET LOGINTIME=#LOGINTIME# WHERE USERNAME=#USERNAME#";
	public static final String SQL_QUERY_LOGINTIME   = "SELECT LOGINTIME FROM MuBian_admin WHERE USERNAME=#USERNAME#";
	public static final String SQL_UPDATE_PASSWORD   = "UPDATE MuBian_admin SET PASSWORD=#NEWPASSWORD#,UPDATETIME=#UPDATETIME# WHERE USERNAME=#USERNAME# AND PASSWORD=#OLDPASSWORD#";
	
	/**
	 * 检查用户名和密码配对的是否能进行登陆.
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static boolean isLogin(String username, String password) throws Exception{
		if(username==null || username.trim().length()==0 
				|| password==null || password.trim().length()==0 ){
			return false;
		}
		boolean flag = false;
		MD5Utils md5 = new MD5Utils();
		String encodePassword = md5.getMD5(password);
		MySqlConnection connInit = new MySqlConnection();
		String sql = SQL_LOGIN_BY_AUTH.replace("#USERNAME#", "'"+username+"'")
		                              .replace("#PASSWORD#", "'"+encodePassword+"'");
		ResultSet result = connInit.getQuery(sql);
		if(result.next()){
			int totalCount = result.getInt("TOTALCOUNT");
			if(totalCount == 1){
				flag = true;
			}
		}
		result.close();
		connInit.relaseConnection();
		return flag;
	}
	
	/**
	 * getAdminBean
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public static AdminBean getAdminBean(String username) throws SQLException{
		if(username==null || username.trim().length()==0){
			return null;
		}
		MySqlConnection connInit = new MySqlConnection();
		AdminBean bean = null;
		String sql = SQL_QUERY_BY_USERNAME.replace("#USERNAME#", "'"+username+"'");
		ResultSet result = connInit.getQuery(sql);
		if(result.next()){
			// ID,USERNAME,LOGINTIME,UPDATETIME,CREATETIME
			bean = new AdminBean();
			bean.setId(result.getInt("ID"));
			bean.setUsername(result.getString("USERNAME"));
			bean.setLoginTime(result.getString("LOGINTIME"));
			bean.setUpdateTime(result.getString("UPDATETIME"));
			bean.setCreateTime(result.getString("CREATETIME"));
		}
		result.close();
		connInit.relaseConnection();
		return bean;
	}

	/***
	 * updatePassword
	 * @param bean
	 * @throws SQLException
	 */
	public static void updatePassword(String username, String oldPassword, String newPassword) throws SQLException{
		if (username==null || username.trim().length()==0
				|| oldPassword==null || oldPassword.trim().length()==0
				|| newPassword==null || newPassword.trim().length()==0){
			return;
		}
		
		MySqlConnection connInit = new MySqlConnection();
		MD5Utils md5 = new MD5Utils();
		// PASSWORD=#NEWPASSWORD#,UPDATETIME=#UPDATETIME# WHERE USERNAME=#USERNAME# AND PASSWORD=#OLDPASSWORD#";
		String sql = SQL_UPDATE_PASSWORD.replace("#NEWPASSWORD#","'"+md5.getMD5(newPassword.trim())+"'")
							.replace("#UPDATETIME#","'"+ DateUtils.getFormatedDate()+"'")
							.replace("#USERNAME#","'"+ username.trim()+"'")
							.replace("#OLDPASSWORD#","'"+ md5.getMD5(oldPassword.trim())+"'");
		connInit.executeUpdate(sql);
		connInit.relaseConnection();
	}
	
	/***
	 * updateLoginTime
	 * @param bean
	 * @throws SQLException
	 */
	public static String getLoginTime(String username) throws SQLException{
		if(username==null || username.trim().length()==0){
			return null;
		}
		String loginTime = null;
		MySqlConnection connInit = new MySqlConnection();
		// LOGINTIME=#LOGINTIME# WHERE USERNAME=#USERNAME#
		String sql = SQL_QUERY_LOGINTIME.replace("#USERNAME#","'"+ username.trim()+"'");
		ResultSet result = connInit.getQuery(sql);
		if(result.next()){
			loginTime=PublicUtils.getBlankIfNull(result.getString("LOGINTIME"));
		}
		result.close();
		connInit.relaseConnection();
		return loginTime;
	}
	
	/***
	 * updateLoginTime
	 * @param bean
	 * @throws SQLException
	 */
	public static void updateLoginTime(String username) throws SQLException{
		if(username==null || username.trim().length()==0){
			return;
		}
		MySqlConnection connInit = new MySqlConnection();
		// LOGINTIME=#LOGINTIME# WHERE USERNAME=#USERNAME#
		String sql = SQL_UPDATE_LOGINTIME.replace("#LOGINTIME#","'"+DateUtils.getFormatedDate()+"'")
							.replace("#USERNAME#","'"+ username.trim()+"'");
		connInit.executeUpdate(sql);
		connInit.relaseConnection();
	}

}
