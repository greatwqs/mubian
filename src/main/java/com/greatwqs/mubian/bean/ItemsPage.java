package com.greatwqs.mubian.bean;

import java.util.ArrayList;
import java.util.List;

import com.greatwqs.mubian.conn.MySqlConnection;

/***
 * 
 * 针对分页使用的Bean
 * 
 * @author greatwqs
 *
 */
public class ItemsPage {

	public static final int NEWS_PAGE_SIZE       = 20;
	public static final int PRODUCTS_PAGE_SIZE   = 12;
	public static final int INDEX_AJAX_PAGE_SIZE = 4;

	/**
	 * 一页条目的大小,对象初始化时确定;
	 * 一般为NEWS_PAGE_SIZE,NEWS_PAGE_SIZE
	 */
	private int pageSize;
	/**
	 * 数据库所有的条目数目, 对象初始化确定;
	 */
	private int itemTotalCount;
	private int maxPageCount;
	private int currentPage;
	private List<?> itemsList = null;

	public ItemsPage(int pageSizeParam, int itemTotalCountParam) throws Exception {
		if(pageSizeParam == 0){
			throw new Exception("ItemsPage pageSize could NOT equal 0");
		}
		this.pageSize = pageSizeParam;
		this.itemTotalCount = itemTotalCountParam;
		// 初始化maxPageCount
		int mode = itemTotalCount % pageSize;
		if(mode==0){
			maxPageCount = itemTotalCount / pageSize;
		} else {
			maxPageCount = (itemTotalCount-mode)/pageSize + 1;
		}
	}

	/**
	 * 取得第一页的页码.
	 * 
	 * @return
	 */
	public int getFirstPageIndex() {
		return 1;
	}

	/**
	 * 取得前一页的页码.
	 * @return
	 */
	public int getPreviousPageIndex() {
		if (currentPage >= 2) {
			return currentPage - 1;
		}
		return 1;
	}

	/***
	 * 取得后一页的页面
	 * 
	 * @return
	 */
	public int getNextPageIndex() {
		// 保证查询的页数.
		int nextPage = currentPage + 1;
		if (nextPage >= maxPageCount) {
			return maxPageCount;
		}
		return nextPage;
	}

	/***
	 * 取得后一页的页面
	 * 
	 * @return
	 */
	public int getMaxPageIndex() {
		return maxPageCount;
	}
	
	/***
	 * 取得最多有多少页
	 * 
	 * @return
	 */
	public int getMaxPageCount() {
		return maxPageCount;
	}
	
	/**
	 * 设置当前的页数并返回;
	 * @param currentPageParam
	 * @return
	 */
	public int setAndGetCurrentPage(int currentPageParam) {
		// 临界条件, 当这组分页itemTotalCount都为0时,返回1;
		if(itemTotalCount == 0){
			return 1;
		}
		// 下面进行itemTotalCount!=0的情况判定.
		// 如果currentPageParam<=0, 赋值currentPage为1
		if(currentPageParam <= 0){
			currentPage = 1;
		} else if(currentPageParam > maxPageCount){
			// 如果currentPageParam>maxPageCount, 赋值currentPage为maxPageCount
			currentPage = maxPageCount;
		} else {
			// 还有一种情况就是在中间合适的区间;
			currentPage = currentPageParam;
		}
		return currentPage;
	}

	public List<?> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<?> itemsList) {
		this.itemsList = itemsList;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getItemTotalCount() {
		return itemTotalCount;
	}

	public int getPageSize() {
		return pageSize;
	}
	
	/**
	 * ItemsPage的使用方法.
	 * @throws Exception
	 */
	public static void sampleUsage() throws Exception{
		int totalCount = 100; //getTotalCount();
		ItemsPage pageData = new ItemsPage(ItemsPage.NEWS_PAGE_SIZE,totalCount);
		int OKPageIndex = pageData.setAndGetCurrentPage(4);
		MySqlConnection connInit = new MySqlConnection();
		@SuppressWarnings("unused")
		String sql = "SQL_PAGE_QUERY".replace("#PAGESx20#", String.valueOf((OKPageIndex-1)*ItemsPage.NEWS_PAGE_SIZE))
								   .replace("#PAGE_SIZE#", String.valueOf(ItemsPage.NEWS_PAGE_SIZE));
		List<NewsBean> newsList = new ArrayList<NewsBean>(20);
		// query init newsList
		pageData.setItemsList(newsList);
		connInit.relaseConnection();
	}

}
