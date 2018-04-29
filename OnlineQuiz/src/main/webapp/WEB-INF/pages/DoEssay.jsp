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
	<script>
		window.onload = function() {
			setInterval("getMessage()", 10000)
			
			//setTimeout('document.getElementById("saveMsg").innerHTML = ""', 3000)
		}

		function getMessage() {
			document.getElementById("saveMsg").innerHTML = "Saved!";
			document.getElementById('save').click();
		}
	</script>


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


			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>Quiz</h3>
							<div id="saveMsg"></div>
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
									<form action="submitEssay" method="post">
										<div class="form-group">
											<h2>${question.question}${submit}</h2>
										</div>

										<div class="form-group">
											<input type="hidden" id="state" class="form-control"
												name="state" value="${state}"></input>
										</div>
										<div class="form-group">
											<textarea id="answer" class="form-control" name="answer"
												maxlength="1000" rows="10">${question.answer}</textarea>
										</div>
										<div class="ln_solid"></div>
										<div>
											<c:choose>
												<c:when test="${submit==null}">
													<button id="action" name="action" type="submit"
														value="send" class="btn btn-success">Submit</button>
													<button id="save" name="action" type="submit"
														onclick="form.action='saveToMemento';"
														class="btn btn-success">Save</button>
													<!-- <a href="cancel?quizType=Essay&state=${state}">
														<button type="button" class="btn btn-round btn-primary">Cancel</button>
													</a> -->
												</c:when>
												<c:otherwise>
													<a href="cancel?quizType=Essay&state=${state}">
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