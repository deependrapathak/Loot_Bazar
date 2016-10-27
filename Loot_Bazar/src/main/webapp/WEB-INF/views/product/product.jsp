<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript"
	src="<spring:url value="/resources/js/comment.js"/>"></script>
<script type="text/javascript"
	src="<spring:url value="/resources/js/shoppingCart.js"/>"></script>
<title>Product</title>
</head>
<body>
	<div style="float: left; margin: 5px">
		<h1>Product Detail</h1>
		<img
			src="<c:url value="/resources/images/C${product.id }.png"></c:url>"
			alt="image" style="width: 250px" />
		<p>ID:${product.id }</p>
		<p>Product Name: ${product.pName }</p>
		<p>Unit Price: ${product.unitPrice}</p>
		<p>Units in Stock: ${product.unitsInStock }</p>
		<p>Description: ${product.description}</p>
		<p>Category: ${product.category.cName }</p>
		<p>Condition: ${product.conditioned}</p>
		<p>
			<security:authorize access="hasRole('ROLE_ADMIN')">
				<a href="<spring:url value="/product/delete?id=${product.id}" /> ">
					</span> Delete
				</a>
			</security:authorize>
			<br />
			<security:authorize access="hasRole('ROLE_ADMIN')">
				<a href="<spring:url value="/product/update?id=${product.id}" /> ">
					</span> Update
				</a>
			</security:authorize>
		</p>

		<%-- <p><a href= "#"  onclick="addToShoppingCart('2')"> Order </a></p>
			 <p><a href= "<spring:url value="/cartList" />" >View Shopping Cart </a> </p> --%>
		<a href="#" onclick="addToShoppingCart('${product.id }')"
			class="btn btn-success pull-right"> <span
			class="glyphicon-comment glyphicon"></span> Order Please
		</a> <a href="<spring:url value="/cartList" />"
			class="btn btn-success pull-right"> <span
			class="glyphicon-comment glyphicon"></span> View Shopping Cart
		</a>
		<h2>Comment By customer</h2>
		<a href="#" onclick="addReviewForm()"
				class="btn btn-success "> <span
				class="glyphicon-comment glyphicon"></span> Add New Comment
			</a>
		<div class="row">
			<c:forEach items="${reviews}" var="review">
				<%-- <c:if test="${product.id } == ${review.product.id }"> --%>
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${review.rate}</h3>
							<p>${review.description}</p>
							<p>By ${review.name}</p>
							<p>Email ${review.email }</p>
							<security:authorize access="hasRole('ROLE_ADMIN')">
							<p><a href="#" onclick="deletReview('${review.id}')" class="btn btn-success pull-right"> <span class="glyphicon-comment glyphicon"></span>Delete	</a></p>
						</security:authorize>
						</div>
					</div>
				</div>
				 
			</c:forEach>
		 
		</div>
		<div id="prod" class="container">
			<div style="display: none" id="newComment">
				<form id="reviewForm"
					action="/Loot_Bazar/addReview?id=${product.id}" method="post">
					<table>
						<tr>
							<td>Rate :</td>
							<td><input type="text" name="rate" id="rate" value="" /></td>
						</tr>
						<tr>
							<td>Description</td>
							<td><textarea id="description" name="description"
									type="text" value="" /></textarea></td>
						</tr>
						<tr>
							<td>Your Name</td>
							<td><input type="text" name="name" id="name" value="" /></td>
						</tr>
						<tr>
							<td>Email</td>
							<td><input type="text" name="email" id="email" value="" /></td>
						</tr>
						<tr>
							<td><input type="submit" value="Add Comment"></td>
							<td><input onClick="hideAddForm()" type="button"
								Value="Close" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>