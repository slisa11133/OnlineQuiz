<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
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
								<li><a href="../DoTest/chooseTest?quizType=Test"><i
										class="fa fa-edit"></i> Do Test </a></li>
								<li><a href="../DoTest/chooseTest?quizType=Essay"><i
										class="fa fa-edit"></i> Do Essay </a></li>
								<li><a href="getAbilitiesResults"><i
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
									src="<c:url value="../template/images/img.jpg" />" alt="">${msg}
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
					</div>

					<div class="clearfix"></div>

					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>User List</h2>
									<div class="pull-right">
										<a href="getAbilitiesResults"><button type="button"
												class="btn btn-round btn-primary">Back</button></a>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<script type="text/javascript">
									
										 google.charts.load("current", {packages:['corechart']});
										 google.charts.setOnLoadCallback(drawChart);
										 function drawChart() {
										     var c = [["Element", "Result", { role: "style" }]];
										     
										     <c:forEach var="user" items="${userAbilitiesResults}">
												c.push(["${user.ability.getFullName().toString()}", parseFloat(${user.result}), 'orange']);
												console.log(c);
											 </c:forEach>
											 if(c.length > 1){
											 var data = google.visualization.arrayToDataTable(c);
										     var view = new google.visualization.DataView(data);
										     view.setColumns([0, 1,
											      { calc: "stringify",
													sourceColumn: 1,
													type: "string",
													role: "none" },
											  	    2]);
								
									   	 	var options = {
											annotations: {
										    	 textStyle: {
													 fontName: 'Times-Roman',
													 fontSize: 11,
										    	 },
											 },
											title: "Abilites Digram",
										 	width: 900,
										 	height: 400,
										 	bar: {groupWidth: "20%"},
										 	legend: { position: "none" },
									     };
									     var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
									     chart.draw(view, options);
											 }
									 }
							
									</script>
									<div id="columnchart_values" style="width: 900px; height: 300px;"></div>
								</div>
							</div>
						</div>
						
					</div>
				</div>
			</div>
			<br/><br/><br/><br/>
		</div>
		<br/><br/><br/><br/>
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