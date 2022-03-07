<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/4.6.0/css/bootstrap.min.css">
<script type="text/javascript" src="/webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>
<title>Profile</title>
</head>
<body>
	<div class="container">
	<br>
	<h4>Hi ${currentUser.userName}</h4>
	<br>
	<h6>Manage your Account</h6>
	<br>
	<a href="/delete/${currentUser.userId}"><button class="btn btn-danger">Delete Account</button></a>
	</div>
</body>
</html>