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

import com.greatwqs.mubian.bean.ProductBean;
import com.greatwqs.mubian.bean.ProductsTypeBean;
import com.greatwqs.mubian.dao.ProductsDao;
import com.greatwqs.mubian.dao.ProductsTypeDao;
import com.greatwqs.mubian.utils.PublicUtils;

/**
 *
 * @author greatwqs
 * @create 2013-04-17
 */
public class DetailProductServlet extends HttpServlet{

	public static final long serialVersionUID = 1L;
	public static final String RETURN_PAGE = "DetailProduct.jsp";
	public static final String ERROR_PAGE  = "Error.jsp";

    private void doService(HttpServletRequest request, HttpServletResponse resp){
        try {
        	int productID = 0;
        	String productIDStr = request.getParameter("id");
        	if(productIDStr!=null && PublicUtils.isNumeric(productIDStr)){
        		productID = Integer.valueOf(productIDStr.trim()).intValue();
        	}
        	if(productID == 0){
        		RequestDispatcher rd = request.getRequestDispatcher(ERROR_PAGE);
    			rd.forward(request, resp);
        	} else {
        		ProductBean bean = ProductsDao.getProductBean(productID);
        		if(bean == null){
        			RequestDispatcher rd = request.getRequestDispatcher(ERROR_PAGE);
        			rd.forward(request, resp);
        		} else {
        			// 1. 得到新闻的详情信息.
        			request.setAttribute("ProductBean", bean);
        			// 2. 设置所有的type列表
                	List<ProductsTypeBean> typeBeanList = ProductsTypeDao.getAllProductsType();
                	request.setAttribute("ProductsTypeBeanList", typeBeanList);
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
