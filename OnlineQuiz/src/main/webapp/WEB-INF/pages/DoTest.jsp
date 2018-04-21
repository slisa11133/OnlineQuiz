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
							<h3>Quiz</h3>
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
									<form action="submitAnswer" method="post">
										<c:forEach var="question" items="${questions}"
											varStatus="Qloop">
											<div class="form-group col-md-12 col-sm-12 col-xs-12">
												<h2>Q${Qloop.count}: ${question.question}</h2>
											</div>
											<div class="form-group col-md-6 col-sm-6 col-xs-12">
												<c:choose>
													<c:when test="${!empty question.options}">
														<c:forEach var="options" items="${question.options}"
															varStatus="Oloop">
															<input type="radio" class="form-control flat" required
																name="studentAnswers${Qloop.index}"
																id="studentAnswers${Qloop.index}" value="${options.id}" /> ${options.option}
													<br />
															<br />
														</c:forEach>
													</c:when>
													<c:otherwise>
														<div class="form-group">
															<input id="studentAnswers${Qloop.index}"
																class="form-control col-md-7 col-xs-12"
																name="studentAnswers${Qloop.index}" type="text" required />
														</div>
													</c:otherwise>

												</c:choose>
												<c:if test="${StudentAnswers!=null}">
													<h2>You choose:${StudentAnswers[Qloop.index]}</h2>
													<h2>Answer:${CorrectAnswers[Qloop.index].answer}</h2>
												</c:if>

											</div>
											<div class="ln_solid col-md-12 col-sm-12 col-xs-12"></div>
										</c:forEach>
										<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-2">
											<c:choose>
												<c:when test="${StudentAnswers==null}">
													<button id="send" type="submit" class="btn btn-success">Submit</button>
													<a href="cancel">
														<button type="button" class="btn btn-round btn-primary">Cancel</button>
													</a>
												</c:when>
												<c:otherwise>
													<a href="cancel">
														<button type="button" class="btn btn-round btn-primary">Back</button>
													</a>
												</c:otherwise>
											</c:choose>

										</div>
										<div class="clearfix"></div>
									</form>







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