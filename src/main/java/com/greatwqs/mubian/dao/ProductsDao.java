package com.greatwqs.mubian.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.greatwqs.mubian.bean.ItemsPage;
import com.greatwqs.mubian.bean.ProductBean;
import com.greatwqs.mubian.conn.MySqlConnection;
import com.greatwqs.mubian.utils.DateUtils;

/**
 * 
 * 数据库mubian.mubian_products 对应的dao.
 * @author greatwqs
 *
 */
public class ProductsDao {
	
	public static final String SQL_QUERY_ALL_COUNT      = "SELECT COUNT(ID) AS TOTALCOUNT FROM MuBian_products";
	public static final String SQL_QUERY_TYPE_ALL_COUNT = "SELECT COUNT(ID) AS TOTALCOUNT FROM MuBian_products WHERE TYPE=";
	public static final String SQL_EXISTS_BY_ID         = "SELECT COUNT(ID) AS TOTALCOUNT FROM MuBian_products WHERE ID=";
	public static final String SQL_QUERY_BY_ID          = "SELECT PRODUCT.ID,PRODUCT.TYPE,PRODUCT.TITLE,PRODUCT.PICTUREADDRESS,PRODUCT.CONTENT,PRODUCT.UPDATETIME,PRODUCT.CREATETIME,PRODUCT.INDEXWIDTH,PRODUCT.INDEXHEIGHT,PTYPE.TYPENAME " +
				                                          "FROM MuBian_products AS PRODUCT INNER JOIN MuBian_products_type AS PTYPE " +
				                                          "ON PRODUCT.TYPE=PTYPE.ID " +
				                                          "WHERE PRODUCT.ID=";
	public static final String SQL_PAGE_QUERY           = "SELECT ID,TYPE,TITLE,PICTUREADDRESS,CONTENT,UPDATETIME,CREATETIME FROM MuBian_products ORDER BY CREATETIME DESC LIMIT #PAGESx12#,#PAGE_SIZE#";
	public static final String SQL_TYPE_PAGE_QUERY      = "SELECT ID,TYPE,TITLE,PICTUREADDRESS,CONTENT,UPDATETIME,CREATETIME FROM MuBian_products WHERE TYPE=#TYPE# ORDER BY CREATETIME DESC LIMIT #PAGESx12#,#PAGE_SIZE#";
	public static final String SQL_AJAX_PAGE_QUERY      = "SELECT ID,TYPE,TITLE,PICTUREADDRESS,CONTENT,UPDATETIME,CREATETIME,INDEXWIDTH,INDEXHEIGHT FROM MuBian_products ORDER BY CREATETIME DESC LIMIT #PAGESx4#,#PAGE_SIZE#";
	public static final String SQL_INSERT               = "INSERT INTO MuBian_products(TYPE,TITLE,PICTUREADDRESS,CONTENT,UPDATETIME,CREATETIME,INDEXWIDTH,INDEXHEIGHT) VALUES (#TYPE#,#TITLE#,#PICTUREADDRESS#,#CONTENT#,#UPDATETIME#,#CREATETIME#,#INDEXWIDTH#,#INDEXHEIGHT#)";
	public static final String SQL_UPDATE_BY_ID         = "UPDATE MuBian_products SET TYPE=#TYPE#,TITLE=#TITLE#,PICTUREADDRESS=#PICTUREADDRESS#,CONTENT=#CONTENT#,UPDATETIME=#UPDATETIME#,INDEXWIDTH=#INDEXWIDTH#,INDEXHEIGHT=#INDEXHEIGHT# WHERE ID=";
	public static final String SQL_DELETE_BY_ID         = "DELETE FROM MuBian_products WHERE ID=";
	public static final String SQL_QUERY_MAX_ID         = "SELECT MAX(ID) AS MAXID FROM MuBian_products";
	
	/**
	 * 全部产品的分页数据
	 * @param pageIndex
	 * @return
	 * @throws Exception
	 */
	public static ItemsPage getPageProducts(int pageIndex) throws Exception{
		int totalCount = getTotalCount();
		ItemsPage pageData = new ItemsPage(ItemsPage.PRODUCTS_PAGE_SIZE,totalCount);
		int OKPageIndex = pageData.setAndGetCurrentPage(pageIndex);
		MySqlConnection connInit = new MySqlConnection();
		String sql = SQL_PAGE_QUERY.replace("#PAGESx12#", String.valueOf((OKPageIndex-1)*ItemsPage.PRODUCTS_PAGE_SIZE))
								   .replace("#PAGE_SIZE#", String.valueOf(ItemsPage.PRODUCTS_PAGE_SIZE));
		List<ProductBean> productsList = new ArrayList<ProductBean>(ItemsPage.PRODUCTS_PAGE_SIZE);
		ResultSet result = connInit.getQuery(sql);
		while(result.next()){
			// ID,TYPE,TITLE,PICTUREADDRESS,CONTENT,UPDATETIME,CREATETIME
			ProductBean bean = new ProductBean();
			bean.setId(result.getInt("ID"));
			bean.setTitle(result.getString("TITLE"));
			bean.setPictureAddress(result.getString("PICTUREADDRESS"));
			bean.setType(result.getInt("TYPE"));
			bean.setCreatetime(result.getString("CREATETIME"));
			productsList.add(bean);
		}
		pageData.setItemsList(productsList);
		result.close();
		connInit.relaseConnection();
		return pageData;
	}
	
	/**
	 * 分页获取此类型的分页数据
	 * @param pageIndex
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public static ItemsPage getTypePageProducts(int pageIndex, int type) throws Exception{
		int totalCount = getTypeTotalCount(type);
		ItemsPage pageData = new ItemsPage(ItemsPage.PRODUCTS_PAGE_SIZE,totalCount);
		int OKPageIndex = pageData.setAndGetCurrentPage(pageIndex);
		MySqlConnection connInit = new MySqlConnection();
		String sql = SQL_TYPE_PAGE_QUERY.replace("#TYPE#", String.valueOf(type))
		                                .replace("#PAGESx12#", String.valueOf((OKPageIndex-1)*ItemsPage.PRODUCTS_PAGE_SIZE))
								        .replace("#PAGE_SIZE#", String.valueOf(ItemsPage.PRODUCTS_PAGE_SIZE));
		List<ProductBean> productsList = new ArrayList<ProductBean>(ItemsPage.PRODUCTS_PAGE_SIZE);
		ResultSet result = connInit.getQuery(sql);
		while(result.next()){
			// ID,TITLE,PICTUREADDRESS
			ProductBean bean = new ProductBean();
			bean.setId(result.getInt("ID"));
			bean.setTitle(result.getString("TITLE"));
			bean.setPictureAddress(result.getString("PICTUREADDRESS"));
			bean.setType(result.getInt("TYPE"));
			bean.setCreatetime(result.getString("CREATETIME"));
			productsList.add(bean);
		}
		pageData.setItemsList(productsList);
		result.close();
		connInit.relaseConnection();
		return pageData;
	}
	
	/**
	 * 分页获取此类型的分页数据
	 * @param pageIndex
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public static ItemsPage getIndexAjaxPageProducts(int pageIndex) throws Exception{
		int totalCount = getTotalCount();
		ItemsPage pageData = new ItemsPage(ItemsPage.INDEX_AJAX_PAGE_SIZE,totalCount);
		int OKPageIndex = pageData.setAndGetCurrentPage(pageIndex);
		MySqlConnection connInit = new MySqlConnection();
		// ORDER BY CREATETIME DESC LIMIT #PAGESx4#,#PAGE_SIZE#";
		String sql = SQL_AJAX_PAGE_QUERY.replace("#PAGESx4#", String.valueOf((OKPageIndex-1)*ItemsPage.INDEX_AJAX_PAGE_SIZE))
								       .replace("#PAGE_SIZE#", String.valueOf(ItemsPage.INDEX_AJAX_PAGE_SIZE));
		List<ProductBean> productsList = new ArrayList<ProductBean>(ItemsPage.INDEX_AJAX_PAGE_SIZE);
		ResultSet result = connInit.getQuery(sql);
		while(result.next()){
			// ID,TITLE,PICTUREADDRESS,INDEXWIDTH,INDEXHEIGHT
			ProductBean bean = new ProductBean();
			bean.setId(result.getInt("ID"));
			bean.setTitle(result.getString("TITLE"));
			bean.setPictureAddress(result.getString("PICTUREADDRESS"));
			bean.setType(result.getInt("TYPE"));
			bean.setCreatetime(result.getString("CREATETIME"));
			bean.setIndexHeight(result.getInt("INDEXHEIGHT"));
			bean.setIndexWidth(result.getInt("INDEXWIDTH"));
			productsList.add(bean);
		}
		pageData.setItemsList(productsList);
		result.close();
		connInit.relaseConnection();
		return pageData;
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
	
	public static int getMaxID() throws Exception{
		int maxid = 0;
		MySqlConnection connInit = new MySqlConnection();
		ResultSet result = connInit.getQuery(SQL_QUERY_MAX_ID);
		if(result.next()){
			maxid = result.getInt("MAXID");
		}
		result.close();
		connInit.relaseConnection();
		return maxid;
	}
	
	public static int getTypeTotalCount(int type) throws Exception{
		int totalCount = 0;
		MySqlConnection connInit = new MySqlConnection();
		ResultSet result = connInit.getQuery(SQL_QUERY_TYPE_ALL_COUNT+type);
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
	public static ProductBean getProductBean(int ID) throws SQLException{
		ProductBean bean = null;
		MySqlConnection connInit = new MySqlConnection();
		ResultSet result = connInit.getQuery(SQL_QUERY_BY_ID+ID);
		if(result.next()){
			// PRODUCT.ID,PRODUCT.TYPE,PRODUCT.TITLE,PRODUCT.PICTUREADDRESS,PRODUCT.CONTENT,PRODUCT.UPDATETIME,PRODUCT.CREATETIME,PTYPE.TYPENAME
			bean = new ProductBean();
			bean.setId(result.getInt("ID"));
			bean.setType(result.getInt("TYPE"));
			bean.setTitle(result.getString("TITLE"));
			bean.setPictureAddress(result.getString("PICTUREADDRESS"));
			bean.setContent(result.getString("CONTENT"));
			bean.setUpdatetime(result.getString("UPDATETIME"));
			bean.setCreatetime(result.getString("CREATETIME"));
			bean.setTypeName(result.getString("TYPENAME"));
			bean.setIndexHeight(result.getInt("INDEXHEIGHT"));
			bean.setIndexWidth(result.getInt("INDEXWIDTH"));
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
	public static void insert(ProductBean bean) throws SQLException{
		if (bean==null){
			return;
		}
		MySqlConnection connInit = new MySqlConnection();
		// #TYPE#,#TITLE#,#PICTUREADDRESS#,#CONTENT#,#UPDATETIME#,#CREATETIME#
		String sql = SQL_INSERT.replace("#TYPE#", String.valueOf(bean.getType()))
							.replace("#TITLE#", "'"+bean.getTitle()+"'")
							.replace("#PICTUREADDRESS#", "'"+bean.getPictureAddress()+"'")
							.replace("#CONTENT#", "'"+bean.getContent()+"'")
							.replace("#UPDATETIME#", "'"+DateUtils.getFormatedDate()+"'")
							.replace("#CREATETIME#", "'"+DateUtils.getFormatedDate()+"'")
							.replace("#INDEXWIDTH#",""+bean.getIndexWidth())
							.replace("#INDEXHEIGHT#",""+bean.getIndexHeight());
		connInit.executeUpdate(sql);
		connInit.relaseConnection();
	}
	
	/***
	 * 更新一条新闻信息
	 * @param bean
	 * @throws SQLException
	 */
	public static void update(ProductBean bean) throws SQLException{
		if (bean==null){
			return;
		}
		boolean flag = isExist(bean.getId());
		if(!flag){
			return;
		}
		MySqlConnection connInit = new MySqlConnection();
		// TYPE=#TYPE#,TITLE=#TITLE#,PICTUREADDRESS=#PICTUREADDRESS#,CONTENT=#CONTENT#,UPDATETIME=#UPDATETIME#,INDEXWIDTH=#INDEXWIDTH#,INDEXHEIGHT=#INDEXHEIGHT#
		String sql = SQL_UPDATE_BY_ID.replace("#TYPE#", String.valueOf(bean.getType()))
							.replace("#TITLE#","'"+ bean.getTitle()+"'")
							.replace("#PICTUREADDRESS#","'"+ bean.getPictureAddress()+"'")
							.replace("#CONTENT#","'"+ bean.getContent()+"'")
							.replace("#UPDATETIME#","'"+ DateUtils.getFormatedDate()+"'")
							.replace("#INDEXWIDTH#",""+bean.getIndexWidth())
							.replace("#INDEXHEIGHT#",""+bean.getIndexHeight());
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
	 * 判断此ID的新闻是否存在.
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
	
}
