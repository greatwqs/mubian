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
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>文档管理</title>
<link rel="stylesheet" type="text/css" href="admin/include/skin/css/base.css" />
<script language="javascript" type="text/javascript" src="admin/include/skin/js/archives.js"></script>
</head>
<body leftmargin="8" topmargin="8" background='admin/include/skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="admin/include/skin/images/newlinebg3.gif">
  <table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td align="center">
    <%
     out.println("<input type='button' class=\"coolbg np\" onClick=\"location='admin/action.html?action=listnews';\" value='默认分类' />");
     %>
 </td>
 </tr>
</table>
</td>
</tr>
</table>
  
<!--  内容列表   -->
<form name="form2">
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="10" background="admin/include/skin/images/tbg.gif">&nbsp;文档列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="5%">ID</td>
	<td width="5%">选择</td>
	<td width="30%">文章标题</td>
	<td width="16%">录入时间</td>
	<td width="13%">类目</td>
	<td width="11%">发布人</td>
	<td width="17%">操作</td>
</tr>
<% 
List<?> itemList = pageData.getItemsList();
if(itemList!=null && itemList.size()>0){
Iterator<?> iter = itemList.iterator();
while(iter.hasNext()){
NewsBean bean = (NewsBean)iter.next();
%>
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td><%=bean.getId() %></td>
	<td><input name="id" type="checkbox" id="id" value="<%=bean.getId() %>" class="np"></td>
	<td align="left"><%=bean.getTitle() %></td>
	<td><%=bean.getCreatetime() %></td>
	<td>默认</td>
	<td>admin</td>
	<td>
	<a href="admin/action.html?action=requpdatenews&id=<%=bean.getId() %>">编辑</a> | 
	<a href="detailNews.html?id=<%=bean.getId() %>" target="_blank">预览</a> | 
	<a href="admin/action.html?action=deletenews&id=<%=bean.getId() %>">删除</a></td>
</tr>
<% }}%>
<tr bgcolor="#FAFAF1">
<td height="28" colspan="10">
	&nbsp;
	<a href="javascript:selAll()" class="coolbg">全选</a>
	<a href="javascript:noSelAll()" class="coolbg">取消</a>
	<a href="javascript:deleteNewss(0)" class="coolbg">&nbsp;删除&nbsp;</a>
</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="10" align="center">
	<!--翻页代码 -->
	<a href="<%="admin/action.html?action=listnews&page="+pageData.getFirstPageIndex()+"&type="%>${param.type}">首页</a>
    <a href="<%="admin/action.html?action=listnews&page="+pageData.getPreviousPageIndex()+"&type="%>${param.type}">上一页</a>
    <a href="<%="admin/action.html?action=listnews&page="+pageData.getNextPageIndex()+"&type="%>${param.type}">下一页</a>
    <a href="<%="admin/action.html?action=listnews&page="+pageData.getMaxPageIndex()+"&type="%>${param.type}">尾页</a>
        共<%=pageData.getMaxPageCount()%>页/合计<%=pageData.getItemTotalCount() %>个
	</td>
</tr>
</table>
</form>

</body>
</html>