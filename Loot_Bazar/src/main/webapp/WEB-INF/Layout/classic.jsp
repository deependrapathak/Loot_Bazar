<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html >
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js">
	
</script>
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>




<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title"></tiles:getAsString></title>
</head>
<body>
	<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
		prefix="tilesx"%>
	<tilesx:useAttribute name="current" />

	<div class="container">
		<!-- Static navbar -->
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="<spring:url value="/index" />">Loot
						Bazar</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="${current=='welcome' ? 'active' :''}"><a
							href="<spring:url value="/index" />">Home</a></li>
					</ul>
					<ul class="nav navbar-nav">
						<li class="${current=='signUp' ? 'active' :''}"><a
							href="<spring:url value="/signUp" />">Sign Up</a></li>
					</ul>
					<security:authorize access="hasRole('ROLE_ADMIN')">
					<ul class="nav navbar-nav">
						<li class="${current=='users' ? 'active' :''}"><a
							href="<spring:url value="/users" />">Users</a></li>
					</ul>
					</security:authorize>
					<security:authorize access="! isAuthenticated()">
					<ul class="nav navbar-nav">
						<li class="${current=='login' ? 'active' :''}"><a
							href="<spring:url value="/login" />">Login</a></li>
					</ul>
					</security:authorize>
					<security:authorize access="isAuthenticated()">
						<ul class="nav navbar-nav">
							<li><a href='<spring:url value="/account"></spring:url>'>My Profile</a></li>
						</ul>
					</security:authorize>
					<security:authorize access="isAuthenticated()">
						<ul class="nav navbar-nav">
							<li><a href='<spring:url value="/doLogout"></spring:url>'>Logout</a></li>
						</ul>
					</security:authorize>
				</div>
				<%-- <div style="float: right;"><security:authentication property="principal.getname" /></div> --%>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</nav>

		<!-- Main component for a primary marketing message or call to action -->



		<tiles:insertAttribute name="body"></tiles:insertAttribute>
		<br> <br>

		<center>

			<tiles:insertAttribute name="footer"></tiles:insertAttribute>
		</center>
	</div>
</body>
</html>