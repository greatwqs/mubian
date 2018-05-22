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
import com.greatwqs.mubian.dao.NewsDao;
import com.greatwqs.mubian.utils.PublicUtils;

/**
 *
 * @author greatwqs
 * @create 2013-04-17
 */
public class DetailNewsServlet extends HttpServlet{

	public static final long serialVersionUID = 1L;
	public static final String RETURN_PAGE = "DetailNews.jsp";
	public static final String ERROR_PAGE  = "Error.jsp";

    private void doService(HttpServletRequest request, HttpServletResponse resp){
        try {
        	int newsID = 0;
        	String newsIDStr = request.getParameter("id");
        	if(newsIDStr!=null && PublicUtils.isNumeric(newsIDStr)){
        		newsID = Integer.valueOf(newsIDStr.trim()).intValue();
        	}
        	if(newsID == 0){
        		RequestDispatcher rd = request.getRequestDispatcher(ERROR_PAGE);
    			rd.forward(request, resp);
        	} else {
        		NewsBean bean = NewsDao.getNewsBean(newsID);
        		if(bean == null){
        			RequestDispatcher rd = request.getRequestDispatcher(ERROR_PAGE);
        			rd.forward(request, resp);
        		} else {
        			// 1. 得到新闻的详情信息.
        			request.setAttribute("NewsBean", bean);
                	// 2. 得到最新的3条新闻数据, 页面左边显示.
                	List<NewsBean> newsList = NewsDao.getThreeTopeNews();
                	request.setAttribute("Top3NewsList", newsList);
                	RequestDispatcher rd = request.getRequestDispatcher(RETURN_PAGE);
        			rd.forward(request, resp);
        		}
        	}
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
