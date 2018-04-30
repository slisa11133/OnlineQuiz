<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Gentelella Alela! |</title>

<!-- Bootstrap -->
<link
	href="<c:url value="../template/vendors/bootstrap/dist/css/bootstrap.min.css" />"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="<c:url value="../template/vendors/font-awesome/css/font-awesome.min.css" />"
	rel="stylesheet">
<!-- Custom Theme Style -->
<link href="<c:url value="../template/build/css/custom.min.css" />"
	rel="stylesheet">
	<!-- iCheck -->
    <link href="<c:url value="../template/vendors/iCheck/skins/flat/green.css"/>" rel="stylesheet">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="../" class="site_title"><i class="fa fa-paw"></i> <span>Online
								Quiz</span></a>
					</div>

					<div class="clearfix"></div>


					<br />

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<ul class="nav side-menu">
								<li><a href="../user/list"><i class="fa fa-home"></i>
										User Management </a></li>
							</ul>
						</div>

					</div>
					<!-- /sidebar menu -->

				</div>
			</div>

			<!-- top navigation -->
			<div class="top_nav">
				<div class="nav_menu">
					<nav>
						<div class="nav toggle">
							<a id="menu_toggle"><i class="fa fa-bars"></i></a>
						</div>

						<ul class="nav navbar-nav navbar-right">
							<li class=""><a href="javascript:;"
								class="user-profile dropdown-toggle" data-toggle="dropdown"
								aria-expanded="false"> <img
									src="<c:url value="../template/images/img.jpg" />" alt="">${name}
									<span class=" fa fa-angle-down"></span>
							</a>
								<ul class="dropdown-menu dropdown-usermenu pull-right">
									<li><a href="../"><i class="fa fa-sign-out pull-right"></i>
											Log Out</a></li>
								</ul></li>

						</ul>
					</nav>
				</div>
			</div>
			<!-- /top navigation -->
			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>User Management</h3>
						</div>

						<div class="title_right">
							<div
								class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
								<div class="input-group">
									<input type="text" class="form-control"
										placeholder="Search for..."> <span
										class="input-group-btn">
										<button class="btn btn-default" type="button">Go!</button>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="clearfix"></div>

					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>Add New User</h2>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">


									<h2>${msg}</h2>
									<form:form action="saveUser" method="post"
										modelAttribute="user" class="form-horizontal form-label-left">
										<form:hidden path="" />

										<!-- Account -->
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="name">Account <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<form:input path="id" id="id"
													class="form-control col-md-7 col-xs-12" name="id"
													placeholder="please enter account" required="required"
													type="text" maxlength="30" />
											</div>
										</div>
										<!-- Password -->
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="name">Password <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<form:input path="pwd" id="pwd"
													class="form-control col-md-7 col-xs-12" name="pwd"
													placeholder="please enter password" required="required"
													type="text" maxlength="30" />
											</div>
										</div>

										<!-- Name -->
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="name">Name <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<form:input path="name" id="name"
													class="form-control col-md-7 col-xs-12" name="name"
													placeholder="please enter name" required="required"
													type="text" maxlength="30" />
											</div>
										</div>

										<!-- Grade -->
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="name">Grade <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<form:select path="grade" id="grade"
													class="form-control col-md-7 col-xs-12" name="grade"
													placeholder="please enter subject name" required="required"
													type="text" maxlength="30">
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
												</form:select>
											</div>
										</div>

										<!-- Role -->
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="name">Role <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<form:select path="role" id="role"
													class="form-control col-md-7 col-xs-12" name="role"
													placeholder="please enter subject name" required="required"
													type="text" maxlength="30">

													<option value="student">Student</option>
													<option value="teacher">Teacher</option>
													<option value="manager">Manager</option>
												</form:select>

											</div>
										</div>	
										
										<!-- Email -->
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="name">Email <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<form:input path="email" id="email"
													class="form-control col-md-7 col-xs-12" name="email"
													placeholder="please enter email" required="required"
													type="text" maxlength="30" />
											</div>
										</div>								

										<!-- State -->
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="name">State <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<form:radiobutton path="is_open" id="is_open" name="is_open"
													required="required" value="T" class="flat" checked="true" />
												Enable
												<form:radiobutton path="is_open" id="is_open" name="is_open"
													required="required" value="F" class="flat" />
												Disable

											</div>	
										</div>
										
										
										
										<div class="ln_solid"></div>
										<div class="form-group">
											<div class="col-md-6 col-md-offset-3">
												<a href="back"><button type="button"
														class="btn btn-primary">Cancel</button></a>
												<button id="send" type="submit" class="btn btn-success">Submit</button>
											</div>
										</div>
									</form:form>
								</div>
							</div>
						</div>
					</div>
					<!-- /page content -->
					<!-- footer content -->
					<footer>
						<div class="pull-right">
							Gentelella - Bootstrap Admin Template by <a
								href="https://colorlib.com">Colorlib</a>
						</div>
						<div class="clearfix"></div>
					</footer>
					<!-- /footer content -->
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<script
		src="<c:url value="../template/vendors/jquery/dist/jquery.min.js" />"></script>
	<!-- Bootstrap -->
	<script
		src="<c:url value="../template/vendors/bootstrap/dist/js/bootstrap.min.js" />"></script>
	<!-- FastClick -->
	<script
		src="<c:url value="../template/vendors/fastclick/lib/fastclick.js" />"></script>
	<!-- validator -->
	<script
		src="<c:url value="../template/vendors/validator/validator.js" />"></script>
<!-- iCheck -->
    <script src="<c:url value="../template/vendors/iCheck/icheck.min.js" />"></script>
	<!-- Custom Theme Scripts -->
	<script src="<c:url value="../template/build/js/custom.min.js" />"></script>

</body>
</html>