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
		<link rel="stylesheet" type="text/css" href="admin/include/skin/css/base.css" />
		<link rel="stylesheet" type="text/css" href="admin/include/skin/css/main.css" />
		<script src="admin/scripts/updatepassword.js" type="text/javascript"></script>
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
				<td>您上次修改密码的时间为:&nbsp;<%=bean.getUpdateTime() %></td>
			</tr>
		</table>
		<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom: 8px">
			<tr>
				<td colspan="2" background="admin/include/skin/images/frame/wbg.gif" bgcolor="#EEF4EA" class='title'>
					<div style='float: left'>
						<span>快捷操作</span>
					</div>
					<div style='float: right; padding-right: 10px;'></div>
				</td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td height="30" colspan="2" align="center" valign="bottom">
				    <form action="admin/action.html?action=updatepassword" method="post"  >
					<table width="602" border="0" cellspacing="1" height="168"  style="border-collapse: collapse">
						<tr>
							<td width="131" height="39" align="right" borderColor="#808080">
								<font color="#ff0000"><b>原密码: </b>
								</font>
							</td>
							<td width="248" height="39">
								<input type="password" name="oldpassword" size="20"
									style="border: 1px solid #999999; FONT-SIZE: 12pt; BACKGROUND: #ffffff; COLOR: #000000; FONT-FAMILY: verdana; 1 px: " />
							</td>
						</tr>
						<tr>
							<td width="131" height="33" align="right">
								<font color="#ff0000"><b>新密码: </b>
								</font>
							</td>
							<td width="248" height="33">
								<input type="password" name="newpassword_1" size="20"
									style="border: 1px solid #999999; FONT-SIZE: 12pt; BACKGROUND: #ffffff; COLOR: #000000; FONT-FAMILY: verdana; 1 px: "
									size="20" onmouseover="this.style.backgroundColor = '#E5F0FF'"
									onmouseout="this.style.backgroundColor = ''" />
							</td>
						</tr>
						<tr>
							<td align="right">
								<font color="#ff0000"><b> <font size="3">密码确认:</font> </b></font>
							</td>
							<td>
								<input type="password" name="newpassword_2"  size="20"
									style="border: 1px solid #999999; FONT-SIZE: 12pt; BACKGROUND: #ffffff; COLOR: #000000; FONT-FAMILY: verdana; 1 px: "
									size="20" onmouseover="this.style.backgroundColor = '#E5F0FF'"
									onmouseout="this.style.backgroundColor = ''" />
							</td>
						</tr>
						<tr>
							<td align="center" colspan="2" height="31">
								<input type="submit" value="提交" onclick="return checkInputForm()" /> &nbsp;&nbsp; 
								<input type="reset" value="重置" />
							</td>
						</tr>
						<tr>
							<td align="center" colspan="2" height="31"><font color="#ff0000"><strong>提示</strong></font>: 新密码最少是英文字符+标点+数字的组合, 如admin.12345。</td>
						</tr>
					</table>
					</form>
				</td>
			</tr>
		</table>
	</body>
</html>