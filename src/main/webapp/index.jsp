<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 引入jquery -->
<script type="text/javascript" src="static/js/jquery-2.1.4.min"></script>
<!-- 引入样式 -->
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
		<%
	//第一次访问http://localhost:8080/SSMshiro会跳转到配置的<property name="loginUrl" value="login"/>login页面，
	//当再次访问，由于第一次已经登陆了，所以会直接跳转当前页面
   	response.sendRedirect("/SSMshiro/dashboard");     //重定向
   	//request.getRequestDispatcher("/dashboard").forward(request,response);		//转发
   	//目前两张方法都可以
%>
	
</body>
</html>