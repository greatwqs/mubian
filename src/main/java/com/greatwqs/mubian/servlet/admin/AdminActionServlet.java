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

public class AdminActionServlet extends HttpServlet{
	
	public static final long serialVersionUID = 1L;
	public static final String RETURN_PAGE           = "/admin/index.html";
	public static final String LOGIN_PAGE            = "/admin/login.jsp";
	public static final String DEFAULT_MENU          = "/admin/include/left_menu.jsp";
	public static final String UPDATE_PASSWORD_INPUT = "/admin/include/right_main/updatePassword.jsp";
	public static final String UPDATE_PASSWORD_SUCC  = "/admin/include/right_main/updatePassword_succ.jsp";
	
	/***
	 * AdminAction
	 * @param request
	 * @param resp
	 */
	public static final String LOGOUT                = "logout";
	public static final String UPDATE_PASSWORD       = "updatepassword";
	/***
	 * 产品管理
	 */
	public static final String LIST_ALL_PRODS        = "listproducts";
	public static final String DELETE_PRODUCT        = "deleteproduct";
	public static final String DELETE_PRODUCTS       = "deleteproducts";
	public static final String REQ_UPDATE_PRODUCT    = "requpdateproduct";
	public static final String UPDATE_PRODUCT        = "updateproduct";
	public static final String REQ_ADD_PRODUCT       = "reqaddproduct";
	
	/***
	 * 新闻管理
	 */
	public static final String LIST_ALL_NEWS         = "listnews";
	public static final String DELETE_NEWS           = "deletenews";
	public static final String DELETE_NEWSS          = "deletenewss";
	public static final String REQ_UPDATE_NEWS       = "requpdatenews";
	public static final String UPDATE_NEWS           = "updatenews";
	public static final String REQ_ADD_NEWS          = "reqaddnews";
	public static final String ADD_NEWS              = "addnews";
	
	/***
	 * 关于我们管理
	 */
	public static final String REQ_ABOUTUS           = "reqaboutus";
	public static final String UPDATE_ABOUTUS        = "updateaboutus";
	
	/**
	 * 管理员全部操作的入口.
	 * URL: /admin/action.html?action=#####
	 * @param request
	 * @param resp
	 */
	private void doService(HttpServletRequest request, HttpServletResponse resp) {
		try {
			AdminBean bean = (AdminBean)request.getSession().getAttribute("AdminBean"); 
			// 1. 判断表单是否为空.
			if(bean == null ) {
				request.setAttribute("ErrorString", "管理员没有登陆！");
				resp.sendRedirect(request.getContextPath()+LOGIN_PAGE);
			} else {
				String action = request.getParameter("action");
				if(action == null || action.trim().length()==0){
					RequestDispatcher rd = request.getRequestDispatcher(DEFAULT_MENU);
					rd.forward(request, resp);
				} else if (LOGOUT.equalsIgnoreCase(action)){
					logout(request,resp);
				} else if (UPDATE_PASSWORD.equalsIgnoreCase(action)){
					String username = bean.getUsername();
					updatePassword(request,resp,username);
				} else if (LIST_ALL_PRODS.equalsIgnoreCase(action)){
					AdminProductService.listAllProducts(request,resp);
				} else if (DELETE_PRODUCTS.equals(action)){
					AdminProductService.deleteProducts(request,resp);
				} else if (DELETE_PRODUCT.equals(action)){
					AdminProductService.deleteProduct(request,resp);
				} else if (REQ_UPDATE_PRODUCT.equals(action)){
					AdminProductService.reqUpdateProduct(request,resp);
				} else if (UPDATE_PRODUCT.equals(action)){
					AdminProductService.updateProduct(request,resp);
				} else if (REQ_ADD_PRODUCT.equals(action)){
					AdminProductService.reqAddProduct(request,resp);
				} else if (LIST_ALL_NEWS.equalsIgnoreCase(action)){
					AdminNewsService.listAllNews(request, resp);
				} else if (DELETE_NEWSS.equals(action)){
					AdminNewsService.deleteNewss(request, resp);
				} else if (DELETE_NEWS.equals(action)){
					AdminNewsService.deleteNews(request, resp);
				} else if (REQ_UPDATE_NEWS.equals(action)){
					AdminNewsService.reqUpdateNews(request, resp);
				} else if (UPDATE_NEWS.equals(action)){
					AdminNewsService.updateNews(request, resp);
				} else if (REQ_ADD_NEWS.equals(action)){
					AdminNewsService.reqAddNews(request, resp);
				} else if (ADD_NEWS.equals(action)){
					AdminNewsService.addNews(request, resp);
				} else if (REQ_ABOUTUS.equals(action)){
					AdminAboutUsService.reqAboutUs(request, resp);
				} else if (UPDATE_ABOUTUS.equals(action)){
					AdminAboutUsService.updateAboutUs(request, resp);
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
	
	/***
	 * 管理员退出
	 * URL:  /admin/action.html?action=logout
	 * @param request
	 * @param resp
	 */
	private void logout(HttpServletRequest request, HttpServletResponse resp) {
		try {
			request.getSession().invalidate();
			resp.sendRedirect(request.getContextPath()+LOGIN_PAGE);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * 管理员更新密码: 
	 * URL: /admin/action.html?action=updatepassword
	 * @param request
	 * @param resp
	 */
	private void updatePassword(HttpServletRequest request, HttpServletResponse resp, String username) {
		try {
			String oldPassword = PublicUtils.getBlankIfNull(request.getParameter("oldpassword"));
			String newPassword1 = PublicUtils.getBlankIfNull(request.getParameter("newpassword_1"));
			String newPassword2 = PublicUtils.getBlankIfNull(request.getParameter("newpassword_2"));
			if(newPassword1.equals(newPassword2)) {
				AdminDao.updatePassword(username, oldPassword, newPassword1);
				RequestDispatcher rd = request.getRequestDispatcher(UPDATE_PASSWORD_SUCC);
				rd.forward(request, resp);
			} else {
				resp.sendRedirect(request.getContextPath()+UPDATE_PASSWORD_INPUT);
			}
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
