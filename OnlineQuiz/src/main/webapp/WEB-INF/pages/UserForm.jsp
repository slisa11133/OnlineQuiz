<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body>
    <div align="center">
        <h1>New/Edit User</h1>
        <h1>${msg}</h1>
        <form:form action="saveUser" method="post" modelAttribute="user">
        <table>
            <form:hidden path=""/>
            <tr>
                <td>Account:</td>
                <td><form:input path="id" /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:input path="pwd" /></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Level:</td>
                <td><form:input path="grade" /></td>
            </tr>
            <tr>
                <td>Role:</td>
                <td><form:input path="role" /></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><form:input path="is_open" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
        <h1>${result}</h1>
    </div>
</body>
</html>