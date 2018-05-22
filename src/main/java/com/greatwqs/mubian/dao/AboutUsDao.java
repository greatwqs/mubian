package com.greatwqs.mubian.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.greatwqs.mubian.bean.AboutUsBean;
import com.greatwqs.mubian.conn.MySqlConnection;
import com.greatwqs.mubian.utils.DateUtils;

/**
 * 
 * 数据库mubian.mubian_aboutus 对应的dao.
 * @author greatwqs
 *
 */
public class AboutUsDao {
	
	public static final String SQL_EXISTS = "SELECT COUNT(ID) AS TOTALCOUNT FROM MuBian_aboutus WHERE TYPE=";
	public static final String SQL_QUERY  = "SELECT ID,TYPE,TITLE,CONTENT,UPDATETIME,CREATETIME FROM MuBian_aboutus WHERE TYPE=";
	public static final String SQL_INSERT = "INSERT INTO MuBian_aboutus(TYPE,TITLE,CONTENT,UPDATETIME,CREATETIME) VALUES (#TYPE#,#TITLE#,#CONTENT#,#UPDATETIME#,#CREATETIME#)";
	public static final String SQL_UPDATE = "UPDATE MuBian_aboutus SET CONTENT=#CONTENT#,UPDATETIME=#UPDATETIME# WHERE TYPE=";
	
	public static boolean isExistType(int type) throws SQLException{
		boolean flag = false;
		MySqlConnection connInit = new MySqlConnection();
		ResultSet result = connInit.getQuery(SQL_EXISTS+type);
		if(result.next()){
			int totalcount = result.getInt("TOTALCOUNT");
			if(totalcount > 0){
				flag = true;
			} else {
				flag = false;
			}
		}
		result.close();
		connInit.relaseConnection();
		return flag;
	}
	
	public static AboutUsBean getAboutUSBean(int type) throws SQLException{
		MySqlConnection connInit = new MySqlConnection();
		AboutUsBean bean = new AboutUsBean();
		ResultSet result = connInit.getQuery(SQL_QUERY+type);
		if(result.next()){
			bean.setId(result.getInt("ID"));
			bean.setType(result.getInt("TYPE"));
			bean.setTitle(result.getString("TITLE"));
			bean.setContent(result.getString("CONTENT"));
			bean.setUpdatetime(result.getString("UPDATETIME"));
			bean.setCreatetime(result.getString("CREATETIME"));
		}
		result.close();
		connInit.relaseConnection();
		return bean;
	}

	public static void insert(AboutUsBean bean) throws SQLException{
		if (bean==null){
			return;
		}
		boolean flag = isExistType(bean.getType());
		if(flag){
			return;
		}
		MySqlConnection connInit = new MySqlConnection();
		String sql = SQL_INSERT.replace("#TYPE#", String.valueOf(bean.getType()))
							.replace("#TITLE#", "'"+bean.getTitle()+"'")
							.replace("#CONTENT#", "'"+bean.getContent()+"'")
							.replace("#UPDATETIME#", "'"+bean.getContent()+"'")
							.replace("#CREATETIME#", "'"+bean.getCreatetime()+"'");
		connInit.executeUpdate(sql);
		connInit.relaseConnection();
	}
	
	public static void update(AboutUsBean bean) throws SQLException{
		if (bean==null){
			return;
		}
		boolean flag = isExistType(bean.getType());
		if(!flag){
			return;
		}
		MySqlConnection connInit = new MySqlConnection();
		// "UPDATE MuBian_aboutus SET CONTENT=#CONTENT#,UPDATETIME=#UPDATETIME# WHERE TYPE=";
		String sql = SQL_UPDATE.replace("#TITLE#","'"+ bean.getTitle()+"'")
							.replace("#CONTENT#","'"+ bean.getContent()+"'")
							.replace("#UPDATETIME#","'"+ DateUtils.getFormatedDate()+"'");
		sql = sql + bean.getType();
		connInit.executeUpdate(sql);
		connInit.relaseConnection();
	}
	
}
