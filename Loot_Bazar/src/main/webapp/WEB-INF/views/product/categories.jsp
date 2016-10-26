<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> Categories Details </h2>
<c:forEach items="${categories}" var="categories">
<div >
<p> ID:${categories.id } </p> 
<p> Category Name: ${categories.cName }</p>
<p> Description: ${categories.description}</p>
<a href="<spring:url value="/category?id=${categories.id}" /> "> </span> Details </a>
<%-- <img src="<c:url
value="/resource/images/C${categories.id }.png"></c:url>"
alt="image" style = "width:100%"/> --%>
</div>
</c:forEach>

</body>
</html>