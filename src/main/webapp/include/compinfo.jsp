<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<div class="ab_left">
	<div class="about_list">
		<div class="about_list_top"></div>
		<div class="about_list_middle">
			<ul>
				<li>
					About Us / 关于我们
				</li>
				<li>
					<a href="<%=basePath%>ourCompanyInfo.html">公司简介</a>
				</li>
				<li>
					<a href="<%=basePath%>ourBusiness.html">公司业务</a>
				</li>
				<li>
					<a href="<%=basePath%>partners.html">合作伙伴</a>
				</li>
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