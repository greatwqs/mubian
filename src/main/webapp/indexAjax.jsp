<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.greatwqs.mubian.bean.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ItemsPage pageData = (ItemsPage)request.getAttribute("ItemsPage");
List<?> pageList = pageData.getItemsList();
%>
<ul>
<%
if(pageList!=null && pageList.size()>0){
	Iterator<?> iter = pageList.iterator();
	while(iter.hasNext()){
		ProductBean bean = (ProductBean)iter.next();
%>
	<li>
	<div class="product_name"><%=bean.getTitle() %></div>
	<div class="product_name_img">
		<!-- 添加table的td保证图片可以水平和垂直居中 -->
		<table cellpadding="0" cellspacing="0" width="100%" height="100%">
			<tr>
				<td valign="middle" align="center" >
				<a href="detailProduct.html?id=<%=bean.getId() %>"><img src="<%=bean.getPictureAddress() %>" width="<%=bean.getIndexWidth() %>" height="<%=bean.getIndexHeight() %>" /></a>
				</td>
			</tr>
		</table>
	</div>
	</li>
<%
	}
}
 %>
</ul>
<input type="hidden" name="next_ajax_page" id="next_ajax_page" value="<%=pageData.getNextPageIndex() %>"/>
<input type="hidden" name="pre_ajax_page" id="pre_ajax_page" value="<%=pageData.getPreviousPageIndex() %>"/>