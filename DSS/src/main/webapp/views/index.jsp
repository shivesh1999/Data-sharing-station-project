<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home</title>
<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/4.6.0/css/bootstrap.min.css">
<script type="text/javascript" src="/webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<br>
  		<h1 >DSS Application</h1>
  		<br>
  		<form action="topic">
  		<input type="text" name="topic">
  		<button class="btn btn-primary">Search</button>
  		</form>
  		<br>
  		<a href="/registerUser"><button class="btn btn-primary">Register</button></a>
  		<a href="/loginPage"><button class="btn btn-primary">Login</button></a>
	</div>
	<hr>
	<br>
	<c:forEach items="${posts}" var="post">
	<div class="container">
	  <div class="card" style="width: 25rem;">
	   <div class="card-body">
	    <h5 class="card-title">${post.postTopic}</h5>
		<h6 class="card-text">by : ${post.userName}</h6>
	    <p class="card-text">Check the preview and login to Download your PDF</p>
	    <a href="/downloadPreview/${post.postId}" class="btn btn-primary">Check preview</a>
	   </div>
	  </div>
	</div>
	</c:forEach>
</body>
</html>