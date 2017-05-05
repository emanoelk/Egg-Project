<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="en">
<head>
<title>Farm</title>
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
	
<%-- <link rel="stylesheet" href="https://bootswatch.com/paper/bootstrap.min.css"> --%>
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

	<!-- Needs divider for buyer and non-buyer -->
	<c:choose>
		<c:when test="${buyer_Id == null}">
			<div class='bar'>
				<h6 class='tab' style="margin-left: -10px;">EGZ</h6>
				<div class='tab'>
					<form class="form-inline" action="Search" method="post"
						style='margin-left: 50px; margin-right: 50px;'>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Something"
								name="search">
						</div>

						<button type="submit" class="btn btn-default">Search</button>
					</form>
				</div>
				<div class='tab'>
					<a class="btn btn-default" href="./Home" role="button">Home</a> <a
						class="btn btn-default" href="./EggCart" role="button">Cart</a> <a
						class="btn btn-default" href="./Login" role="button">Login</a> <a
						class="btn btn-default" href="./SignUp" role="button">Sign Up</a>
				</div>
			</div>

			<br />

			<div class="container">

				<!-- Page Header -->

			</div>


		</c:when>

		<c:otherwise>
			<div class='bar'>
				<h6 class='tab' style="margin-left: -10px;">EGZ</h6>
				<div class='tab'>
					<form class="form-inline" action="Search" method="post"
						style='margin-left: 50px; margin-right: 50px;'>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Something"
								name="search">
						</div>

						<button type="submit" class="btn btn-default">Search</button>
					</form>
				</div>
				<div class='tab'>
					<a class="btn btn-default" href="./HomeUser" role="button">Home</a>
					<a class="btn btn-default" href="./EggCart" role="button">Cart</a>
					<a class="btn btn-default" href="./EggHistory" role="button">Egg
						History</a> <a class="btn btn-default" href="./Logout" role="button">Log
						Out</a>
				</div>
			</div>

			<br />



		</c:otherwise>
	</c:choose>

	<div class="container">

		<div align="center">

			<h1>${ requestScope.fname}</h1>

			<div style="width: 30%; float: left">
				<h3>"farm picture here"</h3>
			</div>
			<div style="width: 70%; float: right">
				<h3>${ requestScope.fdesc}</h3>
				<h4>${ requestScope.inv}Eggs in inventory at $ ${ requestScope.price}
				</h4>

				<c:url value="AddCart" var="EggCart">
					<c:param name="id" value="${requestScope.fid}" />
					<c:param name="quantity" value="1" />
				</c:url>
				<a class="btn btn-primary btn-xs" href="${EggCart}">Add to Cart</a>



			</div>
			<a type="button" class="btn btn-primary btn-lg"
				href="./livestream.jsp">Live Feed</a>

		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Buyer</th>
					<th>Message</th>

				</tr>
			</thead>
			<c:forEach items="${Comment}" var="comments">
				<tr>
					<td>${comments.userName}</td>
					<td>${comments.message }</td>
				</tr>
			</c:forEach>
		</table>

		<c:if test="${itWorks == true }">
			<form action="AddComment" method='post'>
				<textarea class="form-control" rows="3" name='message'></textarea>
				<input type="hidden" name="farmId" value=${requestScope.farmId }>
				<button type='submit'>Add Comment</button>
			</form>
		</c:if>

	</div>

</body>
</html>