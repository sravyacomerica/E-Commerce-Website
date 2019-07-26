<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Send Email</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/custom.css">
<link rel="stylesheet" type="text/css" href="custom.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
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
</style>
</head>
<body>
	<form action="sendEmail" method="POST">
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="home.jsp"> <i onClick="home.jsp"
					class="material-icons">home</i>

				</a>
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
		<div class="block" style="margin-top: 10%; margin-left: -18%;">
			<label style="color: black;">Compose an email to the Seller:</label>
			<spring:bind path="Email.text">
				<textarea rows="5" cols="50" id="Description"
					name="${status.expression}" value="${status.value}" type="text"
					class="thumbnail" /></textarea>
			</spring:bind>
		</div>
		<center>
			<button style="color: white;" onclick="submit" class="button">Send
				email</button>
		</center>
		<div id="last" class="container-fluid " style="margin-top: 10%;">
			<div class="row">
				<div class="col-lg-3 col-md-3 col-xs-12 col-sm-12 ">
					<ul>
						<p style="margin-top: 30px;"></p>
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
					<img id="footer"
						src="${pageContext.request.contextPath}/resources/images/fb.png">
					<img id="footer"
						src="${pageContext.request.contextPath}/resources/images/ins.png">
					<img id="footer"
						src="${pageContext.request.contextPath}/resources/images/tw.png">
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