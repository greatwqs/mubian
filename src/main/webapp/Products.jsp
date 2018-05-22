<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>木匾网站产品展示 - 四方标识牌</title>
<meta name="keywords" content="木匾木刻,木匾,木刻,标识牌制作,成都四方标识牌制作中心" />
<meta name="description" content="木匾木刻,成都四方标识牌制作中心" />
<link rel="stylesheet" type="text/css" href="styles/style.css"/>
</head>

<body>
<jsp:include flush="true" page="/include/header.jsp"  />
<!-- header -->
		
<!--关于我们地址产品-->
<div class="about">
	<div class="w955">
        <div class="box">
         	<div class="ab_left">
            	<div class="about_list">
                	<div class="about_list_top"></div>
                    <div class="about_list_middle">
                    	<ul>
                        	<li>Products / 产品展示</li>
                            <li><a href="#">木匾系列</a></li>
                            <li><a href="#">门牌系列</a></li>
                            <li><a href="#">根雕系列</a></li>
                        </ul>
                    </div>
                    <div class="about_list_buttom"></div>
                </div>
            	<div class="coontact_about">
                	 电话：028-61677937<br />
手机：15108225374 蒋女士<br />
地址：成都市青羊区红碾村（青羊驾校旁）<br />
网址：www.mubian.com
                </div>
            </div>
            <div class="ab_right">
            	<div class="position">木匾系列</div>
                <div class="path">当前位置：首页->产品展示->木匾系列</div>
                <div class="about_content">
                	<ul>
                    	<li class="pt_li">                
							<a href="#"><img src="images/1.jpg"/></a>
						</li>
                        <li class="pt_li">                
							<a href="#"><img src="images/1.jpg"/></a>
						</li>
                        <li class="pt_li">                
							<a href="#"><img src="images/1.jpg"/></a>
						</li>
                        <li class="pt_li">                
							<a href="#"><img src="images/1.jpg"/></a>
						</li>
                        <li class="pt_li">                
							<a href="#"><img src="images/1.jpg"/></a>
						</li>
                        <li class="pt_li">                
							<a href="#"><img src="images/1.jpg"/></a>
						</li>
                        <li class="pt_li">                
							<a href="#"><img src="images/1.jpg"/></a>
						</li>
                        <li class="pt_li">                
							<a href="#"><img src="images/1.jpg"/></a>
						</li>
                        <li class="pt_li">                
							<a href="#"><img src="images/1.jpg"/></a>
						</li>
                       
                    </ul>
                     <div class="page"><a href="#">首页</a><a href="#">上一页</a><a href="#">下一页</a><a href="#">尾页</a><a href="#">共8页</a></div>
                </div>
            </div>
         </div>
     </div>
</div>

<!--footer-->
<jsp:include flush="true" page="/include/footer.jsp" />

</body>
</html>
