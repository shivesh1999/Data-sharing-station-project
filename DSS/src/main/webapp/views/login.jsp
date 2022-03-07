<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DSS-login</title>
</head>
<body>   
<nav>
    <h3 style="display: inline-block;">DSS</h3>
</nav>
<div style="margin-left: auto;">
    <div>
        <h3>Data Sharing Station</h3>
    </div>
    <h5>Login</h5>
    <br>
    <div>
        <form action="/feeds" method="post">
            <label for="email">Email:</label><br>
            <input type="email" id="email" name="email" required><br>
            <label for="password">Password:</label><br>
            <input type="password" id="password" name="password" required><br><br>
            <p th:text="${msg}" style="color: red; font-size: small;"></p>
            <input type="submit" value="Submit">
        </form>
    </div>
</div>
<hr>
</body>
</html>