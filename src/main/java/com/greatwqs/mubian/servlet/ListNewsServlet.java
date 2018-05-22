/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.greatwqs.mubian.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greatwqs.mubian.bean.NewsBean;
import com.greatwqs.mubian.bean.ItemsPage;
import com.greatwqs.mubian.dao.NewsDao;
import com.greatwqs.mubian.utils.PublicUtils;

/**
 *
 * @author greatwqs
 * @create 2013-04-17
 */
public class ListNewsServlet extends HttpServlet{

	public static final long serialVersionUID = 1L;
	public static final String RETURN_PAGE = "ListNews.jsp";

    private void doService(HttpServletRequest request, HttpServletResponse resp){
        try {
        	// 1. 得到分页新闻数据
        	int currentPage = 1;
        	String currentPageStr = request.getParameter("page");
        	if(currentPageStr!=null && PublicUtils.isNumeric(currentPageStr)){
        		currentPage = Integer.valueOf(currentPageStr.trim()).intValue();
        	}
        	ItemsPage page = NewsDao.getPageNews(currentPage);
        	request.setAttribute("ItemsPage", page);
        	// 2. 得到最新的3条新闻数据, 页面左边显示.
        	List<NewsBean> newsList = NewsDao.getThreeTopeNews();
        	request.setAttribute("Top3NewsList", newsList);
        	RequestDispatcher rd = request.getRequestDispatcher(RETURN_PAGE);
			rd.forward(request, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doService(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doService(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

}
