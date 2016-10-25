<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<div>
<c:if test="${not empty error}">
<spring:message code="badCredentials"/>
</c:if>
</div>
<div id="loginform">
<form action="<spring:url value="/postLogin"></spring:url>" method="post">
<fieldset>
<legend>LOGIN</legend>
<table style="width: 50%; border: none;">
<tr>
<td>
UserName:<input type="text" name="username"></td>
</tr>
<tr>
<td>
Password:<input type="password" name="password"> </td></tr>
<tr>
<td>
<input type="checkbox" name="keepMe">Remember Me?</td></tr>
<tr>
<td>
<input type="submit" value="LOGIN"></td></tr>
</table>
</fieldset>

</form>

</div>

</body>
</html>