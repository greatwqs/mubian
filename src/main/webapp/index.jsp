<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>首页 - 成都四方标识牌制作中心</title>
		<base href="<%=basePath%>"/>
		<meta name="keywords" content="木匾木刻,木匾,木刻,标识牌制作,成都四方标识牌制作中心" />
		<meta name="description" content="木匾木刻,成都四方标识牌制作中心" />
		<link rel="stylesheet" type="text/css" href="styles/style.css" />
		<link rel="stylesheet" type="text/css" href="styles/index_tab.css" />
		<script language="javascript" type="text/javascript" src="scripts/indexAjax.js"></script> 
	</head>
	<body>
		<jsp:include flush="true" page="/include/header.jsp"  />
		<!-- header -->
		
		<!--关于我们地址产品-->
		<div class="about">
			<div class="w955">
				<div class="box">
					<div class="small_flash">
						<div id="fade_focus">
							<div class="loading">
								Loading...
								<br />
								<img src="images/logings.gif" width="100" height="100" />
							</div>
							<ul class="tab_pic">
								<li>
									<img class="tab_ele" src="upload/index/1.png" width="263"
										height="158" alt="咖啡厅" />
								</li>
								<li>
									<img class="tab_ele" src="upload/index/2.png" width="263"
										height="158" alt="统一企业" />
								</li>
								<li>
									<img class="tab_ele" src="upload/index/3.png" width="263"
										height="158" alt="正宗老杭州" />
								</li>
							</ul>
						</div>
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
						地址：成都市青羊区红碾村（青羊驾校旁）
						<br />
						网址：www.sifangwood.com

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
										<a href="listProducts.html?type=2"><img src="images/pf_30.jpg" width="85"
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
								<a href="javascript:previouspage()"><img src="images/left.jpg" width="16"
										height="20" />
								</a>
							</div>
							<div class="product_img_list" name="product_img_list" id="product_img_list">
							</div>
							<div class="r_right">
								<a href="javascript:nextpage()"><img src="images/right.jpg" width="16"
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
<!-- 首页左侧tab的images图片样式 -->
<script language="javascript" type="text/javascript">
var s=function(){
var interv=2000; //切换时间
var interv2=10; //切换速速
var opac1=80; //文字背景的透明度
var source="fade_focus" //图片容器的id名称
//获取对象
function getTag(tag,obj){if(obj==null){return document.getElementsByTagName(tag)}else{return obj.getElementsByTagName(tag)}}
function getid(id){return document.getElementById(id)};
var opac=0,j=0,t=63,num,scton=0,timer,timer2,timer3;var id=getid(source);id.removeChild(getTag("div",id)[0]);var li=getTag("li",id);var div=document.createElement("div");var title=document.createElement("div");var span=document.createElement("span");var button=document.createElement("div");button.className="button";for(var i=0;i<li.length;i++){var a=document.createElement("a");a.innerHTML=i+1;a.onclick=function(){clearTimeout(timer);clearTimeout(timer2);clearTimeout(timer3);j=parseInt(this.innerHTML)-1;scton=0;t=63;opac=0;fadeon();};a.className="b1";a.onmouseover=function(){this.className="b2"};a.onmouseout=function(){this.className="b1";sc(j)};button.appendChild(a);}
//控制图层透明度
function alpha(obj,n){if(document.all){obj.style.filter="alpha(opacity="+n+")";}else{obj.style.opacity=(n/100);}}
//控制焦点按钮
function sc(n){for(var i=0;i<li.length;i++){button.childNodes[i].className="b1"};button.childNodes[n].className="b2";}
title.className="num_list";title.appendChild(span);alpha(title,opac1);id.className="d1";div.className="d2";id.appendChild(div);id.appendChild(title);id.appendChild(button);
//渐显
var fadeon=function(){opac+=5;div.innerHTML=li[j].innerHTML;span.innerHTML=getTag("img",li[j])[0].alt;alpha(div,opac);if(scton==0){sc(j);num=-2;scrolltxt();scton=1};if(opac<100){timer=setTimeout(fadeon,interv2)}else{timer2=setTimeout(fadeout,interv);};}
//渐隐
var fadeout=function(){opac-=5;div.innerHTML=li[j].innerHTML;alpha(div,opac);if(scton==0){num=2;scrolltxt();scton=1};if(opac>0){timer=setTimeout(fadeout,interv2)}else{if(j<li.length-1){j++}else{j=0};fadeon()};}
//滚动文字
var scrolltxt=function(){t+=num;span.style.marginTop=t+"px";if(num<0&&t>3){timer3=setTimeout(scrolltxt,interv2)}else if(num>0&&t<62){timer3=setTimeout(scrolltxt,interv2)}else{scton=0}};
fadeon();
// 首页底部第一次Ajax访问
index_ajax_first_visit();
}
//初始化
window.onload=s;
</script>
</html>
