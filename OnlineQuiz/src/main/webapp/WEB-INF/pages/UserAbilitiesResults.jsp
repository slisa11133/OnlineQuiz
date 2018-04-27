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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://unpkg.com/jspdf@latest/dist/jspdf.min.js"></script>
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="login" class="site_title"><i class="fa fa-paw"></i> <span>Online
								Quiz</span></a>
					</div>

					<div class="clearfix"></div>

					<br />

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<ul class="nav side-menu">
								<li><a href="list"><i class="fa fa-home"></i> User
										Management </a></li>
								<li><a href="../QuizManage/SubjectList"><i
										class="fa fa-edit"></i> Quiz Management </a></li>
								<li><a href="../EssayForm/EssayList"><i class="fa fa-edit"></i>
										Essay Marking </a></li>
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
							<h3>User Management</h3>
							<br />
						</div>
					</div>

					<div class="clearfix"></div>

					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>User List</h2>
									<div class="pull-right">
										<a href="getAbilitiesResultsDiagram">
											<button type="button" class="btn btn-round btn-primary">Show
												Diagram</button>
										</a>
										<c:if test="${userAbilitiesResults.size() gt 0}">
											<button type="button" id="d-pdf"
												class="btn btn-round btn-primary">Download PDF</button>
											<script>
												var pdfDoc = new jsPDF();
												$('#d-pdf')
														.click(
																function() {
																	pdfDoc
																			.fromHTML(
																					$(
																							'#as-pdf')
																							.html(),
																					15,
																					15,
																					{
																						'width' : 1000
																					});
																	pdfDoc
																			.save('user-abilities-results.pdf');
																});
											</script>
										</c:if>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<div id="as-pdf">
										<c:if test="${userAbilitiesResults.size() gt 0}">
											<b> User ID : ${userAbilitiesResults[0].userD.getId()} <br />
												User Name : ${userAbilitiesResults[0].userD.getName()}
											</b>
											<br />
											<br />
										</c:if>
										<table id="datatable"
											class="table table-striped table-bordered">
											<thead>
												<tr>
													<th>Ability Name</th>
													<th>Ability Result</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="user" items="${userAbilitiesResults}">
													<tr>
														<td>${user.ability.getFullName()}</td>
														<td>${user.result}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<h2>Student Report</h2>
										<table id="datatable2"
											class="table table-striped table-bordered">
											<thead>
												<tr>
													<th>User ID</th>
													<th>User Name</th>
													<th>User Grade</th>
													<th>User State</th>
													<th>Ability Name</th>
													<th>Ability Result</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="Sreport" items="${Sreport}">
													<tr>
														<td>${Sreport.u_id}</td>
														<td>${Sreport.userName}</td>
														<td>${Sreport.userGrade}</td>
														<td>${Sreport.userState}</td>
														<td>${Sreport.abilityName}</td>
														<td>${Sreport.result}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<h2>Teacher Report</h2>
										<table id="datatabl3"
											class="table table-striped table-bordered">
											<thead>
												<tr>
													<th>User ID</th>
													<th>User Name</th>
													<th>User Grade</th>
													<th>User State</th>
													<th>Ability Name</th>
													<th>Ability Result</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="Treport" items="${Treport}">
													<tr>
														<td>${Treport.u_id}</td>
														<td>${Treport.userName}</td>
														<td>${Treport.userGrade}</td>
														<td>${Treport.userState}</td>
														<td>${Treport.abilityName}</td>
														<td>${Treport.result}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
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
	<script src="<c:url value="../template/build/js/custom.min.js" />"></script>

</body>
</html>