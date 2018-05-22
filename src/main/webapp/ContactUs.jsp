<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>联系我们 - 四方标识牌</title>
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
				
					<jsp:include flush="true" page="/include/compinfo.jsp" />
					
					<div class="ab_right">
						<div class="position">
							联系我们
						</div>
						<div class="path">
							当前位置：首页->联系我们
						</div>
						<div class="about_content">
							电话：028-61677937
							<br />
							手机：15108225374 蒋女士
							<br />
							地址：成都市青羊区红碾村（青羊驾校旁）
							<br />
							网址：www.sifangwood.com
							<br />
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--footer-->
		<jsp:include flush="true" page="/include/footer.jsp" />
	</body>
</html>
