package com.greatwqs.mubian.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greatwqs.mubian.bean.ItemsPage;
import com.greatwqs.mubian.bean.NewsBean;
import com.greatwqs.mubian.dao.NewsDao;
import com.greatwqs.mubian.utils.PublicUtils;

/***
 * 
 * 管理员新闻管理
 * 
 * @author greatwqs
 *
 */
public class AdminNewsService {
	
	public static final String LIST_ALL_NEWS_SUCC    = "/admin/include/right_main/listNews.jsp";
	public static final String DELETE_NEWS_SUCC      = "/admin/include/right_main/deleteNews_succ.jsp";
	public static final String DELETE_NEWS_404       = "/admin/include/right_main/deleteNews_404.jsp";
	public static final String REQ_UPDATE_NEWS       = "/admin/include/right_main/updateNews_req.jsp";
	public static final String UPDATE_NEWS_404       = "/admin/include/right_main/updateNews_404.jsp";
	public static final String UPDATE_NEWS_SUCC      = "/admin/include/right_main/updateNews_succ.jsp";
	public static final String REQ_ADD_NEWS          = "/admin/include/right_main/addNews_req.jsp";
	public static final String ADD_NEWS_SUCC         = "/admin/include/right_main/addNews_succ.jsp";
	
	/***
	 * 管理员管理页面列出全部新闻: 
	 * URL: /admin/action.html?action=listnews&page=3
	 * @param request
	 * @param resp
	 */
	public static void listAllNews(HttpServletRequest request, HttpServletResponse resp) {
		try {
			// 1. page=2
        	int currentPage = 1;
        	String currentPageStr = request.getParameter("page");
        	if(PublicUtils.isNumeric(currentPageStr)){
        		currentPage = Integer.parseInt(currentPageStr.trim());
        	}
        	// 2. 设置ItemsPage
        	ItemsPage pageData = null;
        	pageData = NewsDao.getPageNews(currentPage);
        	request.setAttribute("ItemsPage", pageData);
        	// 5. forward
        	RequestDispatcher rd = request.getRequestDispatcher(LIST_ALL_NEWS_SUCC);
			rd.forward(request, resp);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * 删除单个新闻: 
	 * URL: /admin/action.html?action=deletenews&id=4
	 * @param request
	 * @param resp
	 */
	public static void deleteNews(HttpServletRequest request, HttpServletResponse resp) {
		try {
        	int id = 0;
        	String idStr = request.getParameter("id");
        	if(PublicUtils.isNumeric(idStr)){
        		id = Integer.parseInt(idStr.trim());
        	}
        	if(id == 0){
        		RequestDispatcher rd = request.getRequestDispatcher(DELETE_NEWS_404);
    			rd.forward(request, resp);
        	} else {
        		NewsDao.delete(id);
            	RequestDispatcher rd = request.getRequestDispatcher(DELETE_NEWS_SUCC);
    			rd.forward(request, resp);
        	}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * 批量删除新闻
	 * URL: /admin/action.html?action=deletenewss&ids=4-5-3-2
	 * @param request
	 * @param resp
	 */
	public static void deleteNewss(HttpServletRequest request, HttpServletResponse resp) {
		try {
        	String idsStr = request.getParameter("ids");
        	if(idsStr==null || idsStr.trim().length()==0 ){
        		RequestDispatcher rd = request.getRequestDispatcher(DELETE_NEWS_404);
    			rd.forward(request, resp);
        	} else {
        		String[] ids = idsStr.split("-");
        		if(ids.length==0){
        			RequestDispatcher rd = request.getRequestDispatcher(DELETE_NEWS_404);
        			rd.forward(request, resp);
        		} else {
        			for(String id: ids){
        				if(PublicUtils.isNumeric(id)){
        					NewsDao.delete(Integer.parseInt(id));
        				}
        			}
        			RequestDispatcher rd = request.getRequestDispatcher(DELETE_NEWS_SUCC);
        			rd.forward(request, resp);
        		}
        	}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/***
	 * 请求阶段更新单个新闻: 
	 * URL: /admin/action.html?action=requpdatenews&id=4
	 * @param request
	 * @param resp
	 */
	public static void reqUpdateNews(HttpServletRequest request, HttpServletResponse resp) {
		try {
        	int id = 0;
        	String idStr = request.getParameter("id");
        	if(PublicUtils.isNumeric(idStr)){
        		id = Integer.parseInt(idStr.trim());
        	}
        	if(id == 0){
        		RequestDispatcher rd = request.getRequestDispatcher(UPDATE_NEWS_404);
    			rd.forward(request, resp);
        	} else {
        		NewsBean bean = NewsDao.getNewsBean(id);
        		request.setAttribute("NewsBean", bean);
            	RequestDispatcher rd = request.getRequestDispatcher(REQ_UPDATE_NEWS);
    			rd.forward(request, resp);
        	}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * 请求阶段更新单个新闻: 
	 * URL: /admin/action.html?action=updatenews
	 * @param request
	 * @param resp
	 */
	public static void updateNews(HttpServletRequest request, HttpServletResponse resp) {
		try {
        	int id = 0;
        	String idStr = request.getParameter("id");
        	if(PublicUtils.isNumeric(idStr)){
        		id = Integer.parseInt(idStr.trim());
        	}
        	if(id == 0){
        		RequestDispatcher rd = request.getRequestDispatcher(UPDATE_NEWS_404);
    			rd.forward(request, resp);
        	} else {
        		NewsBean bean = new NewsBean();
        		bean.setId(id);
        		bean.setTitle(PublicUtils.getFormTextUTF8(request.getParameter("title")));
        		bean.setType(Integer.parseInt(request.getParameter("type")));
        		bean.setContent(PublicUtils.getFormTextUTF8(request.getParameter("content")));
        		NewsDao.update(bean);
            	RequestDispatcher rd = request.getRequestDispatcher(UPDATE_NEWS_SUCC);
    			rd.forward(request, resp);
        	}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * 请求阶段添加单个新闻: 
	 * URL: /admin/action.html?action=reqaddnews
	 * @param request
	 * @param resp
	 */
	public static void reqAddNews(HttpServletRequest request, HttpServletResponse resp) {
		try {
        	RequestDispatcher rd = request.getRequestDispatcher(REQ_ADD_NEWS);
			rd.forward(request, resp);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * 请求阶段添加单个新闻: 
	 * URL: /admin/action.html?action=addnews
	 * @param request
	 * @param resp
	 */
	public static void addNews(HttpServletRequest request, HttpServletResponse resp) {
		try {
			NewsBean bean = new NewsBean();
			String title = PublicUtils.getFormTextUTF8(request.getParameter("title"));
			bean.setTitle(title);
			int type = Integer.parseInt(PublicUtils.getFormTextUTF8(request.getParameter("type")));
			bean.setType(type);
			String content = PublicUtils.getFormTextUTF8(request.getParameter("content"));
			bean.setContent(content);
			NewsDao.insert(bean);
        	RequestDispatcher rd = request.getRequestDispatcher(ADD_NEWS_SUCC);
			rd.forward(request, resp);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
