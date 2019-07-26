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
	background-color: #eeeeee;
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
		<div class="container-fluid back">
			<div class="block">
				<label id="main">Name</label>
				<form:input path="name" id="Name" name="Name" type="text"
					class="thumbnail" />
			</div>
			<div class="block">
				<label>Category</label>
				<form:select path="category" class="thumbnail">
					<form:option value="" />
					<form:option value="Furniture" />
					<form:option value="Electronic Devices" />
					<form:option value="Mattresses" />
					<form:option value="Books" />
					<form:option value="Others" />
				</form:select>
			</div>

			<div class="block">
				<label>Months Used</label>
				<form:input path="monthsUsed" id="MonthsUsed" name="MonthsUsed"
					type="text" class="thumbnail" />
			</div>
			<div class="block">
				<label>Price</label>
				<form:input path="price" tid="Price" name="Price" ype="text"
					class="thumbnail" />
			</div>
			<div class="block">

				<label>Negotiable</label>
				<form:select path="negotiable" class="thumbnail">
					<form:option value="Yes" />
					<form:option value="No" />
				</form:select>
			</div>
			<div class="block">
				<label>Description</label>
				<form:textarea rows="5" cols="30" path="description"
					id="Description" name="Description" type="text" class="thumbnail" />
			</div>
			<div class="file-upload">
				<button class="file-upload-btn" type="button"
					onclick="$('.file-upload-input').trigger( 'click' )">Add
					Image</button>

				<div class="image-upload-wrap">
					<form:input path="picture" id="Picture" name="Picture"
						class="file-upload-input" type='file' onchange="readURL(this);"
						accept="image/*" />
					<div class="drag-text">
						<h5>Drag and drop a file or select add Image</h5>
					</div>
				</div>
				<div class="file-upload-content">
					<img class="file-upload-image" src="#" alt="your image" />
					<div class="image-title-wrap">
						<button type="button" onclick="removeUpload()"
							class="remove-image">
							Remove <span class="image-title">Uploaded Image</span>
						</button>
					</div>
				</div>
			</div>
			<center>
				<button id="submit" class="btn btn-success"
					style="margin-top: 10px; margin-left: 80px; margin-bottom: 30px;"
					onclick="validate()" type="submit">Submit</button>
			</center>
		</div>
	</form:form>
</body>
<script type="text/javascript">
	function readURL(input) {
		if (input.files && input.files[0]) {

			var reader = new FileReader();

			reader.onload = function(e) {
				$('.image-upload-wrap').hide();

				$('.file-upload-image').attr('src', e.target.result);
				$('.file-upload-content').show();

				$('.image-title').html(input.files[0].name);
			};

			reader.readAsDataURL(input.files[0]);

		} else {
			removeUpload();
		}
	}

	function validate() {
		var title = document.forms["postproduct"]["Name"].value;
		var author = document.forms["postproduct"]["MonthsUsed"].value;
		var year = document.forms["postproduct"]["Price"].value;
		var newspaper = document.forms["postproduct"]["Description"].value;
		var pages = document.forms["postproduct"]["Picture"].value;

		if (Name == "") {
			alert("Name must be filled out!");
			return false;
		}
		if (MonthsUsed == "") {
			alert("MonthsUsed must be filled out!");
			return false;
		}
		if (Price == "") {
			alert("Price must be filled out!");
			return false;
		}
		if (Description == "") {
			alert("Description must be filled out!");
			return false;
		}
		return true;
	}

	function removeUpload() {
		$('.file-upload-input').replaceWith($('.file-upload-input').clone());
		$('.file-upload-content').hide();
		$('.image-upload-wrap').show();
	}
	$('.image-upload-wrap').bind('dragover', function() {
		$('.image-upload-wrap').addClass('image-dropping');
	});
	$('.image-upload-wrap').bind('dragleave', function() {
		$('.image-upload-wrap').removeClass('image-dropping');
	});
</script>
</html>