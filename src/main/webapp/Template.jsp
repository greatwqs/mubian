<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="木匾木刻,木匾,木刻,标识牌制作,成都四方标识牌制作中心" />
    <meta name="description" content="木匾木刻,成都四方标识牌制作中心" />
		<title>木匾网站首页</title>
		<base href="<%=basePath%>"/>
		<link rel="stylesheet" type="text/css" href="styles/style.css" />
	</head>
	<body>
		<jsp:include flush="true" page="/include/header.jsp"  />
		<!-- header -->
		
		<!--关于我们地址产品-->
		<div class="about">
		</div>
		
		
		<!--footer-->
		<jsp:include flush="true" page="/include/footer.jsp" />
	</body>
</html>
