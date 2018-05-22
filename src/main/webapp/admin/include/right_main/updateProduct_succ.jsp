<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.greatwqs.mubian.bean.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
	AdminBean bean = (AdminBean)session.getAttribute("AdminBean"); 
	if(bean==null){
		response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>main</title>
		<base target="_self">
		<link rel="stylesheet" type="text/css"
			href="admin/include/skin/css/base.css" />
		<link rel="stylesheet" type="text/css"
			href="admin/include/skin/css/main.css" />
	</head>
	<body leftmargin="8" topmargin='8'>
		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td>
					<div style='float: left'>
						<img height="14" src="admin/include/skin/images/frame/book1.gif" width="20" />
						&nbsp;欢迎使用内容管理系统，建站的首选工具。
					</div>
					<div style='float: right; padding-right: 8px;'>
						<!--  //保留接口  -->
					</div>
				</td>
			</tr>
			<tr>
				<td height="1" background="admin/include/skin/images/frame/sp_bg.gif" style='padding: 0px'></td>
			</tr>
		</table>
		<table width="98%" align="center" border="0" cellpadding="3" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom: 8px; margin-top: 8px;">
			<tr>
				<td background="admin/include/skin/images/frame/wbg.gif" bgcolor="#EEF4EA" class='title'>
					<span>消息</span>
				</td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td>更新此产品的资料成功!</td>
			</tr>
		</table>
	</body>
</html>