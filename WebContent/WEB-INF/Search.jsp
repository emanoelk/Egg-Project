<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
		<form class="form-inline" action="Search" method="post" style = 'margin-left: 50px; margin-right: 50px;'> 
			<div class="form-group">
				<input type="text" class="form-control" name="search">
			</div>
			
			<button type="submit" class="btn btn-default">Search</button>
		</form>
		</div>
		<div class = 'tab'>
		<a class="btn btn-default" href="./HomeUser" >Home</a>
		<a  class="btn btn-default" href="./EggCart" >Cart</a>
		<a  class="btn btn-default" href="./EggHistory" >Egg History</a>
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
	
	
	<h6>Main Search Results</h6>
	<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>Farm Name</th>
					<th>Eggs in Stock</th>
				</tr> 
			</thead>
			<c:forEach items = "${farms}" var="farm">				
				<tr>
					<td><a class="btn btn-success" href = "FarmInventory?id=${farm.farmId}&farmName= ${farm.farmName}">${farm.farmName}</a></td>
					<td>${farm.inventory}</td>			
				</tr>
			</c:forEach>
	</table>

	</div>
</body>
</html>