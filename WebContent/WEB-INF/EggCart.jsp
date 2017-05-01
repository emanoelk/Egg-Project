<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="en">
<head>
<title>Egg Cart</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<%-- <link rel="stylesheet" href="https://bootswatch.com/paper/bootstrap.min.css"> --%>
<style>
		.tab{
			display: inline-block;
			padding: 10px;
		
		}
		.options{
		padding: 10pz
		}
		.bar{
		border-bottom: solid;
		border-width:1px;
		margin-left: 50px;		
		margin-right: 50px;
		}
		
</style>
</head>
<body>

<c:choose>
	<c:when test = "${buyer_Id == null }">
		<div class = 'bar'>
			<h6 class = 'tab' style = "margin-left: -10px;">EGZ</h6>
			<div class = 'tab'>
			<form class="form-inline" action="Search" method="post" style = 'margin-left: 50px; margin-right: 50px;'> 
				<div class="form-group">
					<input type="text" class="form-control" placeholder = "Something" name="search">
				</div>
				
				<button type="submit" class="btn btn-default">Search</button>
			</form>
			</div>
			<div class = 'tab'>
			<a class="btn btn-default" href="./Home" role="button">Home</a>
			<a  class="btn btn-default" href="./EggCart" role="button">Cart</a>
			<a  class="btn btn-default" href="./Login" role="button">Login</a>
			<a  class="btn btn-default" href="./SignUp" role="button">Sign Up</a>
			</div>		
		</div>
	</c:when>
	<c:otherwise>
		<div class = 'bar'>
			<h6 class = 'tab' style = "margin-left: -10px;">EGZ</h6>
			<div class = 'tab'>
			<form class="form-inline" action="Search" method="post" style = 'margin-left: 50px; margin-right: 50px;'> 
				<div class="form-group">
					<input type="text" class="form-control" placeholder = "Something" name="search">
				</div>
				
				<button type="submit" class="btn btn-default">Search</button>
			</form>
			</div>
			<div class = 'tab'>
			<a class="btn btn-default" href="./HomeUser" role="button">Home</a>
			<a  class="btn btn-default" href="./EggCart" role="button">Cart</a>
			<a  class="btn btn-default" href="./EggHistory" role="button">Egg History</a>
			<a  class="btn btn-default" href="./Logout" role="button">Log Out</a>
			</div>		
		</div>
	</c:otherwise>
</c:choose>

	<br>

	<div class="container">
			<c:if test="${empty eggcart}">
				<div class="jumbotron">
					<h1>
						 <small>There are no items in your cart to display.</small>
					</h1>
				</div>
			</c:if>
	
			<c:if test="${not empty eggcart}">
				<table class="table table-hover table-striped table-bordered">
					<thead>
						<tr>
							<th>Item</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Total Cost</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${eggcart}" var="egg">
							<tr>
								<td>${egg.name}</td>
								<td>${egg.price}</td>
								<td>${egg.quantity}</td>
								<td>${egg.itemcost}</td>
							</tr>
						</c:forEach>
					</tbody>				
				</table>
				<div>
					<h5 style = "display: inline-block;">Total Cost: $</h5>
					<h6 style = "display: inline-block;">${totalCost}</h6>
				</div>
				<br>
				<a class="btn btn-primary btn-xs" href="EggCheckout">Proceed to Checkout</a>
			</c:if>
	</div>
	
</body>
</html>