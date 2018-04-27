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
								<li><a href="../user"><i class="fa fa-home"></i>
										User Management </a></li>
								<li><a href="../QuizManage/SubjectList"><i
										class="fa fa-edit"></i> Quiz Management </a></li>
								<li><a href="../AbilityManage/AbilityList"><i class="fa fa-edit"></i>
										Ability Management </a></li>
								<li><a href="../EssayForm/EssayList"><i class="fa fa-edit"></i>
										Essay Marking </a></li>
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
									src="<c:url value="../template/images/img.jpg" />" alt="">John
									Doe <span class=" fa fa-angle-down"></span>
							</a>
								<ul class="dropdown-menu dropdown-usermenu pull-right">
									<li><a href="javascript:;"> Profile</a></li>
									<li><a href="javascript:;"> <span
											class="badge bg-red pull-right">50%</span> <span>Settings</span>
									</a></li>
									<li><a href="javascript:;">Help</a></li>
									<li><a href="login.html"><i
											class="fa fa-sign-out pull-right"></i> Log Out</a></li>
								</ul></li>

							<li role="presentation" class="dropdown"><a
								href="javascript:;" class="dropdown-toggle info-number"
								data-toggle="dropdown" aria-expanded="false"> <i
									class="fa fa-envelope-o"></i> <span class="badge bg-green">6</span>
							</a>
								<ul id="menu1" class="dropdown-menu list-unstyled msg_list"
									role="menu">
									<li><a> <span class="image"><img
												src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John
													Smith</span> <span class="time">3 mins ago</span>
										</span> <span class="message"> Film festivals used to be
												do-or-die moments for movie makers. They were where... </span>
									</a></li>
									<li>
										<div class="text-center">
											<a> <strong>See All Alerts</strong> <i
												class="fa fa-angle-right"></i>
											</a>
										</div>
									</li>
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
							<h3>Essay Marking</h3>
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
									<h2>Marking</h2>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<h2>${msg}</h2>
									<form:form action="saveMarking" method="post"
										modelAttribute="essay"
										class="form-horizontal form-label-left">
										
									<!-- Question -->
									<div class="item form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="name">Question 
										</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<form:input path="question" id="question"
												class="form-control col-md-7 col-xs-12" name="question"
												readonly="true" type="text" />
										</div>
									</div>
									
									<!-- Answer -->
									<div class="item form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="name">Answer 
										</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<form:input path="answer" id="answer"
												class="form-control col-md-7 col-xs-12" name="answer"
												readonly="true" type="text" />
										</div>
									</div>
									
									<!-- Ability -->
																																									
									<c:forEach var="Qability" items="${Qability}"> 	
										<div class="item form-group">									
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="name">
												${Qability}
											 </label>

											<div class="col-md-6 col-sm-6 col-xs-12">
												<form:input path="" id=""
													class="form-control col-md-10" name="result"
												    type="text" />
											</div>
										</div>
									</c:forEach>
									
									<!-- Marker -->
									<div class="item form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="name">Marker 
										</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<form:input path="" id=""
												class="form-control col-md-7 col-xs-12" name=""
												readonly="true" type="text" />
										</div>
									</div>
														
									<!-- Feedback -->
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="name">Feedback <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<form:input path="feedback" id="feedback"
													class="form-control col-md-7 col-xs-12" name="feedback"
													placeholder="please give your feedback" required="required"
													type="text" maxlength="1000" />
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

	<!-- Custom Theme Scripts -->
	<script src="<c:url value="../template/build/js/custom.min.js" />"></script>

</body>
</html>