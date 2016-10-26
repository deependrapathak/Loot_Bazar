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

<form:form modelAttribute="newProduct" method="post" enctype="multipart/form-data">
<table>

<tr><td>Category:</td><td><form:select id="category" path="category.Id"
items="${categories}" itemValue="Id" itemLabel="cName" /></td>
	<td>	<form:errors path="category" cssStyle="color:red;"/></td>
	</tr>	
<tr><td>Product Name:</td><td><form:input id="pName" name="pName" path="pName" type="text" /></td>
		<td><form:errors path="pName" cssStyle="color:red;"/></td>
</tr>
			
<tr><td>Unit Price:</td><td><form:input id="unitPrice" name="unitPrice" path="unitPrice" type="text"/></td>
			<td><form:errors path="unitPrice" cssStyle="color:red;"/></td>
</tr>


<tr><td>Condition:</td><td><form:input id="conditioned" name="conditioned" path="conditioned" type="text" /> </td>
		<td>	<form:errors path="conditioned" cssStyle="color:red;"/></td>
		</tr>

<tr><td>Units In Stock:</td><td><form:input id="unitsInStock" name="unitsInStock" path="unitsInStock" type="text" /> </td>
		<td>	<form:errors path="unitsInStock" cssStyle="color:red;"/></td>
		</tr>		

<tr><td>Description:</td><td><form:textarea id="description" path="description"/></td>
			<td><form:errors path="description" cssStyle="color:red;"/></td>
</tr>
<%-- 	<tr><td>
Image:		<label for="productImage"></label></td>
			<form:input id="productImage" path="productImage" type="file"/>
 --%>		
 <tr><td>	<input type="submit" value="Add"/></td></tr>
</table>			
</form:form>
</body>
</html>