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
<title>Shopping Cart</title>
</head>
<body>
	<h1>Shipping Information</h1>
	<div style="align:center">
	 
		<table class="table table-hover">
			<tr>
				<td>Your Name</td>
				<td>Phone Number</td>
				<td>Email</td>
				<td>Address</td> 
			</tr>
			<tr>
				<td>${customer.fName } ${customer.lName }</td>
				<td>${customer.phone }</td>
				<td>${customer.email }</td>
				<td>${customer.address }</td> 
			</tr>
			</table>
	</div>
	<h1>Billing Information</h1>
	<div style="align:center">
	 
		<table class="table table-hover">
			<tr>
				<td>Product Name</td>
				<td>Unit Price</td>
				<td>Quantity</td>
				<td>Sub Total</td>
			</tr>
			 
			<c:forEach items="${billingInfo }" var="shoppingCart">
			<tr>
				<td>${shoppingCart.orderDetails.product.pName }</td>
				<td>${shoppingCart.orderDetails.unitCost }</td>
				<td>${shoppingCart.quantity }</td>
				<td>$ ${shoppingCart.orderDetails.subTotal }</td>
			</tr>
			</c:forEach>
			<tr>
					<th></th>
					<th></th>
					<th>Total</th>
					<th>$ ${totalPrice}</th>
					<th></th>
			</tr>
			<tr>
				<th></th>
				<th></th>
			</tr>
			<tr>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			<tr> 
					 
					<td></td>
					<td></td>
					<td><a href="<spring:url value="/thankYou"  /> "  class="btn btn-success" >
						<span class="glyphicon-comment glyphicon"></span>Place Order	</a>
					</td>
			</tr>
		</table>
	</div>
</body>
</html>