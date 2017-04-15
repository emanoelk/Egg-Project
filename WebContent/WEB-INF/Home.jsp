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
		}
	</style>
</head>
<body>
	<div>
		<form class="form-inline" action="Inventory" method="post"> 
			<div class="form-group">
				<input type="text" class="form-control" placeholder = "Something" name="search">
			</div>
			
			<button type="submit" class="btn btn-default">Search</button>
		</form>
		 <h6 class = 'tab'>Login</h6>
		 <h6 class = 'tab'>Sign Up</h6>		
	</div>

	<div class="container">
		<div class="page-header">
			<h1>
				Eggs in a Zap
			</h1>
		</div>
		<div>			
		<form class="form-inline" action="Inventory" method="post"> 
			<div class="form-group">
				<input type="text" class="form-control" placeholder = "Something" name="search">
			</div>
			
			<button type="submit" class="btn btn-default">Search</button>
		</form>
		</div>
	
	<br/>
	
	<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>
						Farm Name
					</th>
					<th>
						Description
					</th>
				</tr> 
			</thead>
			<c:forEach items="${Farms}" var="farm">
				<tr>
					<td>${farm.farmName}</td>
					<td>${farm.description}</td>
					
				</tr>
			</c:forEach>
	</table>


	</div>
</body>
</html>