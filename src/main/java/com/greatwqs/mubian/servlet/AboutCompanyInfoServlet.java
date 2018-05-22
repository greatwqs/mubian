/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.greatwqs.mubian.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greatwqs.mubian.Constants;
import com.greatwqs.mubian.bean.AboutUsBean;
import com.greatwqs.mubian.dao.AboutUsDao;

/**
 * 
 * @author greatwqs
 * @create 2013-04-17
 */
public class AboutCompanyInfoServlet extends HttpServlet{
	
	public static final long serialVersionUID = 1L;
	public static final String RETURN_PAGE = "AboutUs.jsp";
	public static final String ERROR_PAGE  = "error.jsp";
	
	private void doService(HttpServletRequest request, HttpServletResponse resp) {
		try {
			AboutUsBean bean = AboutUsDao.getAboutUSBean(Constants.ABOUTUS_COMPANY_INFO);
			RequestDispatcher rd = request.getRequestDispatcher(RETURN_PAGE);
			request.setAttribute("AboutUSBean", bean);
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
