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
<div>
<table>
<thead>
<tr>
<th>Name</th>
<th>phone</th>
<th>Email</th>
<th>BirthDate</th>
<th>Address</th>
<th>UserName</th>
<th>Role</th>
<th>Edit</th>
<th>Delete</th>

</tr>

</thead>
<c:forEach items="${users}" var="user">
<tr>
<td>${user.fName}&nbsp;${user.lName}</td>
<td>${user.phone}</td>
<td>${user.email}</td>
<td>${user.dob}</td>
<td>${user.address.street},${user.address.city}<br>${user.address.state}&nbsp;${user.address.zip}&nbsp;${user.address.country}</td>
<%-- &nbsp;${user.address.city}&nbsp;${user.address.state}&nbsp;${user.address.zip}&nbsp;${user.address.country"} --%>
<td>${user.user.username}</td>
<td>${user.user.hasRole}</td>
<td><a href="useredit/${user.id}">Edit</a></td>
<td><a href="/Loot_Bazar/users/${user.id}">Delete</a></td>
</tr>

</c:forEach>
</table>
</div>
</body>
</html>