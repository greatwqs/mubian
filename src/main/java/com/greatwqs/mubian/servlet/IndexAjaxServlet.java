/**
 * 
 */
package com.greatwqs.mubian.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greatwqs.mubian.bean.ItemsPage;
import com.greatwqs.mubian.dao.ProductsDao;
import com.greatwqs.mubian.utils.PublicUtils;

/**
 * @author greatwqs
 *
 */
public class IndexAjaxServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public static final String RETURN_PAGE     = "/indexAjax.jsp";

	protected void doService(HttpServletRequest request, HttpServletResponse resp)
			throws Exception {
    	int currentPage = 0;
    	String currentPageStr = request.getParameter("page");
    	if(PublicUtils.isNumeric(currentPageStr)){
    		currentPage = Integer.parseInt(currentPageStr.trim());
    		ItemsPage pageData = ProductsDao.getIndexAjaxPageProducts(currentPage);
    		request.setAttribute("ItemsPage", pageData);
    		RequestDispatcher rd = request.getRequestDispatcher(RETURN_PAGE);
			rd.forward(request, resp);
    	} else {
    		PrintWriter out = resp.getWriter();
    		out.println("NONE");
    		out.flush();
    		out.close();
    		return;
    	}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			doService(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			doService(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
