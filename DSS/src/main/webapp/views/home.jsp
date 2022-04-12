<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Data Sharing Station</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<style>
    body {
      background-color: navy;
      color: white;
    }
    container-fluid{
        padding: auto;  
    }
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light text-right">
        <div class="container-fluid">
          <a class="navbar-brand" href="home">DSS</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
            </li>
              <li class="nav-item">
                <a class="nav-link active"  aria-current="page" href="signup">Create a Account</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">For Institutions</a>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">About us</a>
              </li>
            </ul>
        </div>
    </div>
</nav>
<br>
<div class="container-fluid">
    <h3>Welcome to Data Sharing Station !</h3>
    <p>
        A multipurpose storage platform.
    </p>
    <br>
    <h4>Why DSS ?</h4>
            <ul class="mb-3">
                <li class="mb-3">The largest and best collection of online resources guaranteed.</li>
                <li class="mb-3">Personalized Experience of resources</li>
                <li class="mb-3">Access to private post from your favourite resource provider.</li>
            </ul>
    <br>
    <a href="login"><button class="btn btn-outline-light" style="display: inline-block;">Log in</button></a>
    <a href="signup"><button class="btn btn-outline-light" style="display: inline-block;">Sign Up</button></a>
</div>

</body>
</html>