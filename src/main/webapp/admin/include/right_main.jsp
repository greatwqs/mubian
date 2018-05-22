<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.greatwqs.mubian.bean.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
	AdminBean bean = (AdminBean)session.getAttribute("AdminBean"); 
	String LastLoginTime = (String)session.getAttribute("LastLoginTime"); 
	if(bean==null){
		response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>main</title>
<base target="_self">
<link rel="stylesheet" type="text/css" href="admin/include/skin/css/base.css" />
<link rel="stylesheet" type="text/css" href="admin/include/skin/css/main.css" />
</head>
<body leftmargin="8" topmargin='8'>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><div style='float:left'> <img height="14" src="admin/include/skin/images/frame/book1.gif" width="20" />&nbsp;欢迎使用内容管理系统，建站的首选工具。 </div>
      <div style='float:right;padding-right:8px;'>
        <!--  //保留接口  -->
      </div></td>
  </tr>
  <tr>
    <td height="1" background="admin/include/skin/images/frame/sp_bg.gif" style='padding:0px'></td>
  </tr>
</table>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px;margin-top:8px;">
  <tr>
    <td background="admin/include/skin/images/frame/wbg.gif" bgcolor="#EEF4EA" class='title'><span>消息</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td>您上次登陆的时间为:&nbsp;<%=LastLoginTime %></td>
  </tr>
</table>
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
  <tr>
    <td colspan="2" background="admin/include/skin/images/frame/wbg.gif" bgcolor="#EEF4EA" class='title'>
    	<div style='float:left'><span>快捷操作</span></div>
    	<div style='float:right;padding-right:10px;'></div>
   </td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td height="30" colspan="2" align="center" valign="bottom"><table width="100%" border="0" cellspacing="1" cellpadding="1">
        <tr>
          <td width="15%" height="31" align="center"><img src="admin/include/skin/images/frame/qc.gif" width="90" height="30" /></td>
          <td width="85%" valign="bottom">
            <!-- 
            <div class='icoitem'>
              <div class='ico'><img src='admin/include/skin/images/frame/addnews.gif' width='16' height='16' /></div>
              <div class='txt'><a href='#'><u>文档列表</u></a></div>
            </div>
            <div class='icoitem'>
              <div class='ico'><img src='admin/include/skin/images/frame/menuarrow.gif' width='16' height='16' /></div>
              <div class='txt'><a href=''><u>评论管理</u></a></div>
            </div>
            <div class='icoitem'>
              <div class='ico'><img src='admin/include/skin/images/frame/manage1.gif' width='16' height='16' /></div>
              <div class='txt'><a href=''><u>内容发布</u></a></div>
            </div>
            <div class='icoitem'>
              <div class='ico'><img src='admin/include/skin/images/frame/file_dir.gif' width='16' height='16' /></div>
              <div class='txt'><a href=''><u>栏目管理</u></a></div>
            </div>
            <div class='icoitem'>
              <div class='ico'><img src='admin/include/skin/images/frame/part-index.gif' width='16' height='16' /></div>
              <div class='txt'><a href=''><u>更新系统缓存</u></a></div>
            </div>
             -->
            <div class='icoitem'>
              <div class='ico'><img src='admin/include/skin/images/frame/manage1.gif' width='16' height='16' /></div>
              <div class='txt'><a href='admin/include/right_main/updatePassword.jsp'><u>修改密码</u></a></div>
            </div></td>
        </tr>
      </table></td>
  </tr>
</table>
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
  <tr bgcolor="#EEF4EA">
    <td colspan="2" background="admin/include/skin/images/frame/wbg.gif" class='title'><span>系统基本信息</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="25%" bgcolor="#FFFFFF">您的级别：</td>
    <td width="75%" bgcolor="#FFFFFF">管理员</td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td>软件版本信息：</td>
    <td>Version 1.0<br /></td>
  </tr>
</table>
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC">
  <tr bgcolor="#EEF4EA">
    <td colspan="2" background="admin/include/skin/images/frame/wbg.gif" class='title'><span>使用帮助</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td height="32">官方交流QQ：</td>
    <td>274233672<br /></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="25%" height="32">官方交流Email:<br /></td>
    <td width="75%"><u>greatwqs@163.com</u><br /></td>
  </tr>
</table>
</body>
</html>