package com.greatwqs.mubian.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greatwqs.mubian.bean.AboutUsBean;
import com.greatwqs.mubian.dao.AboutUsDao;
import com.greatwqs.mubian.utils.PublicUtils;

/***
 * 
 * 管理员关于我们管理
 * 
 * @author greatwqs
 *
 */
public class AdminAboutUsService {
	
	public static final String REQU_UPDATE  = "/admin/include/right_main/updateAboutUs_req.jsp";
	public static final String UPDATE_SUCC  = "/admin/include/right_main/updateAboutUs_succ.jsp";
	public static final String UPDATE_EROR  = "/admin/include/right_main/updateAboutUs_error.jsp";

	/***
	 * 请求阶段更新单个商品: 
	 * URL: /admin/action.html?action=reqaboutus&type=4
	 * @param request
	 * @param resp
	 */
	public static void reqAboutUs(HttpServletRequest request, HttpServletResponse resp) {
		try {
        	int type = -1;
        	String typeStr = request.getParameter("type");
        	if(PublicUtils.isNumeric(typeStr)){
        		type = Integer.parseInt(typeStr.trim());
        	}
        	if(type == -1){
        		RequestDispatcher rd = request.getRequestDispatcher(UPDATE_EROR);
    			rd.forward(request, resp);
        	} else {
        		AboutUsBean bean = AboutUsDao.getAboutUSBean(type);
        		request.setAttribute("AboutUsBean", bean);
            	RequestDispatcher rd = request.getRequestDispatcher(REQU_UPDATE);
    			rd.forward(request, resp);
        	}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * 请求阶段更新单个商品: 
	 * URL: /admin/action.html?action=updateaboutus
	 * @param request
	 * @param resp
	 */
	public static void updateAboutUs(HttpServletRequest request, HttpServletResponse resp) {
		try {
			int type = -1;
        	String typeStr = request.getParameter("type");
        	if(PublicUtils.isNumeric(typeStr)){
        		type = Integer.parseInt(typeStr.trim());
        	}
        	if(type == -1){
        		RequestDispatcher rd = request.getRequestDispatcher(UPDATE_EROR);
    			rd.forward(request, resp);
        	} else {
        		AboutUsBean bean = new AboutUsBean();
        		bean.setContent(PublicUtils.getFormTextUTF8(request.getParameter("EditorDefault")));
        		bean.setType(type);
        		AboutUsDao.update(bean);
            	RequestDispatcher rd = request.getRequestDispatcher(UPDATE_SUCC);
    			rd.forward(request, resp);
        	}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
