package com.greatwqs.mubian.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greatwqs.mubian.bean.ItemsPage;
import com.greatwqs.mubian.bean.ProductBean;
import com.greatwqs.mubian.bean.ProductsTypeBean;
import com.greatwqs.mubian.dao.ProductsDao;
import com.greatwqs.mubian.dao.ProductsTypeDao;
import com.greatwqs.mubian.utils.PublicUtils;

/***
 * 
 * 管理员产品管理
 * 
 * @author greatwqs
 *
 */
public class AdminProductService {
	
	public static final String LIST_ALL_PRODS_SUCC   = "/admin/include/right_main/listProducts.jsp";
	public static final String DELETE_PROD_SUCC      = "/admin/include/right_main/deleteProduct_succ.jsp";
	public static final String DELETE_PROD_404       = "/admin/include/right_main/deleteProduct_404.jsp";
	public static final String REQ_UPDATE_PROD       = "/admin/include/right_main/updateProduct_req.jsp";
	public static final String UPDATE_PROD_404       = "/admin/include/right_main/updateProduct_404.jsp";
	public static final String UPDATE_PROD_SUCC      = "/admin/include/right_main/updateProduct_succ.jsp";
	public static final String REQ_ADD_PROD          = "/admin/include/right_main/addProduct_req.jsp";

	/***
	 * 管理员管理页面列出全部产品: 
	 * URL: /admin/action.html?action=listproducts&type=2&page=3
	 * @param request
	 * @param resp
	 */
	public static void listAllProducts(HttpServletRequest request, HttpServletResponse resp) {
		try {
			// 1. page=2
        	int currentPage = 1;
        	String currentPageStr = request.getParameter("page");
        	if(PublicUtils.isNumeric(currentPageStr)){
        		currentPage = Integer.parseInt(currentPageStr.trim());
        	}
        	// 2. type=2, 0表示没有type,查询所有产品.
        	int currentType = 0;
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
        	request.setAttribute("ItemsPage", pageData);
        	// 4. 设置所有的type列表
        	List<ProductsTypeBean> typeBeanList = ProductsTypeDao.getAllProductsType();
        	request.setAttribute("ProductsTypeBeanList", typeBeanList);
        	// 5. forward
        	RequestDispatcher rd = request.getRequestDispatcher(LIST_ALL_PRODS_SUCC);
			rd.forward(request, resp);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * 删除单个商品: 
	 * URL: /admin/action.html?action=deleteproduct&id=4
	 * @param request
	 * @param resp
	 */
	public static void deleteProduct(HttpServletRequest request, HttpServletResponse resp) {
		try {
        	int id = 0;
        	String idStr = request.getParameter("id");
        	if(PublicUtils.isNumeric(idStr)){
        		id = Integer.parseInt(idStr.trim());
        	}
        	if(id == 0){
        		RequestDispatcher rd = request.getRequestDispatcher(DELETE_PROD_404);
    			rd.forward(request, resp);
        	} else {
        		ProductsDao.delete(id);
            	RequestDispatcher rd = request.getRequestDispatcher(DELETE_PROD_SUCC);
    			rd.forward(request, resp);
        	}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * 批量删除商品
	 * URL: /admin/action.html?action=deleteproducts&ids=4-5-3-2
	 * @param request
	 * @param resp
	 */
	public static void deleteProducts(HttpServletRequest request, HttpServletResponse resp) {
		try {
        	String idsStr = request.getParameter("ids");
        	if(idsStr==null || idsStr.trim().length()==0 ){
        		RequestDispatcher rd = request.getRequestDispatcher(DELETE_PROD_404);
    			rd.forward(request, resp);
        	} else {
        		String[] ids = idsStr.split("-");
        		if(ids.length==0){
        			RequestDispatcher rd = request.getRequestDispatcher(DELETE_PROD_404);
        			rd.forward(request, resp);
        		} else {
        			for(String id: ids){
        				if(PublicUtils.isNumeric(id)){
        					ProductsDao.delete(Integer.parseInt(id));
        				}
        			}
        			RequestDispatcher rd = request.getRequestDispatcher(DELETE_PROD_SUCC);
        			rd.forward(request, resp);
        		}
        	}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/***
	 * 请求阶段更新单个商品: 
	 * URL: /admin/action.html?action=requpdateproduct&id=4
	 * @param request
	 * @param resp
	 */
	public static void reqUpdateProduct(HttpServletRequest request, HttpServletResponse resp) {
		try {
        	int id = 0;
        	String idStr = request.getParameter("id");
        	if(PublicUtils.isNumeric(idStr)){
        		id = Integer.parseInt(idStr.trim());
        	}
        	if(id == 0){
        		RequestDispatcher rd = request.getRequestDispatcher(UPDATE_PROD_404);
    			rd.forward(request, resp);
        	} else {
        		List<ProductsTypeBean> typeBeanList = ProductsTypeDao.getAllProductsType();
            	request.setAttribute("ProductsTypeBeanList", typeBeanList);
        		ProductBean bean = ProductsDao.getProductBean(id);
        		request.setAttribute("ProductBean", bean);
            	RequestDispatcher rd = request.getRequestDispatcher(REQ_UPDATE_PROD);
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
	 * URL: /admin/action.html?action=updateproduct
	 * @param request
	 * @param resp
	 */
	public static void updateProduct(HttpServletRequest request, HttpServletResponse resp) {
		try {
        	int id = 0;
        	String idStr = request.getParameter("id");
        	if(PublicUtils.isNumeric(idStr)){
        		id = Integer.parseInt(idStr.trim());
        	}
        	if(id == 0){
        		RequestDispatcher rd = request.getRequestDispatcher(UPDATE_PROD_404);
    			rd.forward(request, resp);
        	} else {
        		ProductBean bean = new ProductBean();
        		bean.setId(id);
        		bean.setTitle(PublicUtils.getFormTextUTF8(request.getParameter("title")));
        		bean.setType(Integer.parseInt(request.getParameter("type")));
        		String debugString = request.getParameter("pictureAddress");
        		bean.setPictureAddress(PublicUtils.getFormTextUTF8(debugString));
        		bean.setIndexHeight(Integer.parseInt(request.getParameter("indexHeight")));
        		bean.setIndexWidth(Integer.parseInt(request.getParameter("indexWidth")));
        		bean.setContent(PublicUtils.getFormTextUTF8(request.getParameter("content")));
        		ProductsDao.update(bean);
            	RequestDispatcher rd = request.getRequestDispatcher(UPDATE_PROD_SUCC);
    			rd.forward(request, resp);
        	}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * 请求阶段添加单个产品: 
	 * URL: /admin/action.html?action=reqaddproduct
	 * @param request
	 * @param resp
	 */
	public static void reqAddProduct(HttpServletRequest request, HttpServletResponse resp) {
		try {
    		List<ProductsTypeBean> typeBeanList = ProductsTypeDao.getAllProductsType();
        	request.setAttribute("ProductsTypeBeanList", typeBeanList);
        	RequestDispatcher rd = request.getRequestDispatcher(REQ_ADD_PROD);
			rd.forward(request, resp);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
