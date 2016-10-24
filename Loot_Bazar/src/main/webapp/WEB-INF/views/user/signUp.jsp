<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div>
<h1>Please Sign Up</h1>
<form:form modelAttribute="user" action="signUp" method="post">
<table>

<tr>
<td><spring:message code="customer.fname" /></td>
<td><form:input path="fName"/></td>
<td><form:errors path="fName"/></td>
</tr>
<tr>
<td><spring:message code="customer.lname" /></td>
<td><form:input path="lName"/></td>
<td><form:errors path="LName"/></td>
</tr>
<tr>
<td><spring:message code="customer.id" /></td>
<td><form:input path="identificationNumber"/></td>
<td><form:errors path="identificationNumber"/></td>
</tr>
<tr>
<td><spring:message code="customer.phone" /></td>
<td><form:input path="phone"/></td>
<td><form:errors path="phone"/></td>
</tr>
<tr>
<td><spring:message code="customer.email" /></td>
<td><form:input path="email"/></td>
<td><form:errors path="email"/></td>
</tr>
<tr>
<td><spring:message code="customer.dob" /></td>
<td><form:input path="dob"/></td>
<td><form:errors path="dob"/></td>
</tr>
<tr><td><h3>Address</h3></td></tr>
<tr>
<td><spring:message code="customer.street" /></td>
<td><form:input path="address.street"/></td>
<td><form:errors path="address.street"/></td>
</tr>
<tr>
<td><spring:message code="customer.city" /></td>
<td><form:input path="address.city"/></td>
<td><form:errors path="address.city"/></td>
</tr>
<tr>
<td><spring:message code="customer.state" /></td>
<td><form:input path="address.state"/></td>
<td><form:errors path="address.state"/></td>
</tr>
<tr>
<td><spring:message code="customer.zip" /></td>
<td><form:input path="address.zip"/></td>
<td><form:errors path="address.zip"/></td>
</tr>
<tr>
<td><spring:message code="customer.country" /></td>
<td><form:input path="address.country"/></td>
<td><form:errors path="address.country"/></td>
</tr>
<tr>
<td><spring:message code="customer.username" /></td>
<td><form:input path="user.username"/></td>
<td><form:errors path="user.username"/></td>
</tr>
<tr>
<td><spring:message code="customer.password" /></td>
<td><form:input path="user.password" type="password" /></td>
<td><form:errors path="user.password"/></td>
</tr>
</table>
<form:hidden path="user.enabled" value="true"/>
<input type="submit" value="SignUp">
</form:form>
</div>


