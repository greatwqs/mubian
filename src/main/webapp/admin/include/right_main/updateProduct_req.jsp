<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.greatwqs.mubian.bean.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
	AdminBean adminBean = (AdminBean)session.getAttribute("AdminBean"); 
	ProductBean productBean = (ProductBean)request.getAttribute("ProductBean");
	List<ProductsTypeBean> productTypeList = (List<ProductsTypeBean>)request.getAttribute("ProductsTypeBeanList");
	if(adminBean==null){
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
				<td>此产品上次修改密码的时间为:&nbsp;<%=productBean.getUpdatetime() %></td>
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
				    <form action="admin/action.html?action=updateproduct&id=<%=productBean.getId() %>" method="post"  >
<table width="735" border="0" cellspacing="1" height="168" style="border-collapse: collapse">
	<tr>
		<td width="309" height="33" align="right"><font color="#0000FF"><b>标题:
		</b></font></td>
		<td width="419" height="33" align="left">
		<input type="text" name="title" value="<%=productBean.getTitle() %>" size="20" style="border: 1px solid #999999; FONT-SIZE: 12pt; BACKGROUND: #ffffff; COLOR: #000000; FONT-FAMILY: verdana; 1 px: " size="20" onmouseover="this.style.backgroundColor = '#E5F0FF'" onmouseout="this.style.backgroundColor = ''" /></td>
	</tr>
	<tr>
		<td width="309" height="33" align="right"><font color="#0000FF"><b>类型:
		</b></font></td>
		<td width="419" height="33" align="left">
		<select name="type" size="1">
		<option selected value="<%=productBean.getType() %>"><%=productBean.getTypeName() %></option>
		<% 
		int productTypeID = productBean.getType();
		if(productTypeList!=null && productTypeList.size()>0){
			Iterator<ProductsTypeBean> iter = productTypeList.iterator();
			while(iter.hasNext()){
				ProductsTypeBean typeBean = iter.next();
				int typeID = typeBean.getId();
				if(typeID == productTypeID){
					continue;
				}
				out.println("<option value='"+typeID+"'>"+typeBean.getTypeName()+"</option>");
			}
		}
		
		%>
		</select></td>
	</tr>
	<tr>
		<td width="309" height="33" align="right"><font color="#0000FF"><b>图片地址:
		</b></font></td>
		<td width="419" height="33" align="left">
		<input type="text" name="pictureAddress" value="<%=productBean.getPictureAddress() %>" size="20" style="border: 1px solid #999999; FONT-SIZE: 12pt; BACKGROUND: #ffffff; COLOR: #000000; FONT-FAMILY: verdana; 1 px: " size="20" onmouseover="this.style.backgroundColor = '#E5F0FF'" onmouseout="this.style.backgroundColor = ''" readonly readonly="true"/></td>
	</tr>
	<tr>
		<td width="309" height="33" align="right"><font color="#0000FF"><b>创建时间:
		</b></font></td>
		<td width="419" height="33" align="left">
		<input type="text" name="createTime" value="<%=productBean.getCreatetime() %>" size="20" style="border: 1px solid #999999; FONT-SIZE: 12pt; BACKGROUND: #ffffff; COLOR: #000000; FONT-FAMILY: verdana; 1 px: " size="20" onmouseover="this.style.backgroundColor = '#E5F0FF'" onmouseout="this.style.backgroundColor = ''" readonly readonly="true"/></td>
	</tr>
	<tr>
		<td width="309" height="33" align="right"><font color="#0000FF"><b>主页显示宽度:
		</b></font></td>
		<td width="419" height="33" align="left">
		<input type="text" name="indexWidth" value="<%=productBean.getIndexWidth() %>" size="20" style="border: 1px solid #999999; FONT-SIZE: 12pt; BACKGROUND: #ffffff; COLOR: #000000; FONT-FAMILY: verdana; 1 px: " size="20" onmouseover="this.style.backgroundColor = '#E5F0FF'" onmouseout="this.style.backgroundColor = ''" /></td>
	</tr>
	<tr>
		<td width="309" height="33" align="right"><font color="#0000FF"><b>主页显示高度:
		</b></font></td>
		<td width="419" height="33" align="left">
		<input type="text" name="indexHeight" value="<%=productBean.getIndexHeight() %>" size="20" style="border: 1px solid #999999; FONT-SIZE: 12pt; BACKGROUND: #ffffff; COLOR: #000000; FONT-FAMILY: verdana; 1 px: " size="20" onmouseover="this.style.backgroundColor = '#E5F0FF'" onmouseout="this.style.backgroundColor = ''" /></td>
	</tr>
	<tr>
		<td width="309" height="33" align="right"><font color="#0000FF"><b>介绍:
		</b></font></td>
		<td width="419" height="33" align="left">
		<textarea rows="5" name="content" cols="36" style="border: 1px solid #999999; FONT-SIZE: 12pt; BACKGROUND: #ffffff; COLOR: #000000; FONT-FAMILY: verdana; 1 px: " size="20" onmouseover="this.style.backgroundColor = '#E5F0FF'" onmouseout="this.style.backgroundColor = ''" ><%=productBean.getContent() %></textarea>
		</td>
	</tr>
	<tr>
		<td align="center" colspan="2" height="31">
		<input type="submit" value="提交" />&nbsp;&nbsp;&nbsp;
		<input type="reset" value="重置" /></td>
	</tr>
	<tr>
		<td align="center" colspan="2" height="31"><font color="#0000FF">
		<strong>提示</strong>:</font> 图片地址和创建时间不能更改，如需要改变图片请重新上传产品，再删除原产品。</td>
	</tr>
</table>


					</form>
				</td>
			</tr>
		</table>
	</body>
</html>