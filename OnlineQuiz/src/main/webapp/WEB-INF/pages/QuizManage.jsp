<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>DataTables | Gentelella</title>

<!-- Bootstrap -->
<link
	href="<c:url value="../template/vendors/bootstrap/dist/css/bootstrap.min.css" />"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="<c:url value="../template/vendors/font-awesome/css/font-awesome.min.css" />"
	rel="stylesheet">
<!-- Datatables -->
<link
	href="<c:url value="../template/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" />"
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
								<li><a href="../user/list"><i class="fa fa-home"></i>
										User Management </a></li>
								<li><a href="SubjectList"><i class="fa fa-edit"></i>
										Quiz Management </a></li>
								<li><a><i class="fa fa-table"></i> Tables <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="tables.html">Tables</a></li>
										<li><a href="tables_dynamic.html">Table Dynamic</a></li>
									</ul></li>
								<li><a><i class="fa fa-clone"></i>Layouts <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="fixed_sidebar.html">Fixed Sidebar</a></li>
										<li><a href="fixed_footer.html">Fixed Footer</a></li>
									</ul></li>
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
												src="<c:url value="../templateimages/img.jpg" />"
												alt="Profile Image" /></span> <span> <span>John
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
							<h3>${type}Management</h3>
						</div>
					</div>

					<div class="clearfix"></div>

					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<c:choose>
									<c:when test="${type == 'Subject'}">
										<div class="x_title">
											<h2>${type}List</h2>
											<div class="pull-right">
												<a href="newSubject"><button type="button"
														class="btn btn-round btn-primary">Add New ${type}</button></a>
											</div>
											<div class="clearfix"></div>
										</div>
										<div class="x_content">
											<table id="datatable"
												class="table table-striped table-bordered">


												<thead>
													<tr>
														<th>Id</th>
														<th>Name</th>
														<th>Action</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="subject" items="${listSubject}">
														<tr>
															<td>${subject.id}</td>
															<td>${subject.name}</td>
															<td><a href="editSubject?id=${subject.id}"><button
																		type="button" class="btn btn-round btn-primary">Edit</button></a>
																&nbsp;&nbsp;&nbsp;&nbsp; <a
																href="deleteSubject?id=${subject.id}"><button
																		type="button" class="btn btn-round btn-primary">Delete</button></a>
																&nbsp;&nbsp;&nbsp;&nbsp;<a
																href="QuestionList?s_id=${subject.id}&s_name=${subject.name}"><button
																		type="button" class="btn btn-round btn-primary">Questions</button></a></td>
														</tr>
													</c:forEach>
												</tbody>
												</c:when>
												<c:when test="${type == 'Question'}">
													<div class="x_title">
														<h2>${type}List</h2>
														<div class="pull-right">
															<a href="newQuestion"><button type="button"
																	class="btn btn-round btn-primary">Add New
																	${type}</button></a>
														</div>
														<div class="clearfix"></div>
													</div>
													<div class="x_content">
														<table id="datatable"
															class="table table-striped table-bordered">
															<h2>
																Subject: ${s_name} <a href="SubjectList"><button
																		type="button" class="btn btn-round btn-primary">SubjectList</button></a>
															</h2>

															<thead>
																<tr>
																	<th>Id</th>
																	<th>Question</th>
																	<th>Type</th>
																	<th>Grade</th>
																	<th>Action</th>
																</tr>
															</thead>
															<tbody>
																<c:forEach var="question" items="${listQuestion}">
																	<tr>
																		<td>${question.id}</td>
																		<td>${question.question}</td>
																		<td>${question.type}</td>
																		<td>${question.grade}</td>
																		<td><a href="editQuestion?id=${question.id}"><button
																					type="button" class="btn btn-round btn-primary">Edit</button></a>
																			&nbsp;&nbsp;&nbsp;&nbsp; <a
																			href="deleteQuestion?id=${question.id}"><button
																					type="button" class="btn btn-round btn-primary">Delete</button></a>
																			&nbsp;&nbsp;&nbsp;&nbsp;<a
																			href="OptionList?q_id=${question.id}&q_content=${question.question}"><button
																					type="button" class="btn btn-round btn-primary">Options</button></a></td>
																	</tr>
																</c:forEach>
															</tbody>
															</c:when>
															<c:when test="${type == 'Option'}">
																<div class="x_title">
																	<h2>${type}List</h2>
																	<div class="pull-right">
																		<a href="newOption"><button type="button"
																				class="btn btn-round btn-primary">Add New
																				${type}</button></a>
																	</div>
																	<div class="clearfix"></div>
																</div>
																<div class="x_content">
																	<table id="datatable"
																		class="table table-striped table-bordered">
																		<h2>
																			Subject: ${s_name} <a href="SubjectList"><button
																					type="button" class="btn btn-round btn-primary">SubjectList</button></a>
																		</h2>
																		<h2>
																			Question: ${q_content} <a
																				href="QuestionList?s_id=${s_id}&s_name=${s_name}"><button
																					type="button" class="btn btn-round btn-primary">QuestionList</button></a>
																		</h2>

																		<thead>
																			<tr>
																				<th>Id</th>
																				<th>Option</th>
																				<th>Is_answer</th>
																				<th>Action</th>
																			</tr>
																		</thead>
																		<tbody>
																			<c:forEach var="option" items="${listOption}">
																				<tr>
																					<td>${option.id}</td>
																					<td>${option.option}</td>
																					<td>${option.is_answer}</td>
																					<td><a href="editOption?id=${option.id}"><button
																								type="button" class="btn btn-round btn-primary">Edit</button></a>
																						&nbsp;&nbsp;&nbsp;&nbsp; <a
																						href="deleteOption?id=${option.id}"><button
																								type="button" class="btn btn-round btn-primary">Delete</button></a>
																					</td>
																				</tr>
																			</c:forEach>
																		</tbody>
																		</c:when>
																		<c:otherwise>
    do this when nothing else is true
  </c:otherwise>
																		</c:choose>

																	</table>
																</div>
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
																<!-- Datatables -->
																<script
																	src="<c:url value="../template/vendors/datatables.net/js/jquery.dataTables.min.js" />"></script>
																<script
																	src="<c:url value="../template/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js" />"></script>
																<script
																	src="<c:url value="../template/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js" />"></script>


																<!-- Custom Theme Scripts -->
																<script
																	src="<c:url value="../template/build/js/custom.min.js" />"></script>
</body>
</html>