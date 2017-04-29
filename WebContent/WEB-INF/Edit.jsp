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
			<a  class="btn btn-default" href="./Cart" >Cart</a>
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
	
	<form action="Edit" method="post">
	
		FarmName: <input type="text" name="farmName" value="${Farm.farmName}" placeholder= "${Farm.farmName}"/> <br />
		
		Description: <textarea name="description" placeholder= "${Farm.description}">${Farm.description}</textarea> <br />

		Inventory: <textarea name="inventory" placeholder= "${Farm.inventory}">${Farm.inventory}</textarea> <br />

		<input type="hidden" name="id" value="${Farm.farmer_Id}" />
		
		<input type="submit" name="save" value="Save" />
	</form>
	
	</div>
</body>
</html>
