<%@ page language="java" import="java.util.*,com.greatwqs.mubian.bean.AboutUsBean" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
	AboutUsBean bean = (AboutUsBean)request.getAttribute("AboutUSBean");
	String title = bean.getTitle();
	String content = bean.getContent();
	String typewords = bean.getTypeWords();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title><%=title%></title>
		<meta name="keywords" content="木匾木刻,木匾,木刻,标识牌制作,成都四方标识牌制作中心" />
		<meta name="description" content="木匾木刻,成都四方标识牌制作中心" />
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
							<%=typewords%>
						</div>
						<div class="path">
							当前位置：首页-><%=typewords%>
						</div>
						<div class="about_content">
							<%=content%>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--footer-->
		<jsp:include flush="true" page="/include/footer.jsp" />
	</body>
</html>
