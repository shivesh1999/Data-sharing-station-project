<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/4.6.0/css/bootstrap.min.css">
<script type="text/javascript" src="/webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	<br><h3>User Registration</h3><br>
	
	<form action="/addUser" method="post">
		<div class="mb-3">
  			<label for="userName" class="form-label">User Name</label>
  			<input type="text" class="form-control" name="userName" placeholder="Enter Username" required="required">
		</div>
		<div class="mb-3">
  			<label for="userEmail" class="form-label">Email</label>
  			<input type="email" class="form-control" name="userEmail" placeholder="abc@example.com" required="required">
		</div>
		<div class="mb-3">
  			<label for="password" class="form-label">Password</label>
  			<input type="password" class="form-control" name="password" placeholder="Enter a Strong password" min="8" required="required">
		</div>
		<button type="submit" class="btn btn-success">Register</button><br><br>
	</form>
	
	<p>${msg}</p>
	<div>
		<h6>Already a user ? <a href="/loginPage">log In</a></h6>
	</div>
	</div>
</body>
</html>