<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="newCategory" method="post"  >
<table>
	
<tr><td>Category Name:</td><td><form:input id="cName" name="cName" path="cName" type="text" /></td>
		<td><form:errors path="cName" cssStyle="color:red;"/></td>
</tr>
<tr><td>Description:</td><td><form:textarea id="description" path="description"/></td>
			<td><form:errors path="description" cssStyle="color:red;"/></td>
</tr>
<%-- <tr><td><form:input id="categoryImage" path="categoryImage" type="file" class="form:input-large" /><tr><td>  --%>
<tr><td><input type="submit" value="Add"/></td></tr>
</table>
</form:form>
</body>
</html>