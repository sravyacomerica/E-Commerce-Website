<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Registration Success</title>
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
				<ul class="nav navbar-nav navbar-right" style="margin-left: -8%;">
					<a class="navbar-brand" href="#"><i id="home"
						class="material-icons">home</i></a>
					<li style="margin-left: -2%; margin-top: 1%;"><a id="ncolor"
						href="/unt.cse.studentsurplus/home"><b>Home</b></a></li>
					<a class="navbar-brand" href="#"><i id="home"
						class="material-icons">person</i></a>
					<li style="margin-left: -2%; margin-top: 1%;"><a id="ncolor"
						href="/unt.cse.studentsurplus/login"><b>Login/Register</b></a></li>
				</ul>
			</div>
		</div>
		</nav>

		<div class="container-fluid" style="margin-top: 10%">
			<center>
				<img src="resources/images/tick.png">
			</center>
			<center>
				<h1>Congratulations, you have been registered successfully!</h1>
			</center>
			<center>
				<h3>To post a product or contact a seller, please login.</h3>
			</center>
		</div>
	</form:form>
</body>
</html>