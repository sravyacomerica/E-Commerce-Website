<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Post Product</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="../../assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/custom.css">
<script src="js/jquery.js"></script>
<script class="jsbin"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body {
	font-family: sans-serif;
	background-color: white;
	text-decoration-color: black;
}

label {
	color: black;
}
</style>
</head>
<body>
	<form:form name="postproduct" onsubmit="return validate()"
		action="saveProduct" commandName="Product" method="POST"
		enctype="multipart/form-data">
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
			</div>
			<div class="navbar-collapse collapse" id="navbar"
				aria-expanded="false">
				<ul class="nav navbar-nav navbar-right">
					<a class="navbar-brand" href="#"><i id="home"
						class="material-icons">home</i></a>
					<li><a id="ncolor"
						href="/unt.cse.studentsurplus/home-after-login"><b>Home</b></a></li>
					<a class="navbar-brand" href="#"><i class="material-icons">library_books</i></a>
					<li><a id="ncolor"
						href="${pageContext.request.contextPath}/postProductForm"><b>Sell</b></a></li>
					<a class="navbar-brand" href="#"><i id="home"
						class="material-icons">shopping_cart</i></a>
					<li><a id="ncolor"
						href="${pageContext.request.contextPath}/viewWishList"><b>cart</b></a></li>
					<a class="navbar-brand" href="#"><i id="home"
						class="material-icons">list_alt</i></a>
					<li><a id="ncolor"
						href="/unt.cse.studentsurplus/allProductsByUser"><b>My
								Products</b></a></li>
					<ul class="nav navbar-nav navbar-right">
						<a class="navbar-brand" href="#"><i id="home"
							class="material-icons">person</i></a>
						<li class="dropdown"><a
							href="/unt.cse.studentsurplus/myProfile" id="ncolor"
							class="dropdown-toggle" data-toggle="dropdown" role="button">${name}
								<span class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="/unt.cse.studentsurplus/myProfile">Edit
										Profile</a></li>
								<li><a href="/unt.cse.studentsurplus/logout">Logout</a></li>
								<li><a href="#">My Products</a></li>
							</ul></li>
					</ul>
			</div>
		</div>
		</nav>

		<div class="container-fluid" style="margin-top: 10%">
			<center>
				<img src="resources/images/tick.png">
			</center>
			<center>
				<h1>Congratulations, your product has been posted successfully!</h1>
			</center>
			<center>
				<h3>To view or remove your product or to change the status to
					sold, please go to my products on the top bar.</h3>
			</center>
		</div>
	</form:form>
</body>
</html>