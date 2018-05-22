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

import com.greatwqs.mubian.bean.ItemsPage;
import com.greatwqs.mubian.bean.ProductsTypeBean;
import com.greatwqs.mubian.dao.ProductsDao;
import com.greatwqs.mubian.dao.ProductsTypeDao;
import com.greatwqs.mubian.utils.PublicUtils;

/**
 *
 * @author greatwqs
 * @create 2013-04-17
 */
public class ListProductsServlet extends HttpServlet{

	public static final long serialVersionUID = 1L;
	public static final String ERROR_PAGE  = "Error.jsp";
	public static final String RETURN_PAGE = "ListProducts.jsp";

	/***
	 * listProducts.html?page=2&type=2
	 * @param request
	 * @param resp
	 */
    private void doService(HttpServletRequest request, HttpServletResponse resp){
        try {
        	// 1. page=2
        	int currentPage = 1;
        	String currentPageStr = request.getParameter("page");
        	if(PublicUtils.isNumeric(currentPageStr)){
        		currentPage = Integer.parseInt(currentPageStr.trim());
        	}
        	// 2. type=2, 0表示没有type,查询所有产品.
        	int currentType = 1;
        	String currentTypeStr = request.getParameter("type");
        	if(PublicUtils.isNumeric(currentTypeStr)){
        		currentType = Integer.parseInt(currentTypeStr.trim());
        		// 如果此type在数据库中没有找到,则赋值为初始值0.
        		if(!ProductsTypeDao.isExist(currentType)){
        			currentType = 0;
        		}
        	}
        	// 3. 设置ItemsPage

        	ItemsPage pageData = null;
        	if(currentType == 0){
        		pageData = ProductsDao.getPageProducts(currentPage);
        	} else {
        		pageData = ProductsDao.getTypePageProducts(currentPage, currentType);
        	}
        	// 4. 设置每种类型的产品列表时的高度和宽度;
        	ProductsTypeBean viewBean = ProductsTypeDao.getProductsTypeViewBean(currentType);
        	request.setAttribute("ProductsTypeBean", viewBean);
        	request.setAttribute("ItemsPage", pageData);
        	// 4. 设置所有的type列表
        	List<ProductsTypeBean> typeBeanList = ProductsTypeDao.getAllProductsType();
        	request.setAttribute("ProductsTypeBeanList", typeBeanList);
        	// 5. forward
        	RequestDispatcher rd = request.getRequestDispatcher(RETURN_PAGE);
			rd.forward(request, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		try {
//			resp.sendRedirect("Error.html");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
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
