<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.greatwqs.mubian.bean.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
	// 分页数据
	ItemsPage pageData = (ItemsPage)request.getAttribute("ItemsPage");
	// 类型数据
	List<?> typeBeanList = (List<?>)request.getAttribute("ProductsTypeBeanList");
	// 分页时具体分页种类
	String typeName = ProductsTypeBean.getTypeNameByDB(request.getParameter("type"));
	// ProductsTypeBean
	ProductsTypeBean typeViewBean = (ProductsTypeBean)request.getAttribute("ProductsTypeBean");
	
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="木匾木刻,木匾,木刻,标识牌制作,成都四方标识牌制作中心" />
<meta name="description" content="木匾木刻,成都四方标识牌制作中心" />
<title>产品展示 - <%=typeName %> - 四方标识牌</title>
<link rel="stylesheet" type="text/css" href="styles/style.css"/>
</head>
<body>&nbsp; 
<jsp:include flush="true" page="/include/header.jsp"  />
<!-- header -->
<!--关于我们地址产品-->
<div class="about">
	<div class="w955">
        <div class="box">
         	<div class="ab_left">
            	<div class="about_list">
                	<div class="about_list_top"></div>
                    <div class="about_list_middle_product">
                    	<ul>
                        	<li>Products / 产品展示</li>
							<%
							if (typeBeanList == null || typeBeanList.size() == 0) {
								out.println("<li><a href=\"listProducts.html\">木匾木刻系列</a></li>");
							} else {
								Iterator<?> iter = typeBeanList.iterator();
								while (iter.hasNext()) {
									ProductsTypeBean typeBean = (ProductsTypeBean) iter.next();
									// <li><a href="http://localhost:8080/MuBian/listProducts.html?type=4"><img src="images/listproducts/1_06.jpg" alt="对联吊牌系列"/></a></li>
									out.println("<li><a href=\"" + basePath+ "listProducts.html?type=" + typeBean.getId() + "\">"+ "<img src=\""+typeBean.getPicture()+"\" alt=\""+typeBean.getTypeName()+"\"/>"+"</a></li>");
								}
							}
							%>
                        </ul>
                    </div>
                    <div class="about_list_buttom"></div>
                </div>
            	<div class="coontact_about">
					电话：028-61677937<br />
					手机：15108225374 蒋女士<br />
					地址：成都市青羊区红碾村（青羊驾校旁）<br />
					网址：www.sifangwood.com
                </div>
            </div>
            <div class="ab_right">
            	<div class="position"><%=typeViewBean.getTypeName() %></div>
                <div class="path">
                                当前位置：<a href="<%=basePath%>">首页</a>-&gt;
                <a href="<%=basePath+"listProducts.html"%>">产品展示</a>-&gt;
                <a href="<%=basePath+"listProducts.html?type="+typeViewBean.getId()%>"><%=typeViewBean.getTypeName() %></a>
                </div>
                <div class="about_content">
                	<ul>
                	<%
                	List<?> beanList = pageData.getItemsList();
               		if(beanList==null || beanList.size()==0){
               			out.println("<li class=\"pt_li\">此类产品正在添加中..</li>");
               		} else{
               		Iterator<?> iter = beanList.iterator();
               		while(iter.hasNext()){
               			ProductBean bean = (ProductBean)iter.next();
                	 %>
                    	<li class="pt_li">
                    	<!-- <li class="pt_li" width="" height=""> -->
							<a href="<%=basePath+"detailProduct.html?id="+bean.getId()%>"><img src="<%=bean.getPictureAddress() %>" width="<%=typeViewBean.getWidth() %>" height="<%=typeViewBean.getHeight() %>"/></a>
						</li>
                     <% }
                     }%>
                    </ul>
                     <div class="page">
                     <a href="<%=basePath+"listProducts.html?page="+pageData.getFirstPageIndex()+"&type="%>${param.type}">首页</a>
                     <a href="<%=basePath+"listProducts.html?page="+pageData.getPreviousPageIndex()+"&type="%>${param.type}">上一页</a>
                     <a href="<%=basePath+"listProducts.html?page="+pageData.getNextPageIndex()+"&type="%>${param.type}">下一页</a>
                     <a href="<%=basePath+"listProducts.html?page="+pageData.getMaxPageIndex()+"&type="%>${param.type}">尾页</a>
                                          共<%=pageData.getMaxPageCount()%>页/合计<%=pageData.getItemTotalCount() %>个
                     </div>
                </div>
            </div>
         </div>
     </div>
</div>

<!--footer-->
<jsp:include flush="true" page="/include/footer.jsp" />

</body>
</html>
