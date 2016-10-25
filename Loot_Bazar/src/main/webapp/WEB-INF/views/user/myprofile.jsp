<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<div id="myaccount">
Name: ${user.fName}&nbsp;${user.lName}<br>
Phone: ${user.phone}<br>
Email ${user.email}<br>
Birth Date: ${user.dob}<br>
Address: ${user.address.street},${user.address.city}<br>${user.address.state}&nbsp;${user.address.zip}&nbsp;${user.address.country}<br>
Username: ${user.user.username}<br>
Role: ${user.user.hasRole}<br>
<a href="/Loot_Bazar/useredit/${user.id}">Edit Profile</a>

</div>
</body>
</html>