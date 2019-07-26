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
	<div class="container col-md-6" style="margin-top: 7%;">
		<div class="alert alert-success alert-dismissible fade show"
			role="alert">
			<strong>Success!</strong> Welcome to StudentSurplus!
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
		<form action="editUserForm" method="POST">
			<input type="hidden" name="userId" value="${user.user_id}" />
			<table class="table">
				<tr>
					<td><h3 style="color: black;">My Profile</h3></td>
					<td><img width="100px" height="100px"
						src="${pageContext.request.contextPath}/resources/images/${user.user_id}.jpg"
						alt="profile picture" class="rounded-circle .img-thumbnail">

					</td>

					<td><button class="btn btn-danger" type="submit">Edit</button></td>
				</tr>
			</table>
		</form>
		<hr />
	</div>
	<div class="container col-md-6">

		<table class="table table-borderless">

			<tbody>

				<tr>
					<td>First Name:</td>
					<td>${user.first_name}</td>

				</tr>
				<tr>
					<td>Middle Name:</td>
					<td>${user.middle_name}</td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td>${user.last_name}</td>
				</tr>
				<tr>
					<td>Email:</td>
					<td>${user.email}</td>
				</tr>
				<tr>
					<td>Phone Number:</td>
					<td>${user.phone_number}</td>
				</tr>

			</tbody>
		</table>

		<form action="editUserAddressForm" method="POST">
			<input type="hidden" name="addressId" value="${address.address_id}" />
			<table class="table">
				<tr>
					<td><h4 style="color: black;">Address</h4></td>

					<td><button class="btn btn-danger" type="submit">Edit</button></td>
				</tr>
			</table>
		</form>

		<table class="table table-borderless">

			<tbody>

				<tr>
					<td>Street:</td>
					<td>${address.street}</td>

				</tr>
				<tr>
					<td>Apartment:</td>
					<td>${address.apartment}</td>
				</tr>
				<tr>
					<td>City:</td>
					<td>${address.city}</td>
				</tr>
				<tr>
					<td>State:</td>
					<td>${address.state}</td>
				</tr>
				<tr>
					<td>Zip Code:</td>
					<td>${address.zip_code}</td>
				</tr>

			</tbody>
		</table>
	</div>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>


</body>

</html>









