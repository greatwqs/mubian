<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.greatwqs.mubian.bean.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
	ItemsPage pageData = (ItemsPage)request.getAttribute("ItemsPage");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="木匾木刻,木匾,木刻,标识牌制作,成都四方标识牌制作中心" />
    <meta name="description" content="木匾木刻,成都四方标识牌制作中心" />
		<title>最新动态 - 四方标识牌</title>
		<base href="<%=basePath%>" />
		<link rel="stylesheet" type="text/css" href="styles/style.css" />
	</head>
	<body>
		<jsp:include flush="true" page="/include/header.jsp" />
		<!-- header -->
		<!--关于我们地址产品-->
		<div class="about">
			<div class="w955">
				<div class="box">
				<jsp:include flush="true" page="/include/compinfo_news.jsp" />
				<div class="ab_right">
            	<div class="position">最新动态</div>
                <div class="path">当前位置：首页->最新动态</div>
                <div class="about_content">
               		<ul class="new_list">
               		<% 
               		List<?> beanList = pageData.getItemsList();
               		if(beanList==null || beanList.size()==0){
               			out.println("<li>动态正在添加中..</li>");
               		} else{
               		Iterator<?> iter = beanList.iterator();
               		while(iter.hasNext()){
               			NewsBean bean = (NewsBean)iter.next();
               		%>
                   <li><a href="<%=basePath%>detailNews.html?id=<%=bean.getId()%>"><%=bean.getTitle()%></a><span>[<%=bean.getCreatetime()%>]</span></li>
                   <%} %>           
                   </ul>
                   <div class="page">
                   <a href="<%=basePath%>listNews.html?page=1">首页</a>
                   <a href="<%=basePath%>listNews.html?page=<%=pageData.getPreviousPageIndex()%>">上一页</a>
                   <a href="<%=basePath%>listNews.html?page=<%=pageData.getNextPageIndex()%>">下一页</a>
                   <a href="<%=basePath%>listNews.html?page=<%=pageData.getMaxPageIndex()%>">尾页</a>
                                     共<%=pageData.getMaxPageIndex()%>页
                   </div>
               	   <%} %>
                </div>
                </div>
				</div>
			</div>
		</div>
		<!--footer-->
		<jsp:include flush="true" page="/include/footer.jsp" />
	</body>
</html>
