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
    <input type='button' class="coolbg np" onClick="location='';" value='添加文档' />
    <input type='button' class="coolbg np" onClick="location='';" value='我的文档' />
    <input type='button' class='coolbg np' onClick="location='';" value='稿件审核' />
    <input type='button' class="coolbg np" onClick="location='';" value='栏目管理' />
    <input type='button' class="coolbg np" onClick="location='';" value='更新列表' />
    <input type='button' class="coolbg np" onClick="location='';" value='更新文档' />
    <input type='button' class="coolbg np" onClick="location='';" value='文章回收站' />
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
	<td width="6%">ID</td>
	<td width="4%">选择</td>
	<td width="28%">文章标题</td>
	<td width="10%">录入时间</td>
	<td width="10%">类目</td>
	<td width="8%">点击</td>
	<td width="6%">HTML</td>
	<td width="8%">权限</td>
	<td width="8%">发布人</td>
	<td width="10%">操作</td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td>5</td>
	<td><input name="id" type="checkbox" id="id" value="101" class="np"></td>
	<td align="left"><a href=''><u>朱晖</u></a></td>
	<td>2009-05-29</td>
	<td>预防保健</td>
	<td>3</td>
	<td>已生成</td>
	<td>开放浏览</td>
	<td>admin</td>
	<td><a href="101">编辑</a> | <a href="101">预览</a></td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td>5</td>
	<td><input name="id" type="checkbox" id="id" value="100" class="np"></td>
	<td align="left"><a href=''><u>肖梅华</u></a></td>
	<td>2009-05-29</td>
	<td>预防保健</td>
	<td>3</td>
	<td>已生成</td>
	<td>开放浏览</td>
	<td>admin</td>
	<td><a href="100">编辑</a> | <a href="100">预览</a></td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td>5</td>
	<td><input name="id" type="checkbox" id="id" value="99" class="np"></td>
	<td align="left"><a href=''><u>俞圭田</u></a></td>
	<td>2009-05-29</td>
	<td>预防保健</td>
	<td>3</td>
	<td>已生成</td>
	<td>开放浏览</td>
	<td>admin</td>
	<td><a href="99">编辑</a> | <a href="99">预览</a></td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td>5</td>
	<td><input name="id" type="checkbox" id="id" value="98" class="np"></td>
	<td align="left"><a href=''><u>王采文</u></a></td>
	<td>2009-05-29</td>
	<td>预防保健</td>
	<td>3</td>
	<td>已生成</td>
	<td>开放浏览</td>
	<td>admin</td>
	<td><a href="98">编辑</a> | <a href="98">预览</a></td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td>5</td>
	<td><input name="id" type="checkbox" id="id" value="97" class="np"></td>
	<td align="left"><a href=''><u>陈惠林</u></a></td>
	<td>2009-05-29</td>
	<td>预防保健</td>
	<td>3</td>
	<td>已生成</td>
	<td>开放浏览</td>
	<td>admin</td>
	<td><a href="97">编辑</a> | <a href="97">预览</a></td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td>5</td>
	<td><input name="id" type="checkbox" id="id" value="96" class="np"></td>
	<td align="left"><a href=''><u>杨优洲</u></a></td>
	<td>2009-05-29</td>
	<td>预防保健</td>
	<td>3</td>
	<td>已生成</td>
	<td>开放浏览</td>
	<td>admin</td>
	<td><a href="96">编辑</a> | <a href="96">预览</a></td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td>5</td>
	<td><input name="id" type="checkbox" id="id" value="95" class="np"></td>
	<td align="left"><a href=''><u>马菲亚</u></a></td>
	<td>2009-05-29</td>
	<td>预防保健</td>
	<td>3</td>
	<td>已生成</td>
	<td>开放浏览</td>
	<td>admin</td>
	<td><a href="95">编辑</a> | <a href="95">预览</a></td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td>5</td>
	<td><input name="id" type="checkbox" id="id" value="94" class="np"></td>
	<td align="left"><a href=''><u>刘洁</u></a></td>
	<td>2009-05-29</td>
	<td>预防保健</td>
	<td>3</td>
	<td>已生成</td>
	<td>开放浏览</td>
	<td>admin</td>
	<td><a href="94">编辑</a> | <a href="94">预览</a></td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td>5</td>
	<td><input name="id" type="checkbox" id="id" value="93" class="np"></td>
	<td align="left"><a href=''><u>石书芳</u></a></td>
	<td>2009-05-29</td>
	<td>预防保健</td>
	<td>3</td>
	<td>已生成</td>
	<td>开放浏览</td>
	<td>admin</td>
	<td><a href="93">编辑</a> | <a href="93">预览</a></td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td>5</td>
	<td><input name="id" type="checkbox" id="id" value="92" class="np"></td>
	<td align="left"><a href=''><u>朱宝英</u></a></td>
	<td>2009-05-29</td>
	<td>预防保健</td>
	<td>3</td>
	<td>已生成</td>
	<td>开放浏览</td>
	<td>admin</td>
	<td><a href="92">编辑</a> | <a href="92">预览</a></td>
</tr>

<tr bgcolor="#FAFAF1">
<td height="28" colspan="10">
	&nbsp;
	<a href="javascript:selAll()" class="coolbg">全选</a>
	<a href="javascript:noSelAll()" class="coolbg">取消</a>
	<a href="javascript:updateArc(0)" class="coolbg">&nbsp;更新&nbsp;</a>
	<a href="javascript:checkArc(0)" class="coolbg">&nbsp;审核&nbsp;</a>
	<a href="javascript:adArc(0)" class="coolbg">&nbsp;推荐&nbsp;</a>
	<a href="javascript:moveArc(0)" class="coolbg">&nbsp;移动&nbsp;</a>
	<a href="javascript:delArc(0)" class="coolbg">&nbsp;删除&nbsp;</a>
</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="10" align="center"><!--翻页代码 --></td>
</tr>
</table>

</form>

<!--  搜索表单  -->
<form name='form3' action='' method='get'>
<input type='hidden' name='dopost' value='' />
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='admin/skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>搜索条件：</td>
          <td width='160'>
          <select name='cid' style='width:150'>
          <option value='0'>选择类型...</option>
          	<option value='1'>名称</option>
          </select>
        </td>
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' name='keyword' value='' style='width:150px' />
        </td>
        <td width='110'>
    		<select name='orderby' style='width:80px'>
            <option value='id'>排序...</option>
            <option value='pubdate'>发布时间</option>
      	</select>
        </td>
        <td>
          <input name="imageField" type="image" src="admin/include/skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
        </td>
       </tr>
      </table>
    </td>
  </tr>
</table>
</form>
</body>
</html>