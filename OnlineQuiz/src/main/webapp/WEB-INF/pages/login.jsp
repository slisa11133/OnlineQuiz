<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Gentelella Alela! | </title>

    <!-- Bootstrap -->
    <link href="<c:url value="template/vendors/bootstrap/dist/css/bootstrap.min.css" />" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<c:url value="template/vendors/font-awesome/css/font-awesome.min.css" />" rel="stylesheet">
    <!-- NProgress -->
    <link href="<c:url value="template/vendors/nprogress/nprogress.css" />" rel="stylesheet">
    <!-- Animate.css -->
    <link href="<c:url value="template/vendors/animate.css/animate.min.css" />" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="<c:url value="template/build/css/custom.min.css" />" rel="stylesheet">
  </head>

  <body class="login">
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
            <form action="loginCheck" method="post">
              <h1>Login Form</h1>
              <div>
                <input type="text" class="form-control" name="username" id="username" placeholder="Username" required="" />
              </div>
              <div>
                <input type="password" class="form-control" name="pwd" id="pwd" placeholder="Password" required="" />
              </div>
              <div>
                 <!-- <a class="btn btn-default submit" href="QuizManage/SubjectList">Log in</a> -->
                <!--input type="submit" name="submit" value="  login  "> -->
                <button type="submit" class="btn btn-success">Login</button>
              </div>
              <div>
			  	<font color="red">${msg}</font>
			  </div>
              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">New to site?
                  <a href="#signup" class="to_register"> Create Account </a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-paw"></i> Gentelella Alela!</h1>
                  <p>©2016 All Rights Reserved. Gentelella Alela! is a Bootstrap 3 template. Privacy and Terms</p>
                </div>
              </div>
            </form>
          </section>
        </div>

        <div id="register" class="animate form registration_form">
          <section class="login_content">
            <form action="registerCheck" method="post" >
              <h1>Create Account</h1>
              <div>
                <input type="text" class="form-control" name="reg_username" id="reg_username" placeholder="Username" required="" />
              </div>
              <div>
                <input type="text" class="form-control" name="reg_name" id="reg_name" placeholder="Realname" required="" />
              </div>
              <div>
                <input type="text" class="form-control" name="email" id="email" placeholder="E-mail" required="" />
              </div>
              <div>
                <input type="password" class="form-control" name="reg_pwd" id="reg_pwd" placeholder="Password" required="" />
              </div>
              <div>
                <!-- <input type="text" class="form-control" name="reg_grade" id="reg_grade" placeholder="Grade" required="" /> -->
                <select id="reg_grade" class="form-control col-md-7 col-xs-12" name="reg_grade" required="required">
					<option value="1">1</option>
					<option value="2">2</option>
				    <option value="3">3</option>
					<option value="4">4</option>
				</select>
              </div>
              <div>
                <!-- <a class="btn btn-default submit" href="index.html">Submit</a> -->
                <!-- input type="submit" name="submit" value="register">--> 
                <br/>
                <br/>
                <button type="submit" class="btn btn-success">Register</button>
              </div>
              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">Already a member ?
                  <a href="#signin" class="to_register"> Log in </a>
                </p>

                <div class="clearfix"></div>
                <br />

              </div>
            </form>
          </section>
        </div>
      </div>
    </div>
  </body>
</html>
