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
</head>
<body>
<div>
<c:if test="${not empty error}">
<spring:message code="badCredentials"/>
</c:if>
</div>
<div>
<form action="<spring:url value="/postLogin"></spring:url>" method="post">
<fieldset>
<legend>LOGIN</legend>
UserName:<input type="text" name="username"><br>
Password:<input type="password" name="password"> <br>
<input type="checkbox" name="keepMe">Remember Me?<br>
<input type="submit" value="LOGIN">
</fieldset>

</form>

</div>

</body>
</html>