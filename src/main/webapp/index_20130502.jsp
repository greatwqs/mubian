<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>木匾网站首页</title>
		<base href="<%=basePath%>"/>
		<link rel="stylesheet" type="text/css" href="styles/style.css" />
	</head>
	<body>
		<jsp:include flush="true" page="/include/header.jsp"  />
		<!-- header -->
		
		<!--关于我们地址产品-->
		<div class="about">
			<div class="w955">
				<div class="box">
					<div class="small_flash">
						<img src="images/i_17.jpg" width="263" height="158" />
					</div>
					<div class="about_us">
						本公司是专业从事标识标牌，木制牌匾，木刻，木质景区标识标牌、木简、屏风、对联、门牌、吊牌、花车、垃圾桶、木刻字画、酒柜等的设计与制作,本公司以诚信为本，质量第一的原则，制定了自己的价值准则...
						<a href="ourCompanyInfo.html">[+了解详细]</a>
					</div>
					<div class="coontact">
						电话：028-61677937
						<br />
						手机：15108225374 蒋女士
						<br />
						地址：成都市青羊区红碾村5组33号附1号
						<br />
						网址：www.mubian.com

					</div>
					<div class="product">
						<div class="product_top">
							<div class="product_list">
								<ul>
									<li>
										<a href="listProducts.html?type=1"><img src="images/bp.jpg" width="84"
												height="22" />
										</a>
									</li>
									<li>
										<a href="listProducts.html?type=8"><img src="images/bp_26.jpg" width="104"
												height="22" />
										</a>
									</li>
									<li>
										<a href="listProducts.html?type=3"><img src="images/mj_32.jpg" width="87"
												height="22" />
										</a>
									</li>
									<li>
										<a href="listProducts.html?type=6"><img src="images/mp_28.jpg" width="111"
												height="22" />
										</a>
									</li>
									<li>
										<a href="listProducts.html?type=4"><img src="images/pf_30.jpg" width="85"
												height="22" />
										</a>
									</li>
								</ul>
							</div>
							<div class="more">
								<a href="listProducts.html">更多>></a>
							</div>
						</div>
						<div class="product_img">
							<div class="r_left">
								<a href="#"><img src="images/left.jpg" width="16"
										height="20" />
								</a>
							</div>
							<div class="product_img_list">
								<ul>
									<li>
										<div class="product_name">
											古镇标志系列
										</div>
										<div class="product_name_img">
											<a href="#"><img src="images/index4_32.jpg" width="187"
													height="174" />
											</a>
										</div>
									</li>
									<li>
										<div class="product_name">
											古镇标志系列
										</div>
										<div class="product_name_img">
											<a href="#"><img src="images/index4_32.jpg" width="187"
													height="174" />
											</a>
										</div>
									</li>
									<li>
										<div class="product_name">
											古镇标志系列
										</div>
										<div class="product_name_img">
											<a href="#"><img src="images/index4_32.jpg" width="187"
													height="174" />
											</a>
										</div>
									</li>
									<li>
										<div class="product_name">
											古镇标志系列
										</div>
										<div class="product_name_img">
											<a href="#"><img src="images/index4_32.jpg" width="187"
													height="174" />
											</a>
										</div>
									</li>
								</ul>
							</div>
							<div class="r_right">
								<a href="#"><img src="images/right.jpg" width="16"
										height="20" />
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--footer-->
		<jsp:include flush="true" page="/include/footer.jsp" />
	</body>
</html>
