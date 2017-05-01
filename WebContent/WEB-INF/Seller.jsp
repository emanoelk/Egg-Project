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
		<form class="form-inline" action="Search" method="post" style = 'margin-left: 50px; margin-right: 50px;'> 
			<div class="form-group">
				<input type="text" class="form-control" name="search">
			</div>
			
			<button type="submit" class="btn btn-default">Search</button>
		</form>
	</div>
	<div class = 'tab'>
		<a class="btn btn-default" href="./HomeUser" >Home</a>
		<c:url value="EggHistory" var="Egg">
									<c:param name="id" value="${seller_Id}" />
									<c:param name="type" value="seller" />
								</c:url> <a class="btn btn-default" href="${Egg}">History</a>
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
		
	<c:forEach items = "${Farms}" var="farm">
		<h3 style = "display: inline-block;">Welcome ${farm.farmName}</h3>	
		<a style = "display: inline-block;" type="button" class="btn btn-warning" href= "./Edit?seller_Id=${seller_Id}"><h4>Edit</h4></a>
					<h1>${farm.description}</h1>
					<h1>${farm.inventory}</h1>
			</c:forEach>
	
	</div>
</body>
</html>