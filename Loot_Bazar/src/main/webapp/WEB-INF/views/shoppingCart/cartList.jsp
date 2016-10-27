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
	<h1>Shopping Cart Information</h1>
	<div style="align:center">
		<div>
			<!-- checkout via web flow using URL parameter -->
				 <a href="#"  class="btn btn-success" >
						<span class="glyphicon-comment glyphicon"></span>Process Orders	</a>
		</div>
		<table class="table table-hover">
			<tr>
				<td>Product Name</td>
				<td>Unit Price</td>
				<td>Quantity</td>
				<td>Sub Total</td>
			</tr>
			 
			<c:forEach items="${shoppingCarts }" var="shoppingCart">
			<tr>
				<td>${shoppingCart.orderDetails.product.pName }</td>
				<td>${shoppingCart.orderDetails.unitCost }</td>
				<td>${shoppingCart.quantity }</td>
				<td>$ ${shoppingCart.orderDetails.subTotal }</td>
				<td>
						<a href="#" onclick="removeFromShoppingCart('${shoppingCart.id}')" style= "background-color:red" >Cancel
						</a>
				</td>
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
					<td><a href="<spring:url value="/products" />"  class="btn btn-success ">
					  <span class="glyphicon-comment glyphicon"></span>More Orders	</a>
					</td>
					<td></td>
					<td></td>
					<td><a href="#" onclick="deleteAllCarts()"  class="btn btn-success" >
						<span class="glyphicon-comment glyphicon"></span>Cancel Shopping	</a>
					</td>
			</tr>
		</table>
	</div>
</body>
</html>