<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp-DSS</title>
</head>
<body>
<nav>
    <h3 style="display: inline-block;">DSS</h3>
    <a href="login"><button style="display: inline-block;">Log in</button></a>
</nav>
<div style="margin-left: auto;">
    <div>
        <h3>Data Sharing Station</h3>
    </div>
    <h5>Sign Up</h5>
    <br>
    <div>
        <form action="/register" method="post">
            <label for="firstname">First name:</label><br>
            <input type="text" id="firstname" name="firstname" required><br>
            <label for="lastname">Last name:</label><br>
            <input type="text" id="lastname" name="lastname" required><br><br>
            <label for="email">Email:</label><br>
            <input type="email" id="email" name="email" required><br>
            <label for="contact">Contact:</label><br>
            <input type="text" id="contact" name="contact" required><br><br>
            <label for="password">Password:</label><br>
            <input type="password" id="password" name="password" required><br><br>
            <input type="submit" value="Submit">
        </form>
    </div>
</div>
</body>
</html>