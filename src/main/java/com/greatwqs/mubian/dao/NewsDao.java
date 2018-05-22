package com.greatwqs.mubian.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.greatwqs.mubian.bean.NewsBean;
import com.greatwqs.mubian.bean.ItemsPage;
import com.greatwqs.mubian.conn.MySqlConnection;
import com.greatwqs.mubian.utils.DateUtils;

/**
 * 
 * 数据库mubian.mubian_news 对应的dao.
 * @author greatwqs
 *
 */
public class NewsDao {
	
	public static final String SQL_QUERY_ALL_COUNT = "SELECT COUNT(ID) AS TOTALCOUNT FROM MuBian_news";
	public static final String SQL_EXISTS_BY_ID    = "SELECT COUNT(ID) AS TOTALCOUNT FROM MuBian_news WHERE ID=";
	public static final String SQL_QUERY_BY_ID     = "SELECT ID,TYPE,TITLE,CONTENT,UPDATETIME,CREATETIME FROM MuBian_news WHERE ID=";
	public static final String SQL_QUERY_TOP3_NEWS = "SELECT ID,TITLE FROM MuBian_news ORDER BY CREATETIME DESC LIMIT 3";
	public static final String SQL_PAGE_QUERY      = "SELECT ID,TITLE,CREATETIME FROM MuBian_news ORDER BY CREATETIME DESC LIMIT #PAGESx20#,#PAGE_SIZE#";
	public static final String SQL_INSERT          = "INSERT INTO MuBian_news(TYPE,TITLE,CONTENT,UPDATETIME,CREATETIME) VALUES (#TYPE#,#TITLE#,#CONTENT#,#UPDATETIME#,#CREATETIME#)";
	public static final String SQL_UPDATE_BY_ID    = "UPDATE MuBian_news SET TYPE=#TYPE#,TITLE=#TITLE#,CONTENT=#CONTENT#,UPDATETIME=#UPDATETIME# WHERE ID=";
	public static final String SQL_DELETE_BY_ID    = "DELETE FROM MuBian_news WHERE ID=";
	
	/**
	 * 通过主键ID获取新闻的全部内容
	 * @param ID
	 * @return
	 * @throws Exception 
	 */
	public static List<NewsBean> getThreeTopeNews() throws Exception{
		List<NewsBean> newsList = new ArrayList<NewsBean>();
		MySqlConnection connInit = new MySqlConnection();
		ResultSet result = connInit.getQuery(SQL_QUERY_TOP3_NEWS);
		while(result.next()){
			// ID,TITLE
			NewsBean bean = new NewsBean();
			bean.setId(result.getInt("ID"));
			bean.setTitle(result.getString("TITLE"));
			newsList.add(bean);
		}
		result.close();
		connInit.relaseConnection();
		return newsList;
	}
	
	/**
	 * 通过主键ID获取新闻的全部内容
	 * @param ID
	 * @return
	 * @throws Exception 
	 */
	public static ItemsPage getPageNews(int pageIndex) throws Exception{
		int totalCount = getTotalCount();
		ItemsPage pageData = new ItemsPage(ItemsPage.NEWS_PAGE_SIZE,totalCount);
		int OKPageIndex = pageData.setAndGetCurrentPage(pageIndex);
		MySqlConnection connInit = new MySqlConnection();
		String sql = SQL_PAGE_QUERY.replace("#PAGESx20#", String.valueOf((OKPageIndex-1)*ItemsPage.NEWS_PAGE_SIZE))
								   .replace("#PAGE_SIZE#", String.valueOf(ItemsPage.NEWS_PAGE_SIZE));
		List<NewsBean> newsList = new ArrayList<NewsBean>(ItemsPage.NEWS_PAGE_SIZE);
		ResultSet result = connInit.getQuery(sql);
		while(result.next()){
			// ID,TITLE,CREATETIME
			NewsBean bean = new NewsBean();
			bean.setId(result.getInt("ID"));
			bean.setTitle(result.getString("TITLE"));
			bean.setCreatetime(result.getString("CREATETIME"));
			newsList.add(bean);
		}
		pageData.setItemsList(newsList);
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
	
	/**
	 * 通过主键ID获取新闻的全部内容
	 * @param ID
	 * @return
	 * @throws SQLException
	 */
	public static NewsBean getNewsBean(int ID) throws SQLException{
		MySqlConnection connInit = new MySqlConnection();
		NewsBean bean = null;
		ResultSet result = connInit.getQuery(SQL_QUERY_BY_ID+ID);
		if(result.next()){
			// ID,TYPE,TITLE,CONTENT,UPDATETIME,CREATETIME
			bean = new NewsBean();
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

	/***
	 * 插入一条新闻信息.
	 * @param bean
	 * @throws SQLException
	 */
	public static void insert(NewsBean bean) throws SQLException{
		if (bean==null){
			return;
		}
		MySqlConnection connInit = new MySqlConnection();
		// #TYPE#,#TITLE#,#CONTENT#,#UPDATETIME#,#CREATETIME#
		String sql = SQL_INSERT.replace("#TYPE#", String.valueOf(bean.getType()))
							.replace("#TITLE#", "'"+bean.getTitle()+"'")
							.replace("#CONTENT#", "'"+bean.getContent()+"'")
							.replace("#UPDATETIME#", "'"+DateUtils.getFormatedDate()+"'")
							.replace("#CREATETIME#", "'"+DateUtils.getFormatedDate()+"'");
		connInit.executeUpdate(sql);
		connInit.relaseConnection();
	}
	
	/***
	 * 更新一条新闻信息
	 * @param bean
	 * @throws SQLException
	 */
	public static void update(NewsBean bean) throws SQLException{
		if (bean==null){
			return;
		}
		boolean flag = isExist(bean.getId());
		if(!flag){
			return;
		}
		MySqlConnection connInit = new MySqlConnection();
		// TYPE=#TYPE#,TITLE=#TITLE#,CONTENT=#CONTENT#,UPDATETIME=#UPDATETIME#
		String sql = SQL_UPDATE_BY_ID.replace("#TYPE#",String.valueOf(bean.getType()))
							.replace("#TITLE#","'"+ bean.getTitle()+"'")
							.replace("#CONTENT#","'"+ bean.getContent()+"'")
							.replace("#UPDATETIME#","'"+ DateUtils.getFormatedDate()+"'");
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
