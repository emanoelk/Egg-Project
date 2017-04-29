<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EGZ</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
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
	<div class = 'bar'>
		<h6 class = 'tab' style = "margin-left: -10px;">EGZ</h6>
		<div class = 'tab'>
		<form class="form-inline" action="Inventory" method="post" style = 'margin-left: 50px; margin-right: 50px;'> 
			<div class="form-group">
				<input type="text" class="form-control" name="search">
			</div>
			
			<button type="submit" class="btn btn-default">Search</button>
		</form>
		</div>
		<div class = 'tab'>
		<a class="btn btn-default" href="./HomeUser" >Home</a>
		<a  class="btn btn-default" href="./EggCart" >Cart</a>
		<a  class="btn btn-default" href="./Account" >Account</a>
		<a  class="btn btn-default" href="./Logout" >Log Out</a>
		</div>		
	</div>

	<div class="container">
		<div class="page-header">
			<h1>
				Eggs in a Zap
			</h1>
		</div>

	<br/>
	<h6>Personal List</h6>
	<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>Action</th>
					<th>Farm Name</th>
					<th>Description</th>
					<th>Action</th>
				</tr> 
			</thead>
			<c:forEach items="${Follow}" var="follow">
						<tr>
							<td><a class="btn btn-danger" href ="./Unfollow?id=${follow.id}">Unfollow</a></td>
						<!-- Link to farm will go here. -->
							<td><c:url value="FarmInventory" var="details">
									<c:param name="id" value="${follow.id}" />
								</c:url> <a href="${details}">${follow.farmName}</a></td>
							<td>${follow.descriptin}</td>
						
							<td><a class="btn btn-primary btn-sm" href = './AddCart'>Add Cart</a></td>					
						</tr>
			</c:forEach>
	</table>
	
	<c:if test="${empty Follow}">
			<div class="well">
				<h3 class="text-center">You are not following any farms at the moment.</h3>
			</div>
	</c:if>
	
	<h6>Main Store</h6>
	<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>Action</th>
					<th>Farm Name</th>
					<th>Description</th>
					<th>Eggs Available</th>
					<th>Adding to Cart</th>
					
				</tr> 
			</thead>
			<c:forEach items = "${Farm}" var="farm">				
				<tr>
					<td><a class="btn btn-success" href = "./Follower?buyer_id=${buyer_Id }&id=${farm.id}" >Follow</a>
				<!-- Link to farm will go here. -->
					<td><c:url value="FarmInventory" var="details">
									<c:param name="id" value="${farm.id}" />
								</c:url> <a href="${details}">${farm.farmName}</a></td>
					<td>${farm.description}</td>
					<td>${farm.inventory}</td>
					<td>&nbsp; <a href = './AddCart' class = 'btn btn-danger'>Add Cart</a></td></td>					
				</tr>
			</c:forEach>
	</table>


	</div>
</body>
</html>