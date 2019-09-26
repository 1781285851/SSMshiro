<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%    
String path = request.getContextPath();    
// 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量    
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";    
// 将 ”项目路径basePath” 放入pageContext中，待以后用EL表达式读出。    
pageContext.setAttribute("basePath",basePath);    
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1; charset=UTF-8" charset="UTF-8"/>
	<title>Notifications - Ready Bootstrap Dashboard</title>
	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
	<link rel="stylesheet" href="${pageScope.basePath}static/modules/sys/assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
	<link rel="stylesheet" href="${pageScope.basePath}static/modules/sys/assets/css/ready.css">
	<link rel="stylesheet" href="${pageScope.basePath}static/modules/sys/assets/css/demo.css">
	<script src="${pageScope.basePath}static/modules/sys/assets/js/core/jquery.3.2.1.min.js"></script>
<script type="text/javascript" src="${pageScope.basePath}static/modules/sys/assets/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageScope.basePath}static/modules/sys/assets/js/core/popper.min.js"></script>
<script type="text/javascript" src="${pageScope.basePath}static/modules/sys/assets/js/core/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageScope.basePath}static/modules/sys/assets/js/plugin/chartist/chartist.min.js"></script>
<script type="text/javascript" src="${pageScope.basePath}static/modules/sys/assets/js/plugin/chartist/plugin/chartist-plugin-tooltip.min.js"></script>
<script type="text/javascript" src="${pageScope.basePath}static/modules/sys/assets/js/plugin/bootstrap-notify/bootstrap-notify.min.js"></script>
<script type="text/javascript" src="${pageScope.basePath}static/modules/sys/assets/js/plugin/bootstrap-toggle/bootstrap-toggle.min.js"></script>
<script type="text/javascript" src="${pageScope.basePath}static/modules/sys/assets/js/plugin/jquery-mapael/jquery.mapael.min.js"></script>
<script type="text/javascript" src="${pageScope.basePath}static/modules/sys/assets/js/plugin/jquery-mapael/maps/world_countries.min.js"></script>
<script type="text/javascript" src="${pageScope.basePath}static/modules/sys/assets/js/plugin/chart-circle/circles.min.js"></script>
<script type="text/javascript" src="${pageScope.basePath}static/modules/sys/assets/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>
<script type="text/javascript" src="${pageScope.basePath}static/modules/sys/assets/js/ready.min.js"></script>
	
	 <script type="text/javascript" src="${pageScope.basePath}static/modules/sys/memberRegistration.js"></script>
</head>
<body>
	<div class="wrapper">
	<!-- 这里引入jsp。里面是公共页面，是页面最上侧一栏 -->
	<jsp:include page="common.jsp" />
			<!-- 显示左侧一栏的信息 -->
			<div class="sidebar">
				<div class="scrollbar-inner sidebar-wrapper">
					<div class="user">
						<div class="info">
							<a class="" data-toggle="collapse" href="#collapseExample" aria-expanded="true">
								<span>
									<span class="lead"><%=session.getAttribute("name")%></span>
								</span>
							</a>
							<div class="clearfix"></div>

						</div>
					</div>
		
					
					<ul class="nav">
						<li class="nav-item ">
						<shiro:hasAnyRoles name="T1,T2">
							<a href="dashboard">
								<i class="la la-dashboard"></i>
								<p>首页</p>
								<span class="badge badge-count">5</span>
							</a>
						</shiro:hasAnyRoles>	
						</li>
						<li class="nav-item">
						<shiro:hasAnyRoles name="T1,T2">
							<a href="components">
								<i class="la la-table"></i>
								<p>Components</p>
								<span class="badge badge-count">14</span>
							</a>
						</shiro:hasAnyRoles>	
						</li>
						<li class="nav-item">
						<shiro:hasAnyRoles name="T1,T2">
							<a href="forms">
								<i class="la la-keyboard-o"></i>
								<p>Forms</p>
								<span class="badge badge-count">50</span>
							</a>
						</shiro:hasAnyRoles>	
						</li>
						<li class="nav-item">
						<shiro:hasAnyRoles name="T1,T2">
							<a href="tables">
								<i class="la la-th"></i>
								<p>tables</p>
								<span class="badge badge-count">6</span>
							</a>
						</shiro:hasAnyRoles>	
						</li>
						<li class="nav-item active">
						<shiro:hasAnyRoles name="T1,T2">
							<a href="memberRegistration">
								<i class="la la-bell"></i>
								<p>会员注册</p>
								<span class="badge badge-success">3</span>
							</a>
						</shiro:hasAnyRoles>	
						</li>
						<li class="nav-item">
						<shiro:hasAnyRoles name="T1,T2">
							<a href="typography">
								<i class="la la-font"></i>
								<p>Typography</p>
								<span class="badge badge-danger">25</span>
							</a>
						</shiro:hasAnyRoles>
						</li>
						<li class="nav-item">
							<shiro:hasRole name="T1">
							<a href="icons">
								<i class="la la-fonticons"></i>
								<p>Icons</p>
							</a>
							</shiro:hasRole>
						</li>
						<li class="nav-item update-pro">
							<button  data-toggle="modal" data-target="#modalUpdate">
								<i class="la la-hand-pointer-o"></i>
								<p>Update To Pro</p>
							</button>
						</li>
					</ul>
				</div>
			</div>
			<!-- 显示右侧一栏的信息 -->
			<div class="main-panel">
				<div class="content">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-4">
								<div class="card">
									<div class="card-body">
										<div class="form">
										<div class="panel panel-default">
											<form class="form-horizontal">
											 <div class="form-group">
											    <div class="col-sm-12">
											     <label for="exampleInputEmail1">会员卡号：</label>
											     <input type="text" class="form-control" id="hykh" placeholder="请输入会员卡号">
											    </div>
											  </div>
											  <div class="form-group">
											    <div class="col-sm-12">
											    <label for="exampleInputEmail1">会员名：</label>
											      <input type="text" class="form-control" id="yhm" placeholder="请输入会员名">
											    </div>
											  </div>
											  <div class="form-group">
											    <div class="col-sm-12">
											    <label for="exampleInputEmail1">身份证号码：</label>
											      <input type="text" class="form-control" id="sfzhm" placeholder="请输入身份证号码" onblur="myFunction()">
											      <p id="message" style="font-size:20px;color:red"></p>
											    </div>
											  </div>
											  <div class="form-group">
											    <div class="col-sm-12">
											    <label for="exampleInputEmail1">联系电话：</label>
											      <input type="text" class="form-control" id="lxdh" placeholder="请输入联系电话">
											    </div>
											  </div>
											  <div class="form-group">
											    <div class="col-sm-12">
											    <label for="exampleInputEmail1">QQ：</label>
											      <input type="text" class="form-control" id="qq" placeholder="请输入QQ">
											    </div>
											  </div>
											  
										   </form>
										</div>
									</div>
								</div>
							</div>
						</div>
							<div class="col-md-4">
								<div class="card">
									<div class="card-body">
										<div class="form">
										<div class="panel panel-default">
											<form class="form-horizontal">
											<div class="form-group">
											    <div class="col-sm-12">
											    <label for="exampleInputEmail1">微信：</label>
											      <input type="text" class="form-control" id="wx" placeholder="请输入微信">
											    </div>
											  </div>
											  <div class="form-group">
											    <div class="col-sm-12">
											     <label for="exampleInputEmail1">注册人：</label>
											      <input type="text" class="form-control" disabled="disabled" id="czry" placeholder="<%=session.getAttribute("name")%>">
											    </div>
											  </div>
											  <div class="form-group">
												<div class="col-sm-12">
												<label for="exampleInputEmail1">性别：</label>
													<select class="form-control input-fixed" id="xb">
														<option value="2">请选择性别....</option>
														<option value="0">女</option>
														<option value="1">男</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-12">
												<label for="exampleInputEmail1">舞种：</label>
													<select class="form-control input-fixed" id="wz">
														<option value="0">请选择舞种....</option>
														<option value="1">Breaking</option>
														<option value="2">Poppin</option>
														<option value="3">Locking</option>
														<option value="4">HipHop</option>
														<option value="5">Jazz</option>
														<option value="6">Shuffle</option>
														<option value="7">Urban</option>
														<option value="8">Wacking</option>
													</select>
												</div>
											</div>
											<div class="modal-footer">
												<button class="btn btn-primary" type="button" onclick="registerMember()">注册</button>
												<button class="btn btn-info" type="button" onclick="resetCondition()">重置</button>
											  </div>
										   </form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
</body>




</html>