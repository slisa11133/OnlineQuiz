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
									<h2>${operation}</h2>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<c:choose>
										<c:when test="${type == 'Subject'}">
											<h2>${msg}</h2>
											<form:form action="saveSubject" method="post"
												modelAttribute="subject"
												class="form-horizontal form-label-left">
												<form:hidden path="" />
												<div class="item form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="name">Id </label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<form:input path="id" id="id"
															class="form-control col-md-7 col-xs-12" name="id"
															readonly="true" type="text" />
													</div>
												</div>
												<div class="item form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="name">Name <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<form:input path="name" id="name"
															class="form-control col-md-7 col-xs-12" name="name"
															placeholder="please enter subject name"
															required="required" type="text" maxlength="30" />
													</div>
												</div>
												<div class="ln_solid"></div>
												<div class="form-group">
													<div class="col-md-6 col-md-offset-3">
														<a href="cancel?type=${type}"><button type="button"
																class="btn btn-primary">Cancel</button></a>
														<button id="send" type="submit" class="btn btn-success">Submit</button>
													</div>
												</div>
											</form:form>
										</c:when>
										<c:when test="${type == 'Question'}">
											<form:form action="saveQuestion" method="post"
												modelAttribute="question"
												class="form-horizontal form-label-left">
												<form:hidden path="" />
												<div class="item form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="name">Id </label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<form:input path="id" id="id"
															class="form-control col-md-7 col-xs-12" name="id"
															readonly="true" type="text" />
													</div>
												</div>
												<div class="item form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="name">Subject </label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input id="subject" value="${s_name}"
															class="form-control col-md-7 col-xs-12" name="subject"
															readonly="true" />
													</div>
												</div>
												<div class="item form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="name">Question <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<form:input path="question" id="question"
															class="form-control col-md-7 col-xs-12" name="question"
															placeholder="please enter question" required="required"
															type="text" maxlength="500" />
													</div>
												</div>
												<!-- type -->
												<div class="item form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="name">Type <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<form:select path="type" id="type"
															class="form-control col-md-7 col-xs-12" name="type"
															required="required">
															<form:options items="${Qtypes}" />
														</form:select>
													</div>
												</div>
												<!-- grade -->
												<div class="item form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="name">Grade <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<form:select path="grade" id="grade"
															class="form-control col-md-7 col-xs-12" name="grade"
															required="required">
															<form:options items="${Qgrades}" />
														</form:select>
													</div>
												</div>
												<!-- level -->
												<div class="item form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="name">Level <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<form:select path="level" id="level"
															class="form-control col-md-7 col-xs-12" name="level"
															required="required">
															<form:options items="${Qlevels}" />
														</form:select>
													</div>
												</div>
												<div class="ln_solid"></div>
												<div class="form-group">
													<div class="col-md-6 col-md-offset-3">
														<a href="cancel?type=${type}"><button type="button"
																class="btn btn-primary">Cancel</button></a>
														<button id="send" type="submit" class="btn btn-success">Submit</button>
													</div>
												</div>
											</form:form>
										</c:when>
										<c:when test="${type == 'QuestionAbility'}">
											<form:form action="saveQuestionAbility" method="post"
												modelAttribute="questionability"
												class="form-horizontal form-label-left">
												<div class="item form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="name">Subject </label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input id="subject" value="${s_name}"
															class="form-control col-md-7 col-xs-12" name="subject"
															readonly="true" />
													</div>
												</div>
												<div class="item form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="name">Question </label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input id="question" value="${q_content}"
															class="form-control col-md-7 col-xs-12" name="question"
															readonly="true" />
													</div>
												</div>
												<!-- ability -->
												<div class="item form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="name">Ability <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<form:checkboxes path="ability" id="ability"
															class="form-control col-md-7 col-xs-12 flat" name="ability"
															items="${Qability}" />
													</div>
												</div>
												<div class="ln_solid"></div>
												<div class="form-group">
													<div class="col-md-6 col-md-offset-3">
														<a href="cancel?type=${type}"><button type="button"
																class="btn btn-primary">Cancel</button></a>
														<button id="send" type="submit" class="btn btn-success">Submit</button>
													</div>
												</div>
											</form:form>
										</c:when>
										<c:when test="${type == 'Option'}">
											<form:form action="saveOption" method="post"
												modelAttribute="option"
												class="form-horizontal form-label-left">
												<form:hidden path="" />
												<div class="item form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="name">Id </label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<form:input path="id" id="id"
															class="form-control col-md-7 col-xs-12" name="id"
															readonly="true" type="text" />
													</div>
												</div>
												<div class="item form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="name">Subject </label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input id="subject" value="${s_name}"
															class="form-control col-md-7 col-xs-12" name="subject"
															readonly="true" />
													</div>
												</div>
												<div class="item form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="name">Question </label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input id="question" value="${q_content}"
															class="form-control col-md-7 col-xs-12" name="subject"
															readonly="true" />
													</div>
												</div>
												<div class="item form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="name">Option <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<form:input path="option" id="option"
															class="form-control col-md-7 col-xs-12" name="option"
															placeholder="please enter option" required="required"
															type="text" maxlength="500" />
													</div>
												</div>
												<!-- is_answer -->
												<div class="item form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="name">Is_Answer <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<c:if test="${option.is_answer == 'T'}">
															<form:radiobutton path="is_answer" id="is_answer"
																name="is_answer" required="required" value="T"
																class="flat" checked="true" />
														Yes
														<form:radiobutton path="is_answer" id="is_answer"
																name="is_answer" required="required" value="F"
																class="flat" />
														No
													</c:if>
														<c:if test="${option.is_answer != 'T'}">
															<form:radiobutton path="is_answer" id="is_answer"
																name="is_answer" required="required" value="T"
																class="flat" />
														Yes
														<form:radiobutton path="is_answer" id="is_answer"
																name="is_answer" required="required" value="F"
																class="flat" checked="true" />
														No
													</c:if>
													</div>
												</div>
												<div class="ln_solid"></div>
												<div class="form-group">
													<div class="col-md-6 col-md-offset-3">
														<a href="cancel?type=${type}"><button type="button"
																class="btn btn-primary">Cancel</button></a>
														<button id="send" type="submit" class="btn btn-success">Submit</button>
													</div>
												</div>
											</form:form>
										</c:when>
										<c:otherwise>
    do this when nothing else is true
  </c:otherwise>
									</c:choose>
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