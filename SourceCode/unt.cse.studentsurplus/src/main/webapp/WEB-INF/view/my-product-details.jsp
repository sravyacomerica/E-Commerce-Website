<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Product Details</title>
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

.button {
	background-color: black; /* Green */
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}

.progress-bar {
	background-color: black;
	color: black;
}
</style>
</head>
<body>
	<form:form action="allProductsByUser" commandName="Product"
		method="POST" enctype="multipart/form-data">
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
							</ul></li>
					</ul>
			</div>
		</div>
		</nav>
		<center>
			<h2 style="color: black; margin-top: 10%;">Products posted by
				you</h2>
		</center>
		<div class="progress">
			<div class="progress-bar bg-danger" role="progressbar"
				style="width: 100%;" aria-valuenow="100" aria-valuemin="0"
				aria-valuemax="100"></div>
		</div>
		<c:forEach items="${productList}" var="element" varStatus="status">
			<div class="container-fluid" style="margin-top: 8%">
				<div class="row" id="product">
					<div class="col-lg-6 col-sm-6 col-md-6">
						<div style="margin-left: 30%;">
							<img style="width: 300px; height: 300px;" class="thumbnail"
								src="${pageContext.request.contextPath}/resources/images/${element.imageName}"
								alt="...">
						</div>
					</div>
					<div id="myproducts" class="col-lg-6 col-sm-6 col-md-6">
						<h4 style="color: black;">Product Name: ${element.name}</h4>
						<h4 style="color: black;">Category: ${element.category}</h4>
						<h4 style="color: black;">Negotiable: ${element.negotiable}</h4>
						<h4 style="color: black;">Months Used: ${element.monthsUsed}</h4>
						<h4 style="color: black;">Description: ${element.description}</h4>
						<h4 style="color: black;">Price: ${element.price}</h4>
						<a style="color: white;"
							href="<c:url value='/removeProduct/${productList[status.index].productId}'/>"
							class="button" role="button"> <i class="material-icons"
							style="margin-right: -1%;">delete</i>Remove
						</a> <a style="color: white; background-color: green;"
							href="<c:url value='/removeProduct/${productList[status.index].productId}'/>"
							class="button" role="button"> SOLD</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</form:form>
</body>
<script type="text/javascript">
	
</script>
</html>