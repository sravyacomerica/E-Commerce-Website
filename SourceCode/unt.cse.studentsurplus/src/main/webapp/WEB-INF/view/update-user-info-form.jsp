<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>

<head>
<title>User Registration</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<style>
.navbar-default .navbar-nav>li>a:hover, .navbar-default .navbar-nav>li>a:focus
	{
	color: white;
}

.navbar {
	-webkit-box-shadow: 0 8px 6px -6px #999;
	-moz-box-shadow: 0 8px 6px -6px #999;
	box-shadow: 0 8px 6px -6px black;
	background-color: black;
	border-bottom: 1px solid black;
}

li {
	float: left;
	display: inline;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 12px 9px;
	text-decoration: none;
}

ul {
	list-style-type: none;
}

#ncolor:hover {
	color: white;
}

#ncolor {
	color: white;
}
</style>
<body>
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
			</div>
			<div style="margin-right: -15%">
				<ul>
					<li style="margin-top: 1%; margin-right: 5%;"><a
						class="navbar-brand" href="#"><i class="material-icons">home</i></a></li>
					<li style="margin-left: -10%; margin-bottom: 0;"><a
						id="ncolor"
						href="${pageContext.request.contextPath}/home-after-login"><b>Home</b></a></li>
					<li style="margin-top: 1%; margin-right: 5%;"><a
						class="navbar-brand" href="#"><i class="material-icons">input</i></a></li>
					<li style="margin-left: -10%; margin-bottom: 0;"><a
						id="ncolor"
						href="${pageContext.request.contextPath}/postProductForm"><b>Sell</b></a></li>
					<li style="margin-top: 1%; margin-right: 5%;"><a
						class="navbar-brand" href="#"><i class="material-icons">shopping_cart</i></a></li>
					<li style="margin-left: -10%; margin-bottom: 0;"><a
						id="ncolor" href="${pageContext.request.contextPath}/viewWishList"><b>Cart</b></a></li>

					<li style="margin-top: 1%; margin-right: 5%;"><a
						class="navbar-brand" href="#"><i class="material-icons">list_alt</i></a></li>
					<li style="margin-left: -10%; margin-bottom: 0;"><a
						id="ncolor"
						href="${pageContext.request.contextPath}/allProductsByUser"><b>My
								Products</b></a></li>
					<li style="margin-top: 1%; margin-right: 5%;"><a
						class="navbar-brand" href="#"><i id="home"
							class="material-icons">person</i></a>
					<li style="margin-left: -10%; margin-bottom: 0; color: white;"
						class="dropdown"><a style="padding: 15px 16px;"
						href="/unt.cse.studentsurplus/myProfile" style="color: black;"
						class="dropdown-toggle" data-toggle="dropdown" role="button">${name}
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" style="padding: 15px 16px;">
							<li><a href="/unt.cse.studentsurplus/myProfile"
								style="color: black;">Edit Profile</a></li>
							<li><a href="/unt.cse.studentsurplus/logout"
								style="color: black;">Logout</a></li>
							<li><a href="#" style="color: black;">My Products</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container col-md-6" style="margin-top: 5%;">
		<h3 style="color: black;">Edit Profile Info</h3>
		<hr />
	</div>
	<div class="container col-md-6">
		<form:form action="updateUserInfo" modelAttribute="user" method="POST"
			class="needs-validation" novalidate="novalidate">
			<h4>Basic Info</h4>
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<input type="hidden" name="userId" value="${user.user_id}" /> <label
						for="firstName">First name</label>
					<form:input path="first_name" type="text" class="form-control"
						id="firstName" placeholder="First Name" required="required" />
					<div class="valid-feedback">Looks good!</div>
				</div>
				<div class="col-md-4 mb-3">
					<label for="middleName">Middle name</label>
					<form:input path="middle_name" type="text" class="form-control"
						id="middleName" placeholder="Middle Name (optional)" />
					<div class="valid-feedback">Looks good!</div>
				</div>
				<div class="col-md-4 mb-3">
					<label for="lastName">Last name</label>
					<form:input path="last_name" type="text" class="form-control"
						id="lastName" placeholder="Last Name" required="required" />
					<div class="valid-feedback">Looks good!</div>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<div class="form-group">
						<label for="email">Email</label>
						<form:input path="email" type="email" class="form-control"
							id="email" placeholder="Enter Email" required="required"
							aria-describedby="emailHelp" />
						<div class="valid-feedback">Looks good!</div>
					</div>
				</div>
				<div class="col-md-4 mb-3">
					<label for="phoneNumber">Phone Number</label>
					<form:input path="phone_number" type="text" class="form-control"
						id="phoneNumber" placeholder="Enter Phone Number"
						required="required" />
					<div class="valid-feedback">Looks good!</div>
				</div>

			</div>

			<button class="btn btn-success" type="submit">Submit</button>
		</form:form>
	</div>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

	<script>
		(function() {
			'use strict';
			window.addEventListener('load',
					function() {
						var forms = document
								.getElementsByClassName('needs-validation');
						var validation = Array.prototype.filter.call(forms,
								function(form) {
									form.addEventListener('submit', function(
											event) {
										if (form.checkValidity() === false) {
											event.preventDefault();
											event.stopPropagation();
										}
										form.classList.add('was-validated');
									}, false);
								});
					}, false);
		})();
	</script>
</body>

</html>









