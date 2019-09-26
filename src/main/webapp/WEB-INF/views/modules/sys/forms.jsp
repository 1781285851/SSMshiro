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
	<title>Forms - Ready Bootstrap Dashboard</title>
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
						<li class="nav-item active">
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
						<h4 class="page-title">Forms</h4>
						<div class="row">
							<div class="col-md-6">
								<div class="card">
									<div class="card-header">
										<div class="card-title">Base Form Control</div>
									</div>
									<div class="card-body">
										<div class="form-group">
											<label for="email">Email Address</label>
											<input type="email" class="form-control" id="email" placeholder="Enter Email">
											<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
										</div>
										<div class="form-group">
											<label for="password">Password</label>
											<input type="password" class="form-control" id="password" placeholder="Password">
										</div>
										<div class="form-group form-inline">
											<label for="inlineinput" class="col-md-3 col-form-label">Inline Input</label>
											<div class="col-md-9 p-0">
												<input type="text" class="form-control input-full" id="inlineinput" placeholder="Enter Input">
											</div>
										</div>
										<div class="form-group has-success">
											<label for="successInput">Success Input</label>
											<input type="text" id="successInput" value="Success" class="form-control">
										</div>
										<div class="form-group has-error has-feedback">
											<label for="errorInput">Error Input</label>
											<input type="text" id="errorInput" value="Error" class="form-control">
											<small id="emailHelp" class="form-text text-muted">Please provide a valid informations.</small>
										</div>
										<div class="form-group">
											<label for="disableinput">Disable Input</label>
											<input type="text" class="form-control" id="disableinput" placeholder="Enter Input" disabled>
										</div>
										<div class="form-check">
											<label>Gender</label><br/>
											<label class="form-radio-label">
												<input class="form-radio-input" type="radio" name="optionsRadios" value=""  checked="">
												<span class="form-radio-sign">Male</span>
											</label>
											<label class="form-radio-label ml-3">
												<input class="form-radio-input" type="radio" name="optionsRadios" value="">
												<span class="form-radio-sign">Female</span>
											</label>
										</div>
										<div class="form-group">
											<label class="control-label">
												Static
											</label> <!----> <p class="form-control-static">hello@themekita.com</p> <!---->  <!----></div>
											<div class="form-group">
												<label for="exampleFormControlSelect1">Example select</label>
												<select class="form-control" id="exampleFormControlSelect1">
													<option>1</option>
													<option>2</option>
													<option>3</option>
													<option>4</option>
													<option>5</option>
												</select>
											</div>
											<div class="form-group">
												<label for="exampleFormControlSelect2">Example multiple select</label>
												<select multiple class="form-control" id="exampleFormControlSelect2">
													<option>1</option>
													<option>2</option>
													<option>3</option>
													<option>4</option>
													<option>5</option>
												</select>
											</div>
											<div class="form-group">
												<label for="exampleFormControlFile1">Example file input</label>
												<input type="file" class="form-control-file" id="exampleFormControlFile1">
											</div>
											<div class="form-group">
												<label for="comment">Comment</label>
												<textarea class="form-control" id="comment" rows="5">

												</textarea>
											</div>
											<div class="form-check">
												<label class="form-check-label">
													<input class="form-check-input" type="checkbox" value="">
													<span class="form-check-sign">Agree with terms and conditions</span>
												</label>
											</div>
										</div>
										<div class="card-action">
											<button class="btn btn-success">Submit</button>
											<button class="btn btn-danger">Cancel</button>
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="card">
										<div class="card-header">
											<div class="card-title">Form Control Styles</div>
										</div>
										<div class="card-body">
											<div class="form-group">
												<label for="squareInput">Square Input</label>
												<input type="text" class="form-control input-square" id="squareInput" placeholder="Square Input">
											</div>
											<div class="form-group">
												<label for="squareSelect">Square Select</label>
												<select class="form-control input-square" id="squareSelect">
													<option>1</option>
													<option>2</option>
													<option>3</option>
													<option>4</option>
													<option>5</option>
												</select>
											</div>
											<div class="form-group">
												<label for="pillInput">Pill Input</label>
												<input type="text" class="form-control input-pill" id="pillInput" placeholder="Pill Input">
											</div>
											<div class="form-group">
												<label for="pillSelect">Pill Select</label>
												<select class="form-control input-pill" id="pillSelect">
													<option>1</option>
													<option>2</option>
													<option>3</option>
													<option>4</option>
													<option>5</option>
												</select>
											</div>
											<div class="form-group">
												<label for="solidInput">Solid Input</label>
												<input type="text" class="form-control input-solid" id="solidInput" placeholder="Solid Input">
											</div>
											<div class="form-group">
												<label for="solidSelect">Solid Select</label>
												<select class="form-control input-solid" id="solidSelect">
													<option>1</option>
													<option>2</option>
													<option>3</option>
													<option>4</option>
													<option>5</option>
												</select>
											</div>											
										</div>
										<div class="card-action">
											<button class="btn btn-success">Submit</button>
											<button class="btn btn-danger">Cancel</button>
										</div>
									</div>
									<div class="card">
										<div class="card-header">
											<div class="card-title">Form Control Styles</div>
										</div>
										<div class="card-body">
											<div class="form-group">
												<label for="largeInput">Large Input</label>
												<input type="text" class="form-control form-control-lg" id="largeInput" placeholder="Large Input">
											</div>
											<div class="form-group">
												<label for="largeInput">Default Input</label>
												<input type="text" class="form-control form-control" id="defaultInput" placeholder="Default Input">
											</div>
											<div class="form-group">
												<label for="smallInput">Small Input</label>
												<input type="text" class="form-control form-control-sm" id="smallInput" placeholder="Small Input">
											</div>
											<div class="form-group">
												<label for="largeSelect">Large Select</label>
												<select class="form-control form-control-lg" id="largeSelect">
													<option>1</option>
													<option>2</option>
													<option>3</option>
													<option>4</option>
													<option>5</option>
												</select>
											</div>
											<div class="form-group">
												<label for="defaultSelect">Default Select</label>
												<select class="form-control form-control" id="defaultSelect">
													<option>1</option>
													<option>2</option>
													<option>3</option>
													<option>4</option>
													<option>5</option>
												</select>
											</div>
											<div class="form-group">
												<label for="smallSelect">Small Select</label>
												<select class="form-control form-control-sm" id="smallSelect">
													<option>1</option>
													<option>2</option>
													<option>3</option>
													<option>4</option>
													<option>5</option>
												</select>
											</div>
										</div>
										<div class="card-action">
											<button class="btn btn-success">Submit</button>
											<button class="btn btn-danger">Cancel</button>
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
										<a class="nav-link" href="#">
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
</html>