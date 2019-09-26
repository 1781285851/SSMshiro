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
	<title>Typography - Ready Bootstrap Dashboard</title>
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
						<li class="nav-item active">
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
						<h4 class="page-title">Typography</h4>
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="card-header">
										<div class="card-title">Card Title</div>
										<div class="card-category">Card Category</div>
									</div>
									<div class="card-body">
										<table class="table table-typo">
											<tbody>
												<tr>
													<td>
														<p>Header 1</p>

													</td>
													<td><span class="h1">h1. Bootstrap heading</span></td>
												</tr>
												<tr>
													<td>
														<p>Header 2</p>

													</td>
													<td><span class="h2">h2. Bootstrap heading</span></td>
												</tr>
												<tr>
													<td>
														<p>Header 3</p>

													</td>
													<td><span class="h3">h3. Bootstrap heading</span></td>
												</tr>
												<tr>
													<td>
														<p>Header 4</p>

													</td>
													<td><span class="h4">h4. Bootstrap heading</span></td>
												</tr>
												<tr>
													<td>
														<p>Header 5</p>

													</td>
													<td><span class="h5">h5. Bootstrap heading</span></td>
												</tr>
												<tr>
													<td>
														<p>Header 5</p>

													</td>
													<td><span class="h6">h6. Bootstrap heading</span></td>
												</tr>
												<tr>
													<td>
														<p>Paragraph</p>

													</td>
													<td><p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p></span></td>
												</tr>
												<tr>
													<td>
														<p>Paragraph Lead</p>

													</td>
													<td><p class="lead">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p></td>
												</tr>
												<tr>
													<td>
														<p>Quote</p>

													</td>
													<td><blockquote>
														<p class="blockquote blockquote-primary">
															"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
															<br>
															<br>
															<small>
																- Noaa
															</small>
														</p>
													</blockquote></td>
												</tr>
												<tr>
													<td>
														<p>Primary Text</p>

													</td>
													<td><p class="text-primary">Lorem Ipsum is simply dummy text of the printing and typesetting industry...</p></span></td>
												</tr>
												<tr>
													<td>
														<p>Info Text</p>

													</td>
													<td><p class="text-info">Lorem Ipsum is simply dummy text of the printing and typesetting industry...</p></span></td>
												</tr>
												<tr>
													<td>
														<p>Success Text</p>

													</td>
													<td><p class="text-success">Lorem Ipsum is simply dummy text of the printing and typesetting industry...</p></span></td>
												</tr>
												<tr>
													<td>
														<p>Warning Text</p>

													</td>
													<td><p class="text-warning">Lorem Ipsum is simply dummy text of the printing and typesetting industry...</p></span></td>
												</tr>
												<tr>
													<td>
														<p>Danger Text</p>

													</td>
													<td><p class="text-danger">Lorem Ipsum is simply dummy text of the printing and typesetting industry...</p></span></td>
												</tr>
												<tr>
													<td>
														<p>Muted Text</p>

													</td>
													<td><p class="text-muted">Lorem Ipsum is simply dummy text of the printing and typesetting industry...</p></span></td>
												</tr>
											</tbody>
										</table>
									</div>
									<div class="card-footer">
										<hr>
										Card Footer
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
</html>