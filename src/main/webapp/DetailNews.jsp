<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.greatwqs.mubian.bean.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
	NewsBean bean = (NewsBean)request.getAttribute("NewsBean");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="木匾木刻,木匾,木刻,标识牌制作,成都四方标识牌制作中心" />
		<meta name="description" content="木匾木刻,成都四方标识牌制作中心" />
		<title>动态详情 - 四方标识牌<%=bean.getTitle() %></title>
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
            	<div class="position">动态详情</div>
                <div class="path">当前位置：首页->最新动态->动态详情</div>
                <div class="about_content">
                	<div><b><%=bean.getTitle() %></b></div>
                	<div><%=bean.getContent() %></div>
                	<div class="page"><%=bean.getCreatetime() %></div>
                    <div class="page">完</div>
                </div>
                </div>
				</div>
			</div>
		</div>
		<!--footer-->
		<jsp:include flush="true" page="/include/footer.jsp" />
	</body>
</html>
