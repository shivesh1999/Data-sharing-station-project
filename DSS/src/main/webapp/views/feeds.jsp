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
        <h6>Welcome back ${user.firstname} !</h6>
        <a href="/profile/${user.email}"><h6>My profile</h6></a>
        <br>
        <h6>My Subscription</h6>
      </div>
      <div class="col-6">
        <div class="mb-3" id="createGrid">
            <form action="/createPost/${user.email}" method="post" enctype="multipart/form-data">
                <div class="mb-3">
                    <label for="Description" class="form-label">Description</label>
                    <textarea class="form-control" id="Description" rows="3" placeholder="What on your mind ? Share it here ! " name="Description" required></textarea>
                </div>
                <div class="mb-3">
                    <label for="File" class="form-label">Add your file</label>
                    <input class="form-control" type="file" id="File" name="File" required>
                </div>
                <button type="submit" class="btn btn-light">Publish</button>
            </form>
        </div>
        <div class="mb-3">
                <h6 style="color:yellow;">${msg}</h6>
        </div>
        <c:forEach items="${posts}" var="post">
        <div class="container-fluid" id="Posts">
            <br>
            <h6>${post.postedBy} shared about </h6>
            <h6>${post.description}</h6>
            <h6>Download resource and know more about it.</h6>
            <a href="/download/${post.id}"><button class="btn btn-warning">Download</button></a><br><br>
        </div>
        <br>
        </c:forEach>
       </div>
        <div class="col-3">
            Recommended resources
            <br>
            <c:forEach items="${unsubscribedResources}" var="resources">
            <div>
            <a href="/profile-view/${resources.email}">${resources.firstname} ${resources.lastname}</a>
            </div>
            </c:forEach>
        </div>
    </div>
  </div>
</body>
</html>
