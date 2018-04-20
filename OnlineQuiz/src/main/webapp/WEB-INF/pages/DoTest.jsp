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
<link
	href="<c:url value="../template/vendors/iCheck/skins/flat/green.css"/>"
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
								<li><a href="chooseTest"><i class="fa fa-edit"></i> Do
										Test </a></li>
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
							<h3>Quiz Form</h3>
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
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<c:forEach var="question" items="${questions}" varStatus="loop">
										<h2>q_id: ${question.q_id}</h2>
										<h2>s_id: ${question.s_id}</h2>
										<h2>Question${loop.count}: ${question.question}</h2>
										<h2>Grade: ${question.grade}</h2>
										<h2>Level: ${question.level}</h2>
										<h2>Answer(o_id/option for BFQ): ${question.answer}</h2>
										<c:forEach var="options" items="${question.options}" varStatus="loop">
											<h2>OptionId(o_id): ${options.id}</h2>
											<h2>(${loop.count}) ${options.option}</h2>
											<h2>is_answer: ${options.is_answer}</h2>
										</c:forEach>
										<c:forEach var="abilities" items="${question.abilities}" varStatus="loop">
											<h2>QuestionAbilityId(qa_id): ${abilities[0]}</h2>
											<h2>AbilityId(a_id): ${abilities[3]}</h2>
										</c:forEach>
										<div class="ln_solid"></div>
									</c:forEach>
									<a href="cancel"><button type="button"
											class="btn btn-round btn-primary">Cancel</button></a>
								</div>
							</div>
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
	<script
		src="<c:url value="../template/vendors/iCheck/icheck.min.js" />"></script>
	<!-- Custom Theme Scripts -->
	<script src="<c:url value="../template/build/js/custom.min.js" />"></script>

</body>
</html>