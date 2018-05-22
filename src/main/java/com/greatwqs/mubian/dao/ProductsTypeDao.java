package com.greatwqs.mubian.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.greatwqs.mubian.bean.ProductsTypeBean;
import com.greatwqs.mubian.conn.MySqlConnection;

/**
 * 
 * 数据库mubian.mubian_products 对应的dao.
 * @author greatwqs
 *
 */
public class ProductsTypeDao {
	
	public static final String SQL_QUERY_ALL       = "SELECT ID,TYPENAME,PICTURE FROM MuBian_products_type ORDER BY PRIORITY DESC";
	public static final String SQL_QUERY_ALL_COUNT = "SELECT COUNT(ID) AS TOTALCOUNT FROM MuBian_products_type";
	public static final String SQL_EXISTS_BY_ID    = "SELECT COUNT(ID) AS TOTALCOUNT FROM MuBian_products_type WHERE ID=";
	public static final String SQL_QUERY_BY_ID     = "SELECT ID,TYPENAME,PRIORITY,CONTENT,UPDATETIME,CREATETIME FROM MuBian_products_type WHERE ID=";
	public static final String SQL_INSERT          = "INSERT INTO MuBian_products_type(TYPENAME,PRIORITY,CONTENT,UPDATETIME,CREATETIME) VALUES (#TYPENAME#,#PRIORITY#,#CONTENT#,#UPDATETIME#,#CREATETIME#)";
	public static final String SQL_UPDATE_BY_ID    = "UPDATE MuBian_products_type SET TYPENAME=#TYPENAME#,PRIORITY=#PRIORITY#,CONTENT=#CONTENT#,UPDATETIME=#UPDATETIME# WHERE ID=";
	public static final String SQL_DELETE_BY_ID    = "DELETE FROM MuBian_products_type WHERE ID=";
	public static final String SQL_QUERY_LISTVIEW  = "SELECT ID,TYPENAME,WIDTH,HEIGHT FROM MuBian_products_type  WHERE ID=";
	
	/***
	 * 按照优先级查询出全部的种类.
	 * @return
	 * @throws Exception
	 */
	public static List<ProductsTypeBean> getAllProductsType() throws Exception{
		List<ProductsTypeBean> beanList = new ArrayList<ProductsTypeBean>();
		MySqlConnection connInit = new MySqlConnection();
		ResultSet result = connInit.getQuery(SQL_QUERY_ALL);
		while(result.next()){
			// ID,TYPENAME
			ProductsTypeBean bean = new ProductsTypeBean();
			bean.setId(result.getInt("ID"));
			bean.setTypeName(result.getString("TYPENAME"));
			bean.setPicture(result.getString("PICTURE"));
			beanList.add(bean);
		}
		result.close();
		connInit.relaseConnection();
		return beanList;
	}
	
	public static int getTotalCount() throws Exception{
		int totalCount = 0;
		MySqlConnection connInit = new MySqlConnection();
		ResultSet result = connInit.getQuery(SQL_QUERY_ALL_COUNT);
		if(result.next()){
			totalCount = result.getInt("TOTALCOUNT");
		}
		result.close();
		connInit.relaseConnection();
		return totalCount;
	}
	
	/**
	 * 通过主键ID获取新闻的全部内容
	 * @param ID
	 * @return
	 * @throws SQLException
	 */
	public static ProductsTypeBean getProductsTypeBean(int ID) throws SQLException{
		MySqlConnection connInit = new MySqlConnection();
		ProductsTypeBean bean = null;
		ResultSet result = connInit.getQuery(SQL_QUERY_BY_ID+ID);
		if(result.next()){
			// ID,TYPENAME,PRIORITY,CONTENT,UPDATETIME,CREATETIME
			bean = new ProductsTypeBean();
			bean.setId(result.getInt("ID"));
			bean.setPriority(result.getInt("PRIORITY"));
			bean.setTypeName(result.getString("TYPENAME"));
			bean.setContent(result.getString("CONTENT"));
			bean.setUpdateTime(result.getString("UPDATETIME"));
			bean.setCreateTime(result.getString("CREATETIME"));
		}
		result.close();
		connInit.relaseConnection();
		return bean;
	}

	/***
	 * 插入一条新闻信息.
	 * @param bean
	 * @throws SQLException
	 */
	public static void insert(ProductsTypeBean bean) throws SQLException{
		if (bean==null){
			return;
		}
		MySqlConnection connInit = new MySqlConnection();
		// TYPENAME,PRIORITY,CONTENT,UPDATETIME,CREATETIME
		String sql = SQL_INSERT.replace("#TYPENAME#", "'"+bean.getTypeName()+"'")
							.replace("#PRIORITY#",  String.valueOf(bean.getPriority()))
							.replace("#CONTENT#", "'"+bean.getContent()+"'")
							.replace("#UPDATETIME#", "'"+bean.getUpdateTime()+"'")
							.replace("#CREATETIME#", "'"+bean.getCreateTime()+"'");
		connInit.executeUpdate(sql);
		connInit.relaseConnection();
	}
	
	/***
	 * 更新一条新闻信息
	 * @param bean
	 * @throws SQLException
	 */
	public static void update(ProductsTypeBean bean) throws SQLException{
		if (bean==null){
			return;
		}
		boolean flag = isExist(bean.getId());
		if(!flag){
			return;
		}
		MySqlConnection connInit = new MySqlConnection();
		// TYPENAME=#TYPENAME#,PRIORITY=#PRIORITY#,CONTENT=#CONTENT#,UPDATETIME=#UPDATETIME#
		String sql = SQL_UPDATE_BY_ID.replace("#TYPENAME#","'"+ bean.getTypeName()+"'")
							.replace("#PRIORITY#",String.valueOf(bean.getPriority()))
							.replace("#CONTENT#","'"+String.valueOf(bean.getContent())+"'")
							.replace("#UPDATETIME#","'"+ bean.getUpdateTime()+"'");
		sql = sql + bean.getId();
		connInit.executeUpdate(sql);
		connInit.relaseConnection();
	}
	
	/***
	 * 删除一条新闻信息
	 * @param bean
	 * @throws SQLException
	 */
	public static void delete(int id) throws SQLException{
		MySqlConnection connInit = new MySqlConnection();
		String sql = SQL_DELETE_BY_ID + id;
		connInit.executeUpdate(sql);
		connInit.relaseConnection();
	}
	
	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public static boolean isExist(int id) throws SQLException{
		boolean flag = false;
		MySqlConnection connInit = new MySqlConnection();
		ResultSet result = connInit.getQuery(SQL_EXISTS_BY_ID+id);
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
	
	/**
	 * 得到产品列表每个产品图片的高度和宽度;
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public static ProductsTypeBean getProductsTypeViewBean(int id) throws SQLException{
		ProductsTypeBean bean = new ProductsTypeBean();
		MySqlConnection connInit = new MySqlConnection();
		ResultSet result = connInit.getQuery(SQL_QUERY_LISTVIEW+id);
		if(result.next()){
			int ID = result.getInt("ID");
			bean.setId(ID);
			String TYPENAME = result.getString("TYPENAME");
			bean.setTypeName(TYPENAME);
			int WIDTH = result.getInt("WIDTH");
			bean.setWidth(WIDTH);
			int HEIGHT = result.getInt("HEIGHT");
			bean.setHeight(HEIGHT);
		} else {
			bean.setTypeName("全部系列");
			bean.setWidth(174);
			bean.setHeight(150);
		}
		result.close();
		connInit.relaseConnection();
		return bean;
	}
}
