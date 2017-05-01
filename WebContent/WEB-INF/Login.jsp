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
		.block{
		padding:10px;
		padding-left: 25px;
		padding-rightt: 25px;
		border: solid;
		margin: 50px;
		margin-right: 250px;
		margin-left: 250px;
		border-width: 1px;
		}
	</style>
</head>
<body>
	<div class = 'bar'>
		<h6 class = 'tab' style = "margin-left: -10px;">EGZ</h6>
		<div class = 'tab'>
		<form class="form-inline" action="Inventory" method="post" style = 'margin-left: 50px; margin-right: 50px;'> 
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
	
	<br>
	
	
	<div class = 'block'>
		<form class="form-horizontal" action = "Login" method = "post">
		  <div class="form-group">
		    <label  class="col-sm-2 control-label">Username:</label>
		    <div class="col-sm-10">
		      <input type="username" class="form-control"  placeholder="username" name = 'username'>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">Password:</label>
		    <div class="col-sm-10">
		      <input type="password" class="form-control"  placeholder="Password" name = 'password'>
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default">Login</button>
		    </div>
		  </div>
		</form>
	</div>
</body>
</html>