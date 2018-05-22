package com.greatwqs.mubian.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greatwqs.mubian.bean.AdminBean;
import com.greatwqs.mubian.dao.AdminDao;
import com.greatwqs.mubian.utils.PublicUtils;

public class AdminLoginServlet extends HttpServlet{
	
	public static final long serialVersionUID = 1L;
	public static final String RETURN_PAGE = "/admin/index.html";
	public static final String ERROR_PAGE  = "/admin/login.jsp";
	
	private void doService(HttpServletRequest request, HttpServletResponse resp) {
		try {
			String username = PublicUtils.getBlankIfNull(request.getParameter("username"));
			String password = PublicUtils.getBlankIfNull(request.getParameter("password"));
			String validate = PublicUtils.getBlankIfNull(request.getParameter("validate"));
			String sessionValdata = PublicUtils.getBlankIfNull(
					(String)request.getSession().getAttribute("ValidateImgValue"));
			// 1. 判断表单是否为空.
			if(username.trim().length()>0 && password.trim().length()>0 && validate.trim().length()>0) {
				// 2. 判断验证码是否一致.
				if(!validate.equals(sessionValdata)){
					request.setAttribute("ErrorString", "验证码输入错误，请重新输入！");
					RequestDispatcher rd = request.getRequestDispatcher(ERROR_PAGE);
					rd.forward(request, resp);
				} else {
					// 3. 判断用户名和密码是否一致.
					boolean flag = AdminDao.isLogin(username, password);
					if(!flag){
						request.setAttribute("ErrorString", "用户名、密码不正确！");
						RequestDispatcher rd = request.getRequestDispatcher(ERROR_PAGE);
						rd.forward(request, resp);
					} else {
						String LastLoginTime = AdminDao.getLoginTime(username);
						AdminDao.updateLoginTime(username);
						AdminBean bean = AdminDao.getAdminBean(username);
						request.getSession().setAttribute("AdminBean", bean);
						request.getSession().setAttribute("LastLoginTime", LastLoginTime);
						resp.sendRedirect(request.getContextPath()+RETURN_PAGE);
					}
				}
			} else {
				request.setAttribute("ErrorString", "用户名、密码、验证码之一为空，或者全部为空！");
				RequestDispatcher rd = request.getRequestDispatcher(ERROR_PAGE);
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
