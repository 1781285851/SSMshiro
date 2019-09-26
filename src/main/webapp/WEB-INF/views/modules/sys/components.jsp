<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
String path = request.getContextPath();
// 获得本项目的地址(例如: http://localhost:8080/ssm/)赋值给basePath变量    
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";    
// 将 ”项目路径basePath” 放入pageContext中，待以后用EL表达式读出。    
pageContext.setAttribute("basePath",basePath);    
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>Components - Ready Bootstrap Dashboard</title>
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
	<script type="text/javascript" src="${pageScope.basePath}static/modules/sys/components.js"></script>
</head>
<body>



<!-- 员工添加的模态框 -->
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
      <h4 class="modal-title" id="myModalLabel">照片</h4>
      </div>
      <form action="save" method="post" enctype="multipart/form-data">
      	 <div class="col-sm-12" id="identityCard">
		</div>
		<img src="" alt="该会员未添加照片" class="img-rounded" height="200"><br>
		图片:<input type="file" name="file"> <br>
      	<div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button  type="submit" class="btn btn-primary">上传</button>
      </div>
    </div>
  </div>
</div>









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
						<li class="nav-item active">
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
						<li class="nav-item">
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
							<div class="col-md-12">
								<div class="card">
									<div class="card-header">
										<h4 class="card-title">会员管理</h4>
										<p class="card-category">按照单条件或者多条件进行查询</p>
									</div>
									<div class="row">
										<p class="demo">
												<div class="col-md-2">
													<div class="form-group has-success">
													姓名：
														<input type="text" value="" class="form-control" id="yhm"/>
													</div>
												</div>
												<div class="col-md-2">
													<div class="form-group has-success">
													会员卡号:
														<input type="text" value="" class="form-control" id="hykh"/>
													</div>
												</div>
												<div class="col-md-2">
													<div class="form-group has-success">
													注册人员：
														<input type="text" value="" class="form-control" id="czry"/>
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group has-success">
													联系电话：
														<input type="text" value="" class="form-control" id="lxdh"/>
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group has-success">
													身份证号码：
														<input type="text" value="" class="form-control" id="sfzhm"/>
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group has-success">
													性别:
													<select class="form-control input-fixed" id="xb">
														<option value="2">请选择性别....</option>
														<option value="0">女</option>
														<option value="1">男</option>
														
													</select>
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group has-success">
													舞种：
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
												<div class="col-md-3">
													<div class="form-group has-success">
													开始时间：
														<input class="form-control" id="startdate" type="date"/>
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group has-success">
													结束时间：
														<input class="form-control" id="enddate" type="date"/>
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group has-success">
														<button class="btn btn-primary" type="button" onclick="selectMenberAll()">查询</button>
														<button class="btn btn-info" type="button" onclick="Condition()">重置</button>
												</div>
											</div>
										</p>
									</div>
							
								<!-- 搭建显示页面 -->
								<div class="container">
									<!-- 标题 -->
									<div class="row">
										<div class="col-md-12">
										<p class="card-category">对单条件或者多条件查询到的数据以及不按条件查询所有数据进行显示</p>
										</div>
									</div>
									<!-- 显示表格数据 -->
									<div class="row">
										<div class="col-md-12">
											<table class="table table-hover" id="emps_table">
												<thead>
												<tr>
													<th>#</th>
													<th>姓名</th>
													<th>性别</th>
													<th>会员卡号</th>
													<th>舞种名称</th>
													<th>身份证号码</th>
													<th>电话</th>
													<th>创建时间</th>
													<th>注册人</th>
													<th>操作</th>
												</tr>
												</thead>
												<tbody>
					
												</tbody>
											</table>
										</div>
									</div>
							
									<!-- 显示分页信息 -->
									<div class="row">
										<!--分页文字信息  -->
										<div class="col-md-6" id="page_info_area"></div>
										<!-- 分页条信息 -->
										<div class="col-md-6" id="page_nav_area">
										
										</div>
									</div>
								</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="modalUpdate" tabindex="-1" role="dialog" aria-labelledby="modalUpdatePro" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header bg-primary">
					<h6 class="modal-title"><i class="la la-frown-o"></i> Under Development</h6>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body text-center">									
					<p>Currently the pro version of the <b>Ready Dashboard</b> Bootstrap is in progress development</p>
					<p>
					<b>We'll let you know when it's done</b></p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</body>

<script>
	$( function() {
		$( "#slider" ).slider({
			range: "min",
			max: 100,
			value: 40,
		});
		$( "#slider-range" ).slider({
			range: true,
			min: 0,
			max: 500,
			values: [ 75, 300 ]
		});
	} );
</script>
</html>