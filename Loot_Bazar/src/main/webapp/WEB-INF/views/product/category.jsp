<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> Category Details </h2>
<div >
<p> ID:${category.id } </p> 
<p> Category Name: ${category.cName }</p>
<p> Description: ${category.description}</p>
</div>
<security:authorize access="hasRole('ROLE_ADMIN')">
<a href="<spring:url value="/category/delete?id=${category.id}" /> "> </span> Delete </a>
</security:authorize>
<br/>
<security:authorize access="hasRole('ROLE_ADMIN')">
<a href="<spring:url value="/category/update?id=${category.id}" /> "> </span> Update </a>
</security:authorize>
</body>
</html>