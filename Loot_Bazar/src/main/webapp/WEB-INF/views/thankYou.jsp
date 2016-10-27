<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
 <script type="text/javascript" src="<spring:url value="/resources/js/shoppingCart.js"/>"></script>
<title>Thank You</title>
</head>
<body>
	<h1><a href="<spring:url value="/index" /> " onclick="deleteAllCarts()" class="btn btn-success" >
						<span class="glyphicon-comment glyphicon"></span>Thank You	</a></h1>
</body>
</html>