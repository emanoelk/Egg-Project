<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout</title>
</head>
<body>
	<div class="container">

		<!-- Page Header -->
		<div class="page-header">
			<h2>
			<small>	Checkout <small>
				</small> </small>
			</h2>
		</div>


		<c:if test="${empty eggcart}">
			<div class="jumbotron">
				<h1>
					<small>You can't buy anything if you don't have anything in your Cart.</small>
				</h1>
			</div>
		</c:if>

		<c:if test="${not empty eggcart}">
				<form action="EggOrder" method="post">
					<div class="row">
						<div class="col-xs-9 col-sm-10">
							<div class="form-group">
								<label class="sr-only" for="fname">First Name</label> <input
									type="text" class="form-control" id="fname" name="fname"
									placeholder="Enter first name">
							</div>
							<div class="form-group">
								<label class="sr-only" for="lname">Last Name</label> <input
									type="text" class="form-control" id="lname" name="lname"
									placeholder="Enter last name">
							</div>
							<div class="form-group">
								<label class="sr-only" for="email">Email</label>
								<input type="text" class="form-control" id="email"
									name="email" placeholder="Enter your email">
							</div>
							<c:if test="${not empty error}">
								<p class="well-sm bg-danger">${error}</p>
							</c:if>
							<c:if test="${not empty buyer_Id}">
								<input type="hidden" id="buyerid" name="buyerid" value="${buyer_Id}">
							</c:if>
							<c:if test="${empty buyer_Id}">
								<input type="hidden" id="buyerid" name="buyerid" value="0">
							</c:if>
						</div>
					</div>
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
				Total Cost: $
				<tr>${totalCost}</tr>
			</table>
				<button type="submit" class="btn btn-success btn-block">Confirm Purchase</button>			
		</form>
		</c:if>
		</div>
</body>
</html>