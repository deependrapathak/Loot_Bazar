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
<title>Product</title>
</head>
<body>
<div style="border:2px solid blue; width:300px;float:left; margin:5px">
<h1> Product Detail</h1>
<img src="<c:url value="/resource/images/C${product.id }.png"></c:url>" alt="image" style = "width:250px"/>
<p> ID:${product.id } </p>
<p> Product Name: ${product.pName }</p>
<p> Unit Price: ${product.unitPrice}</p> 
<p> Units in Stock: ${product.unitsInStock }</p>
<p> Description: ${product.description} </p>
<p> Category: ${product.category.cName } </p> 
<p> Condition: ${product.conditioned}</p>
<br/>
<security:authorize access="hasRole('ROLE_ADMIN')">
<a href="<spring:url value="/product/delete?id=${product.id}" /> "> </span> Delete </a>
</security:authorize>
<br/>
<security:authorize access="hasRole('ROLE_ADMIN')">
<a href="<spring:url value="/product/update?id=${product.id}" /> "> </span> Update </a>
</security:authorize>
</div>


</body>
</html>