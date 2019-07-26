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
	padding: 14px 16px;
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
				<ul style="margin-right: -15%">
					<li style="margin-bottom: -5%;"><a class="navbar-brand"
						href="#"></a></li>
					<li style="margin-left: -10%; margin-top: -2%;"><a id="ncolor"
						href="${pageContext.request.contextPath}/postProductForm"><b></b></a></li>
					<li><a class="navbar-brand" href="#"><i id="home"
							class="material-icons">person</i></a></li>
					<li style="margin-left: -10%; margin-top: -2%;"><a id="ncolor"
						href="/unt.cse.studentsurplus/login"><b>Login/Register</b></a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container col-md-6" style="margin-top: 5%">
		<h3 style="color: black;">New User Sign Up</h3>
		<hr />
	</div>
	<div class="container col-md-6">
		<form action="registration" method="POST" class="needs-validation"
			novalidate="novalidate" enctype="multipart/form-data">
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="firstName">First name</label>
					<spring:bind path="user.first_name">
						<input type="text" name="${status.expression}"
							value="${status.value}" class="form-control" id="firstName"
							placeholder="First Name" required="required" />
						<div class="valid-feedback">Validated</div>
					</spring:bind>
				</div>
				<div class="col-md-4 mb-3">
					<label for="middleName">Middle name</label>
					<spring:bind path="user.middle_name">
						<input name="${status.expression}" value="${status.value}"
							type="text" class="form-control" id="middleName"
							placeholder="Middle Name (optional)" />
						<div class="valid-feedback">Validated</div>
					</spring:bind>
				</div>
				<div class="col-md-4 mb-3">
					<label for="lastName">Last name</label>
					<spring:bind path="user.last_name">
						<input name="${status.expression}" value="${status.value}"
							type="text" class="form-control" id="lastName"
							placeholder="Last Name" required="required" />
						<div class="valid-feedback">Validated</div>
					</spring:bind>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<div class="form-group">
						<label for="email">Email</label>
						<spring:bind path="user.email">
							<input name="${status.expression}" value="${status.value}"
								type="email" class="form-control" id="email"
								placeholder="Enter Email" required="required"
								aria-describedby="emailHelp" />
							<div class="valid-feedback">Validated</div>
							<h6 style="color: red;">${sessionScope.Error_message}</h6>
							<%
								session.setAttribute("Error_message", "");
							%>
						</spring:bind>
					</div>
				</div>
				<div class="col-md-4 mb-3">
					<label for="phoneNumber">Phone Number</label>
					<spring:bind path="user.phone_number">
						<input name="${status.expression}" value="${status.value}"
							type="text" class="form-control" id="phoneNumber"
							placeholder="Enter Phone Number" required="required" />
						<div class="valid-feedback">Validated</div>
					</spring:bind>
				</div>

			</div>
			<h4>Address</h4>
			<hr />
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="street">Street</label>
					<spring:bind path="address.street">
						<input name="${status.expression}" value="${status.value}"
							type="text" class="form-control" id="street"
							placeholder="1234 Main St" required="required" />
						<div class="valid-feedback">Validated</div>
					</spring:bind>
				</div>
				<div class="col-md-4 mb-3">
					<label for="apartmentNumber">Apartment Number</label>
					<spring:bind path="address.apartment">
						<input name="${status.expression}" value="${status.value}"
							type="text" class="form-control" id="apartmentNumber"
							placeholder="Apartment Number" required="required" />
						<div class="valid-feedback">Validated</div>
					</spring:bind>
				</div>
				<div class="col-md-4 mb-3">
					<label for="city">City</label>
					<spring:bind path="address.city">
						<input name="${status.expression}" value="${status.value}"
							type="text" class="form-control" id="city" placeholder="city"
							required="required" />
						<div class="valid-feedback">Validated</div>
					</spring:bind>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="state">State</label>
					<spring:bind path="address.state">
						<input name="${status.expression}" value="${status.value}"
							type="text" class="form-control" id="state" placeholder="State"
							required="required" />
						<div class="valid-feedback">Validated</div>
					</spring:bind>
				</div>
				<div class="col-md-4 mb-3">
					<label for="zipCode">Zip Code</label>
					<spring:bind path="address.zip_code">
						<input name="${status.expression}" value="${status.value}"
							type="text" class="form-control" id="zipCode"
							placeholder="Zip Code" required="required" />
						<div class="valid-feedback">Validated</div>
					</spring:bind>
				</div>

			</div>
			<hr />

			<div class="col-md-4 mb-3">
				<label for="picture">Profile Picture</label>
				<spring:bind path="user.picture">
					<input name="${status.expression}" value="${status.value}"
						type="file" class="form-control" id="picture"
						placeholder="Choose photo" />
				</spring:bind>
			</div>

			<div class="col-md-4 mb-3">
				<label for="password">Password</label>
				<spring:bind path="logincred.password">
					<input name="${status.expression}" value="${status.value}"
						type="password" class="form-control" id="password"
						placeholder="type password" required="required" />
					<div class="valid-feedback">Validated</div>
				</spring:bind>
			</div>

			<div class="form-group">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value=""
						id="invalidCheck" required> <label
						class="form-check-label" for="invalidCheck"> Agree to
						terms and conditions </label>
					<div class="invalid-feedback">You must agree before
						submitting.</div>
				</div>
			</div>
			<button class="btn btn-success" type="submit">Submit</button>
		</form>
	</div>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

	<script>
		var error = document.getElementById(error);
		if (error == "Email already exists!") {
			alert(error);
		}

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









