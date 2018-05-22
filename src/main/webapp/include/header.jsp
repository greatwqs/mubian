<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<base href="<%=basePath%>">
<div class="head">
    <div class="w955">
        <div class="box">
            <div class="logo">
                <div class="r_save">
                <a onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://www.sifangwood.com');" href="#" class="STYLE1">设为首页</a>&nbsp;|&nbsp;
                <a href="#" onclick="javascript:window.external.AddFavorite('http://www.sifangwood.com','木匾木刻')" title="收藏本站到你的收藏夹" class="STYLE1"><font size="-1" color="#FFE09E">添加收藏</font></a>
                </div>
            </div>
        </div>
    </div>
</div>
<!--焦点图和价值观和导航-->
<div class="nav_banner">
    <div class="w955">
        <div class="box">
            <div class="nav">
                <div class="nav_left">
                    <a href="<%=basePath%>">网站首页</a>
                    <a href="<%=basePath%>ourCompanyInfo.html">关于我们</a>
                    <a href="<%=basePath%>listProducts.html">产品介绍</a>
                    <a href="<%=basePath%>listNews.html">最新动态</a>
                    <a href="<%=basePath%>contactUs.html">联系我们</a>
                </div>
                <div class="new_right">►最新消息：成都四方标示制作中心全体工作人员，祝各位新老客户五一节快乐！</div>
            </div>
            <div class="banner"><img src="images/banner.jpg" /></div>
            <div class="jiazhi">
                四方价值观：诚信  服务  艺术  传承  四方客户观：一切追求客户满意 四方安全观：生命只有一次，人人警惕安全防患  四方人才观：忠诚勤劳、感恩上进、承担负责
            </div>
        </div>
    </div>
</div>
