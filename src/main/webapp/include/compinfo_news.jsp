<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.greatwqs.mubian.bean.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
	List<?> Top3NewsList = (List<?>)request.getAttribute("Top3NewsList");
%>
<base href="<%=basePath%>">
<div class="ab_left">
	<div class="about_list">
		<div class="about_list_top"></div>
		<div class="about_list_middle">
			<ul>
				<li>
					News / 最新新闻
				</li>
				<% 
				if(Top3NewsList!=null && Top3NewsList.size()>0){
					Iterator<?> newsIter = Top3NewsList.iterator();
					while(newsIter.hasNext()){
						NewsBean bean = (NewsBean)newsIter.next();
						out.println("<li><a href=\""+basePath+"detailNews.html?id="+bean.getId()+"\">"+bean.getTitle()+"</a></li>");
					}
				} else {
					out.println("<li>无最新新闻</li>");
				}
				%>
			</ul>
		</div>
		<div class="about_list_buttom"></div>
	</div>
	<div class="coontact_about">
		电话：028-61677937
		<br />
		手机：15108225374 蒋女士
		<br />
		地址：成都市青羊区红碾村（青羊驾校旁）
		<br />
		网址：www.sifangwood.com
	</div>
</div>