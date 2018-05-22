<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String errorString = (String)request.getAttribute("ErrorString");
if(errorString==null || errorString.trim().length()==0){
	errorString = "";
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;"/>
<base href="<%=basePath%>"/>
<title>后台管理系统 - 管理员登陆</title>
<link href="admin/styles/base.css" rel="stylesheet" type="text/css" />
<link href="admin/styles/login.css" rel="stylesheet" type="text/css" />
<script src="scripts/jquery.js" language="javascript" type="text/javascript" ></script>
<script src="admin/scripts/changepic.js" language="javascript" type="text/javascript" ></script>
</head>
<body>
<div id="login-box">
   <div class="login-top"><a href="<%=basePath %>" title="返回网站主页">返回网站主页</a></div>
   <div class='errorString'><font color="#FF0000"><%=errorString %></font></div>
   <div class='safe-tips'>管理员密码是管理本站的唯一标识，管理密码请不要外泄！</div>   
   <div class="login-main">
    <form name="form1" method="post" action="admin/login.html">
      <dl>
	   <dt>用户名：</dt>
	   <dd><input type="text" name="username"/></dd>
	   <dt>密&nbsp;&nbsp;码：</dt>
	   <dd><input type="password" class="alltxt" name="password"/>
	   </dd>
	   <dt>验证码：</dt>
	   <dd>
	   <input id="vdcode" type="text" name="validate" style="text-transform:uppercase;"/>
	   <img id="vdimgck" align="absmiddle" onclick="this.src=this.src+'?'+Math.random();" 
	        style="cursor:pointer;" alt="看不清？点击更换" src="<%=basePath+"getValidateImage"%>"/>
       </dd>
	   <dt>&nbsp;</dt>
	   <dd>
	   <button type="submit" name="sm1" class="login-btn" onclick="this.form.submit();">登录</button>
	   </dd>
	 </dl>
	</form>
   </div>
   <div class="login-power">
   Powered by<a href="/" title="木匾木刻">
   <strong>木匾木刻</strong></a>&copy; 2012-2013 
   <a href="/" target="_blank">mubian muke</a> Inc.
   </div>
</div>
</body>
</html>
