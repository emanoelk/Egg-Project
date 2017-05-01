<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">

		<!-- Page Header -->
		<div class="page-header">
			<h2>
				Transaction History <small> <small> 
				</small>
				</small>

			</h2>
		</div>

		<c:if test="${empty eggHistory && empty eggbuyer}">
			<div class="jumbotron">
				<h1>
					<small>There are no items to display.</small>
				</h1>
			</div>
		</c:if>

		<c:if test="${not empty eggHistory }">
			<table class="table table-hover table-striped table-bordered">
				<thead>
					<tr>
						<th>Name</th>
						<th>Email</th>
						<th>Quantity</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${eggHistory}" var="item">
						<tr>
							<td>${item.name}</td>
							<td>${item.email}</td>
							<td>${item.quantity}</td>
							<td>${item.price}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if><c:if test="${not empty eggbuyer }">
			<table class="table table-hover table-striped table-bordered">
				<thead>
					<tr>
						<th>Item Name</th>
						<th>Quantity</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${eggbuyer}" var="item">
						<tr>
							<td>${item.farm}</td>
							<td>${item.quantity}</td>
							<td>${item.price}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		${type}${id}
		</div>
</body>
</html>