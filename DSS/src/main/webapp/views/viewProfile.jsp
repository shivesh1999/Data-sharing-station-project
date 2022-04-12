<%@page import="java.sql.Blob"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DSS</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<style>
    body {
      background-color: navy;
      color: white;
    }
    a{
      color: white;
      text-decoration: none;
    }
    container-fluid{
        padding: auto; 
    }
    #Posts{
        border-radius: 12px;
        box-shadow: 0 1px 8px rgba(0, 0, 0, 0.25);
        background-color:#dbdbdb;
        color:black;
    }
</style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">DSS</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0"> 
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/feeds/${user.email}">Feeds</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">For Institutions</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">About us</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/home">Logout</a>
              </li>

            </ul>
        </div>
    </div>
</nav>
<br>
<div class="container-fluid">
    <div class="row">
      <div class="col-3">
        <h6>${user.firstname} ${user.lastname}</h6>
        <br>
        <h6>Email - ${user.email}</h6>
        <h6>Contact - ${user.contact}</h6>
        <h6>Resources published - X</h6>
        <h6>Subsribers - X</h6>
        <h6>Subscriptions - X</h6>
        
      </div>
      <div class="col-6">
        <div class="mb-3">
                <h6 style="color:yellow;">${msg}</h6>
        </div>
        <c:forEach items="${posts}" var="post">
        <div class="container-fluid" id="Posts">
            <br>
            <h6>${post.postedBy} shared about</h6>
            <h6>${post.description}</h6>
            <h6>Download resource and know more about it.</h6>
            <span style="display: inline;">
            <a href="/download/${post.id}"><button class="btn btn-warning">Download</button></a>
            </span>
            <br><br>
        </div>
        <br>
        </c:forEach>
       </div>
        <div class="col-3">
        </div>
    </div>
  </div>
</body>
</html>