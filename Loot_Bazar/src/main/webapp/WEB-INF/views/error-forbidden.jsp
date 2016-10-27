<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 

		<center>
		
		<img src="<spring:url value="/resources/images/forbidden-error.jpg"  htmlEscape="true" />" alt="Your not allowed!!!"  />
		
		<H2>${requestScope['javax.servlet.error.message']}</H2>
		 
		 <p><button type=button onclick=window.location.href="<spring:url value="/index" />">Home</button></p>
		 
  </body>
</body>
</html>