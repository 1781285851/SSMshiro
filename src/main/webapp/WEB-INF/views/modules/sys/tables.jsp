<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<title>Tables - Ready Bootstrap Dashboard</title>
	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
	<link rel="stylesheet" href="${pageScope.basePath}static/modules/sys/assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
	<link rel="stylesheet" href="${pageScope.basePath}static/modules/sys/assets/css/ready.css">
	<link rel="stylesheet" href="${pageScope.basePath}static/modules/sys/assets/css/demo.css">
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
						<li class="nav-item active">
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
						<h4 class="page-title">Tables</h4>
						<div class="row">
							<div class="col-md-6">
								<div class="card">
									<div class="card-header">
										<div class="card-title">Basic Table</div>
									</div>
									<div class="card-body">
										<div class="card-sub">									
											This is the basic table view of the ready dashboard :
										</div>
										<table class="table mt-3">
											<thead>
												<tr>
													<th scope="col">#</th>
													<th scope="col">First</th>
													<th scope="col">Last</th>
													<th scope="col">Handle</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>1</td>
													<td>Mark</td>
													<td>Otto</td>
													<td>@mdo</td>
												</tr>
												<tr>
													<td>2</td>
													<td>Jacob</td>
													<td>Thornton</td>
													<td>@fat</td>
												</tr>
												<tr>
													<td>3</td>
													<td colspan="2">Larry the Bird</td>
													<td>@twitter</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
								<div class="card">
									<div class="card-header">
										<div class="card-title">Striped Rows</div>
									</div>
									<div class="card-body">
										<div class="card-sub">											
											Add <code class="highlighter-rouge">.table-striped</code> to rows the striped table
										</div>
										<table class="table table-striped mt-3">
											<thead>
												<tr>
													<th scope="col">#</th>
													<th scope="col">First</th>
													<th scope="col">Last</th>
													<th scope="col">Handle</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>1</td>
													<td>Mark</td>
													<td>Otto</td>
													<td>@mdo</td>
												</tr>
												<tr>
													<td>2</td>
													<td>Jacob</td>
													<td>Thornton</td>
													<td>@fat</td>
												</tr>
												<tr>
													<td>3</td>
													<td colspan="2">Larry the Bird</td>
													<td>@twitter</td>
												</tr>
											</tbody>
										</table>
										<div class="card-sub">
											Add <code class="#highlighter-rouge">.table-striped-bg-*states</code> to change background from striped rows
										</div>
										<table class="table table-striped table-striped-bg-default mt-3">
											<thead>
												<tr>
													<th scope="col">#</th>
													<th scope="col">First</th>
													<th scope="col">Last</th>
													<th scope="col">Handle</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>1</td>
													<td>Mark</td>
													<td>Otto</td>
													<td>@mdo</td>
												</tr>
												<tr>
													<td>2</td>
													<td>Jacob</td>
													<td>Thornton</td>
													<td>@fat</td>
												</tr>
												<tr>
													<td>3</td>
													<td colspan="2">Larry the Bird</td>
													<td>@twitter</td>
												</tr>
											</tbody>
										</table>
										<table class="table table-striped table-striped-bg-danger mt-4">
											<thead>
												<tr>
													<th scope="col">#</th>
													<th scope="col">First</th>
													<th scope="col">Last</th>
													<th scope="col">Handle</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>1</td>
													<td>Mark</td>
													<td>Otto</td>
													<td>@mdo</td>
												</tr>
												<tr>
													<td>2</td>
													<td>Jacob</td>
													<td>Thornton</td>
													<td>@fat</td>
												</tr>
												<tr>
													<td>3</td>
													<td colspan="2">Larry the Bird</td>
													<td>@twitter</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
								<div class="card">
									<div class="card-header">
										<div class="card-title">Responsive Table</div>
									</div>
									<div class="card-body">
										<div class="card-sub">
											Create responsive tables by wrapping any table with <code class="highlighter-rouge">.table-responsive</code> <code class="highlighter-rouge">DIV</code> to make them scroll horizontally on small devices
										</div>
										<div class="table-responsive">
											<table class="table table-bordered">
												<thead>
													<tr>
														<th>#</th>
														<th>Table heading</th>
														<th>Table heading</th>
														<th>Table heading</th>
														<th>Table heading</th>
														<th>Table heading</th>
														<th>Table heading</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<th scope="row">1</th>
														<td>Table cell</td>
														<td>Table cell</td>
														<td>Table cell</td>
														<td>Table cell</td>
														<td>Table cell</td>
														<td>Table cell</td>
													</tr>
													<tr>
														<th scope="row">2</th>
														<td>Table cell</td>
														<td>Table cell</td>
														<td>Table cell</td>
														<td>Table cell</td>
														<td>Table cell</td>
														<td>Table cell</td>
													</tr>
													<tr>
														<th scope="row">3</th>
														<td>Table cell</td>
														<td>Table cell</td>
														<td>Table cell</td>
														<td>Table cell</td>
														<td>Table cell</td>
														<td>Table cell</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="card">
									<div class="card-header">
										<div class="card-title">Hoverable Table</div>
									</div>
									<div class="card-body">
										<table class="table table-hover">
											<thead>
												<tr>
													<th scope="col">#</th>
													<th scope="col">First</th>
													<th scope="col">Last</th>
													<th scope="col">Handle</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>1</td>
													<td>Mark</td>
													<td>Otto</td>
													<td>@mdo</td>
												</tr>
												<tr>
													<td>2</td>
													<td>Jacob</td>
													<td>Thornton</td>
													<td>@fat</td>
												</tr>
												<tr>
													<td>3</td>
													<td colspan="2">Larry the Bird</td>
													<td>@twitter</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
								<div class="card">
									<div class="card-header">
										<div class="card-title">Bordered Table</div>
									</div>
									<div class="card-body">
										<div class="card-sub">
											Add <code class="highlighter-rouge">.table-bordered</code> to create a bordered table
										</div>
										<table class="table table-bordered">
											<thead>
												<tr>
													<th scope="col">#</th>
													<th scope="col">First</th>
													<th scope="col">Last</th>
													<th scope="col">Handle</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>1</td>
													<td>Mark</td>
													<td>Otto</td>
													<td>@mdo</td>
												</tr>
												<tr>
													<td>2</td>
													<td>Jacob</td>
													<td>Thornton</td>
													<td>@fat</td>
												</tr>
												<tr>
													<td>3</td>
													<td colspan="2">Larry the Bird</td>
													<td>@twitter</td>
												</tr>
											</tbody>
										</table>
										<div class="card-sub">											
											You can also add <code class="highlighter-rouge">.table-bordered-bd-*states</code> to change the border color of the table
										</div>
										<table class="table table-bordered table-bordered-bd-warning mt-4">
											<thead>
												<tr>
													<th scope="col">#</th>
													<th scope="col">First</th>
													<th scope="col">Last</th>
													<th scope="col">Handle</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>1</td>
													<td>Mark</td>
													<td>Otto</td>
													<td>@mdo</td>
												</tr>
												<tr>
													<td>2</td>
													<td>Jacob</td>
													<td>Thornton</td>
													<td>@fat</td>
												</tr>
												<tr>
													<td>3</td>
													<td colspan="2">Larry the Bird</td>
													<td>@twitter</td>
												</tr>
											</tbody>
										</table>
										<div class="card-sub">
											It can also add <code class="highlight-rouge">.table-head-bg-*states</code> so that the table header has the same color as the border color of the table
										</div>
										<table class="table table-bordered table-head-bg-info table-bordered-bd-info mt-4">
											<thead>
												<tr>
													<th scope="col">#</th>
													<th scope="col">First</th>
													<th scope="col">Last</th>
													<th scope="col">Handle</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>1</td>
													<td>Mark</td>
													<td>Otto</td>
													<td>@mdo</td>
												</tr>
												<tr>
													<td>2</td>
													<td>Jacob</td>
													<td>Thornton</td>
													<td>@fat</td>
												</tr>
												<tr>
													<td>3</td>
													<td colspan="2">Larry the Bird</td>
													<td>@twitter</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
								<div class="card">
									<div class="card-header">
										<div class="card-title">Table Head States</div>
									</div>
									<div class="card-body">
										<table class="table table-head-bg-success">
											<thead>
												<tr>
													<th scope="col">#</th>
													<th scope="col">First</th>
													<th scope="col">Last</th>
													<th scope="col">Handle</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>1</td>
													<td>Mark</td>
													<td>Otto</td>
													<td>@mdo</td>
												</tr>
												<tr>
													<td>2</td>
													<td>Jacob</td>
													<td>Thornton</td>
													<td>@fat</td>
												</tr>
												<tr>
													<td>3</td>
													<td colspan="2">Larry the Bird</td>
													<td>@twitter</td>
												</tr>
											</tbody>
										</table>
										<table class="table table-head-bg-primary mt-4">
											<thead>
												<tr>
													<th scope="col">#</th>
													<th scope="col">First</th>
													<th scope="col">Last</th>
													<th scope="col">Handle</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>1</td>
													<td>Mark</td>
													<td>Otto</td>
													<td>@mdo</td>
												</tr>
												<tr>
													<td>2</td>
													<td>Jacob</td>
													<td>Thornton</td>
													<td>@fat</td>
												</tr>
												<tr>
													<td>3</td>
													<td colspan="2">Larry the Bird</td>
													<td>@twitter</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<footer class="footer">
					<div class="container-fluid">
						<nav class="pull-left">
							<ul class="nav">
								<li class="nav-item">
									<a class="nav-link" href="#">
										ThemeKita
									</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="#">
										Help
									</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="#license/#free-item">
										Licenses
									</a>
								</li>
							</ul>
						</nav>
						<div class="copyright ml-auto">
							2018, made with <i class="la la-heart heart text-danger"></i> by <a href="#">ThemeKita</a> - More Templates <a href="http://www.cssmoban.com/" target="_blank" title="æ¨¡æ¿ä¹å®¶">æ¨¡æ¿ä¹å®¶</a> - Collect from <a href="http://www.cssmoban.com/" title="ç½é¡µæ¨¡æ¿" target="_blank">ç½é¡µæ¨¡æ¿</a></div>				
					</div>
				</footer>
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
<script src="${pageScope.basePath}static/modules/sys/assets/js/core/jquery.3.2.1.min.js"></script>
<script src="${pageScope.basePath}static/modules/sys/assets/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
<script src="${pageScope.basePath}static/modules/sys/assets/js/core/popper.min.js"></script>
<script src="${pageScope.basePath}static/modules/sys/assets/js/core/bootstrap.min.js"></script>
<script src="${pageScope.basePath}static/modules/sys/assets/js/plugin/chartist/chartist.min.js"></script>
<script src="${pageScope.basePath}static/modules/sys/assets/js/plugin/chartist/plugin/chartist-plugin-tooltip.min.js"></script>
<script src="${pageScope.basePath}static/modules/sys/assets/js/plugin/bootstrap-notify/bootstrap-notify.min.js"></script>
<script src="${pageScope.basePath}static/modules/sys/assets/js/plugin/bootstrap-toggle/bootstrap-toggle.min.js"></script>
<script src="${pageScope.basePath}static/modules/sys/assets/js/plugin/jquery-mapael/jquery.mapael.min.js"></script>
<script src="${pageScope.basePath}static/modules/sys/assets/js/plugin/jquery-mapael/maps/world_countries.min.js"></script>
<script src="${pageScope.basePath}static/modules/sys/assets/js/plugin/chart-circle/circles.min.js"></script>
<script src="${pageScope.basePath}static/modules/sys/assets/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>
<script src="${pageScope.basePath}static/modules/sys/assets/js/ready.min.js"></script>
<script>
	$('#displayNotif').on('click', function(){
		var placementFrom = $('#notify_placement_from option:selected').val();
		var placementAlign = $('#notify_placement_align option:selected').val();
		var state = $('#notify_state option:selected').val();
		var style = $('#notify_style option:selected').val();
		var content = {};

		content.message = 'Turning standard Bootstrap alerts into "notify" like notifications';
		content.title = 'Bootstrap notify';
		if (style == "withicon") {
			content.icon = 'la la-bell';
		} else {
			content.icon = 'none';
		}
		content.url = 'index.html';
		content.target = '_blank';

		$.notify(content,{
			type: state,
			placement: {
				from: placementFrom,
				align: placementAlign
			},
			time: 1000,
		});
	});
</script>
</html>