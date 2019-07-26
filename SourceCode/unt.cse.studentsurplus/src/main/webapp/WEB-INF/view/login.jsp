<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/global.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	type="text/javascript"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"
	type="text/javascript"></script>
<link rel="stylesheet" href="styles/global.css" />
<title>Login Page</title>

</head>
<style>
</style>
<body class="container login-container">
	<form:form method="POST" modelAttribute="login" action="login_do">
		<div class="loginpageform">
			<p class="error" id="error"></p>
			<h3 class="txtcnt">Sign in to your account</h3>
			<br />
			<form:input type="text" class="form-control logininputfield"
				path="login_id" placeholder="Email" />
			<br />
			<form:input type="password" class="form-control logininputfield"
				id="pwd" path="password" placeholder="Password" />
			<br /> <a href="/unt.cse.studentsurplus/registration" class="rgtbtn">
				Register Here </a>
			<button class="btn btn-success signin" value="submit" type="submit">Sign
				In</button>
		</div>
		<div>
			<h3 style="color: red;">${errorMessage}</h3>
		</div>
	</form:form>
</body>
<script>
	
</script>
</html>