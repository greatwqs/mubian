package com.greatwqs.mubian.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greatwqs.mubian.bean.AdminBean;

public class AdminHomeServlet extends HttpServlet{
	
	public static final long serialVersionUID = 1L;
	public static final String RETURN_PAGE = "/admin/include/index.jsp";
	public static final String LOGIN_PAGE  = "/admin/login.jsp";
	public static final String ERROR_PAGE  = "error.jsp";
	
	private void doService(HttpServletRequest request, HttpServletResponse resp) {
		try {
			AdminBean bean = (AdminBean)request.getSession().getAttribute("AdminBean");
			if(bean==null){
				request.setAttribute("ErrorString", "请先登陆！");
				resp.sendRedirect(request.getContextPath()+LOGIN_PAGE);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(RETURN_PAGE);
				rd.forward(request, resp);
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
