<%@page import="java.sql.Blob"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DSS-Feeds</title>
</head>
<body>
    <nav>
        <h3 style="display: inline-block;">DSS</h3>
    </nav>
    <div style="margin-left: auto;">
        <div>
            <h4>Data Sharing Station</h4>
        </div>
        <h3>Feeds</h3>
        <form action="/createPost/${user.email}" method="post" enctype="multipart/form-data">
            <div>
                <p >What on your mind ${user.firstname} ? Share it here ! </p><br>
                <label for="Description">Description: </label><br><br>
                <input type="Description" id="Description" name="Description" required><br><br>
                <label for="File">Upload your PDF: </label><br><br>
			    <input type="file" class="form-control" name="File"><br><br>
                <button type="submit">Post</button><br><br>
            </div>
        </form>
    </div>
    <div>
    <br>
    <c:forEach items="${posts}" var="post">
        <div>
            <h5>Description : ${post.description}</h5>
            <h6>by : ${post.postedBy}</h6>
            <a href="/download/${post.id}">Download</a>
        </div>
    </c:forEach>
    </div>
</body>
</html>