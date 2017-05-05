<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
	integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
	integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
	integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
	crossorigin="anonymous"></script>
<style>
.tab {
	display: inline-block;
	padding: 10px;
}

.options {
	padding: 10pz
}

.bar {
	border-bottom: solid;
	border-width: 1px;
	margin-left: 50px;
	margin-right: 50px;
}
</style>
</head>
<body>
	<div class='bar'>
		<h6 class='tab' style="margin-left: -10px;">EGZ</h6>
		<div class='tab'>
			<form class="form-inline" action="Search" method="post"
				style='margin-left: 50px; margin-right: 50px;'>
				<div class="form-group">
					<input type="text" class="form-control" name="search">
				</div>

				<button type="submit" class="btn btn-default">Search</button>
			</form>
		</div>
		<div class='tab'>
			<a class="btn btn-default" href="./Home">Home</a> <a
				class="btn btn-default" href="./EggCart">Cart</a> <a
				class="btn btn-default" href="./Login">Login</a> <a
				class="btn btn-default" href="./SignUp">Sign Up</a>
		</div>
	</div>

	<div class="container">

		<!-- Page Header -->
		<div class="page-header">
			<h2>
				<small>Order Confirmed<small> </small>
				</small>
			</h2>
		</div>
		<div class="jumbotron">
			<h1>
				Thank you for shopping with us. <br /> <small>Your order id
					is: ${orderID}</small>
			</h1>
		</div>
	</div>
</body>
</html>