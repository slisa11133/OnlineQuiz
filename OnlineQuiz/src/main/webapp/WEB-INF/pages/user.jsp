<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Management Screen</title>
</head>
<body>
	<div align="center">
		<h1>User List</h1>
		
		<table border="1">

			<th>Account</th>
			<th>Password</th>
			<th>Name</th>
			<th>Grade</th>
			<th>Role</th> 
			<th>Is_open</th>

			<c:forEach var="user" items="${listUser}">
				<tr>
					<td>${user.id}</td>
					<td>${user.pwd}</td>
					<td>${user.name}</td>
					<td>${user.grade}</td>
					<td>${user.role}</td> 
					<td>${user.is_open}</td>
					<td><a href="editUser?id=${user.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteUser?id=${user.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table> 
		<h4>
			New User Register <a href="newUser">here</a>
		</h4>
	</div>
</body>
</html>