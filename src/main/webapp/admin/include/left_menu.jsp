<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.greatwqs.mubian.bean.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>menu</title>
<link rel="stylesheet" href="admin/include/skin/css/base.css" type="text/css" />
<link rel="stylesheet" href="admin/include/skin/css/menu.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<script language='javascript'>var curopenItem = '1';</script>
<script language="javascript" type="text/javascript" src="admin/include/skin/js/menu.js"></script>
<base target="main" />
</head>
<body target="main">
<table width='99%' height="100%" border='0' cellspacing='0' cellpadding='0'>
  <tr>
    <td style='padding-left:3px;padding-top:8px' valign="top">
	<!-- Item 1 Strat -->
      <dl class='bitem'>
        <dt onclick='showHide("items1_1")'><b>产品管理</b></dt>
        <dd style='display:block' class='sitem' id='items1_1'>
          <ul class='sitemu'>
            <li><a href='admin/action.html?action=listproducts' target='main'>全部产品</a> </li>
			<li><a href='admin/action.html?action=reqaddproduct' target='main'>新增产品</a> </li>
			<!-- 
            <li><a href='admin/action.html?action=requpdateproduct' target='main'>修改产品</a> </li>
            <li><a href='admin/action.html?action=deleteproduct' target='main'>删除产品</a> </li>
             -->
          </ul>
        </dd>
      </dl>
      <!-- Item 1 End -->
      <!-- Item 2 Strat -->
      <dl class='bitem'>
        <dt onclick='showHide("items2_1")'><b>新闻动态管理</b></dt>
        <dd style='display:block' class='sitem' id='items2_1'>
          <ul class='sitemu'>
            <li><a href='admin/action.html?action=listnews' target='main'>全部新闻</a></li>
            <li><a href='admin/action.html?action=reqaddnews' target='main'>新增新闻</a></li>
            <!-- 
            <li><a href='admin/action.html?action=requpdatenews' target='main'>修改新闻</a></li>
            <li><a href='admin/action.html?action=deletenews' target='main'>删除新闻</a></li>
             -->
          </ul>
        </dd>
      </dl>
      <!-- Item 2 End -->
      <!-- Item 3 Strat -->
      <dl class='bitem'>
        <dt onclick='showHide("items3_1")'><b>关于我们</b></dt>
        <dd style='display:block' class='sitem' id='items3_1'>
          <ul class='sitemu'>
            <li><a href='admin/action.html?action=reqaboutus&type=1' target='main'>公司简介</a></li>
            <li><a href='admin/action.html?action=reqaboutus&type=2' target='main'>公司业务</a></li>
            <li><a href='admin/action.html?action=reqaboutus&type=3' target='main'>合作伙伴</a></li>
          </ul>
        </dd>
      </dl>
      <!-- Item 3 End -->
      <!-- Item 4 Strat -->
      <dl class='bitem'>
        <dt onclick='showHide("items4_1")'><b>联系我们</b></dt>
        <dd style='display:block' class='sitem' id='items4_1'>
          <ul class='sitemu'>
            <li><a href='admin/action.html?action=reqaboutus&type=0' target='main'>联系我们</a></li>
          </ul>
        </dd>
      </dl>
      <!-- Item 4 End -->
	  </td>
  </tr>
</table>
</body>
</html>