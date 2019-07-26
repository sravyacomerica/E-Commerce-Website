<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home Page</title>
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
</style>
</head>
<body>
	<form action="/home-after-login" method=POST>
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
					<ul class="nav navbar-nav navbar-right" style="color: black;">
						<a class="navbar-brand" href="#"><i id="home"
							class="material-icons">person</i></a>
						<li class="dropdown"><a
							href="/unt.cse.studentsurplus/myProfile" style="color: black;"
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
		<div id="first" class="container-fluid">
			<div class="container" align="center">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
					</ol>

					<div class="carousel-inner">
						<div class="item active">
							<img src="resources/images/sofa.jpg" style="width: 80%;"
								style="height=50%;" alt="paneer">
						</div>

						<div class="item">
							<img src="resources/images/phone.jpg" alt="maincourse"
								style="width: 80%;">
						</div>

						<div class="item">
							<img src="resources/images/lamp.jpg" alt="sushi"
								style="width: 80%;">
						</div>
					</div>
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
		<div id="custom-search-input">
			<div class="input-group col-md-12">
				<spring:bind path="Search.searchString">
					<input type="text" class="form-control input-lg"
						placeholder="Search" name="${status.expression}"
						value="${status.value}" type="text" class="form-control input-lg"></input>
				</spring:bind>
				<span class="input-group-btn">
					<button class="btn btn-info btn-lg" type="Submit"
						onclick="location.href = 'http://localhost:8080/unt.cse.studentsurplus/processSearch';">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</span>
			</div>
		</div>
		</div>
		<div class="container-fluid" id="products">
			<div class="row" id="product">
				<c:forEach items="${productList}" var="element" varStatus="status">
					<div class="col-lg-4 col-sm-6 col-md-4">
						<div class="thumbnail">
							<img style="width: 250px; height: 200px;"
								src="${pageContext.request.contextPath}/resources/images/${element.imageName}"
								alt="...">
							<div class="caption">
								<h4 style="color: black;">Product Name: ${element.name}</h4>
								<h4 style="color: red;">Price: $${element.price}</h4>
								<h4 style="color: black;">Months Used:
									${element.monthsUsed}</h4>
								<h4 style="color: black;">Negotiable: ${element.negotiable}</h4>
								<a
									href="<c:url value='/addToCart/${productList[status.index].productId}'/>"
									class="btn btn-success" role="button">Add to cart</a> <a
									href="<c:url value='/productDetail/${productList[status.index].productId}'/>"
									class="btn btn-default" role="button">View Details</a> <a
									href="<c:url value='/sendEmail/${productList[status.index].productId}'/>">
									<i class="material-icons" style="color: black;">mail</i>
								</a>

							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div id="last" class="container-fluid ">
			<div class="row">
				<div class="col-lg-3 col-md-3 col-xs-12 col-sm-12 ">
					<ul>
						<p style="margin-top: 30px;">
						<h4>Information</h4>
						<li><a class="active" href="#" class="text-left;"><h5>About
									us</h5></a></li>
						<li><a href="#"><p id="footer" class="text-left;">
								<h5>Information</h5></a></li>
						<li><a href="#"><p id="footer" class="text-left;">
								<h5>Testimonials</h5></a></li>
						<li><a href="#"><p id="footer" class="text-left;">
								<h5>Archives</h5></a></li>
						<li><a href="#"><p id="footer" class="text-left;">
								<h5>Privacy Policy</h5></a></li>
					</ul>
				</div>
				<div class="col-lg-3 col-md-3 col-xs-12 col-sm-12">
					<ul>
						<p class="text-left;" style="margin-top: 30px;">
						<h4>Why buy from us</h4>
						<li><a href="#"><p id="footer" class="text-left;">
								<h5>Shipping Returns</h5></a></li>
						<li><a href="#"><p id="footer" class="text-left;">
								<h5>Secure Shopping</h5></a></li>
						<li><a href="#"><p id="footer" class="text-left;">
								<h5>Affiliates</h5></a></li>
						<li><a href="#"><p id="footer" class="text-left;">
								<h5>Group Sales</h5></a></li>
					</ul>
				</div>
				<div class="col-lg-3 col-md-3 col-xs-12 col-sm-12">
					<p class="text-left;" style="margin-top: 30px;">
					<h4>Follow us on</h4>
					<img id="footer" src="resources/images/fb.png"> <img
						id="footer" src="resources/images/ins.png"> <img id="footer"
						src="resources/images/tw.png">
				</div>
				<div class="col-lg-3 col-md-3 col-xs-12 col-sm-12">
					<p class="text-left;" style="margin-top: 30px;">
					<h4>Contact Us</h4>
					<p class="text-left;" style="color: red; margin-top: 30px;">
					<h4>+1 9678488823</h4>
				</div>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
	
</script>
</html>