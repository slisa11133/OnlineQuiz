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
								<li><a href="chooseTest?quizType=Test"><i
										class="fa fa-edit"></i> Do Test </a></li>
								<li><a href="chooseTest?quizType=Essay"><i
										class="fa fa-edit"></i> Do Essay </a></li>
								<li><a href="../user/getAbilitiesResults"><i
										class="fa fa-edit"></i> Show Abilities Report </a></li>
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
															<c:choose>
																<c:when
																	test="${StudentAnswers!=null&&options.id==StudentAnswers[Qloop.index]}">
																	<input type="radio" class="form-control flat" required
																		checked name="studentAnswers${Qloop.index}"
																		id="studentAnswers${Qloop.index}"
																		value="${options.id}" /> ${options.option}
												</c:when>
																<c:otherwise>
																	<input type="radio" class="form-control flat" required
																		name="studentAnswers${Qloop.index}"
																		id="studentAnswers${Qloop.index}"
																		value="${options.id}" /> ${options.option}
												</c:otherwise>
															</c:choose>
															<c:if
																test="${StudentAnswers!=null&&options.id==CorrectAnswers[Qloop.index].answer}">
													(correct answer)
												</c:if>
															<br />
															<br />
														</c:forEach>
													</c:when>
													<c:otherwise>
														<div class="form-group">
															<c:choose>
																<c:when test="${StudentAnswers!=null}">
																	<input id="studentAnswers${Qloop.index}"
																		class="form-control col-md-7 col-xs-12"
																		value="${StudentAnswers[Qloop.index]}"
																		name="studentAnswers${Qloop.index}" type="text"
																		required />
																</c:when>
																<c:otherwise>
																	<input id="studentAnswers${Qloop.index}"
																		class="form-control col-md-7 col-xs-12"
																		name="studentAnswers${Qloop.index}" type="text"
																		required />
																</c:otherwise>
															</c:choose>

															<c:if test="${StudentAnswers!=null}">
																<h2>Correct Answer:
																	${CorrectAnswers[Qloop.index].answer}</h2>
															</c:if>
														</div>
													</c:otherwise>

												</c:choose>
												<c:if test="${StudentAnswers!=null}">
													<c:if
														test="${StudentAnswers[Qloop.index]==CorrectAnswers[Qloop.index].answer}">
														<h2>correct!!</h2>
													</c:if>
													<c:if
														test="${StudentAnswers[Qloop.index]!=CorrectAnswers[Qloop.index].answer}">
														<h2>wrong!!</h2>
													</c:if>
												</c:if>

											</div>
											<div class="ln_solid col-md-12 col-sm-12 col-xs-12"></div>
										</c:forEach>
										<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-2">
											<c:choose>
												<c:when test="${StudentAnswers==null}">
													<button id="send" type="submit" class="btn btn-success">Submit</button>
													<!-- <a href="cancel?quizType=Test">
														<button type="button" class="btn btn-round btn-primary">Cancel</button>
													</a> -->
												</c:when>
												<c:otherwise>
													<a href="cancel?quizType=Test">
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