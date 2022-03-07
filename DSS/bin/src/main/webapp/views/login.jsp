<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/4.6.0/css/bootstrap.min.css">
<script type="text/javascript" src="/webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	<br>
	<h4>Sign in</h4>
	<br>
		<form action="/feeds" method="post">
		<div class="mb-3">
  			<label for="Email" class="form-label">Email</label>
  			<input type="email" class="form-control" name="userEmail" placeholder="abc@example.com" required="required">
		</div>
		<div class="mb-3">
  			<label for="password" class="form-label">Password</label>
  			<input type="password" class="form-control" name="password" placeholder="Enter your password" required="required">
		</div>
		<button type="submit" class="btn btn-primary">Login</button><br><br>
		</form>
		<br>
		${msg}
		<br>
		<a href="/"><button class="btn btn-primary">Back to Home</button></a>
		<br>
	</div>
</body>
</html>