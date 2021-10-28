<%@page import="java.sql.Blob"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome User</title>
	<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/4.6.0/css/bootstrap.min.css">
	<script type="text/javascript" src="/webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>
</head>
<body>
<br>
<div class="container">
	<h4>Feeds</h4>
	<a href="/createPost/${currentUser.userId}"><button type="button" class="btn btn-secondary">Create a Post</button></a>
	<a href="/profile/${currentUser.userId}"><button class="btn btn-secondary">My Profile</button></a>
	<a href="/loginPage"><button class="btn btn-warning">Logout</button></a>
</div>
<br>
<c:forEach items="${posts}" var="post">
<div class="container">
  <div class="card" style="width: 25rem;">
   <div class="card-body">
    <h5 class="card-title">${post.postTopic}</h5>
	<h6 class="card-text">by : ${post.userName}</h6>
    <p class="card-text">Check the preview and Download your PDF</p>
    <a href="/downloadPreview/${post.postId}" class="btn btn-primary">Check preview</a>
    <a href="/download/${post.postId}" class="btn btn-primary">Download</a>
   </div>
  </div>
</div>
</c:forEach>
</body>
</html>