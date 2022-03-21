<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    container-fluid{
        padding: auto;  
    }
    #perks{
        padding: auto;
        margin: auto;
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
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/home">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">About us</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">For Institutions</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="signup">Create a Account</a>
              </li>
            </ul>
        </div>
    </div>
</nav>
<br>
<div class="container-fluid">
    <div class="row">
      <div class="col">
        <form action="/feeds" method="post">
            <h3>Data Sharing Station</h3>
            <div class="mb-3">
                <label for="email" class="form-label">Email address</label>
                <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" required>
            </div>
            <div class="mb-3">
              <label for="password" class="form-label">Password</label>
              <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <div class="mb-3 form-check">
              <input type="checkbox" class="form-check-input" id="rememberme" name="rememberme">
              <label class="form-check-label" for="rememberme">Remember me</label>
            </div>
            <div class="mb-3">
                <h6>${msg}</h6>
            </div>
            <button type="submit" class="btn btn-light">Submit</button>
          </form>
          <br>
          <div class="mb-3">
              <h6>Need an Account ? <a href="signup" style="color: white;">Signup</a></h6>
          </div>
      </div>
      <div class="col">
        <div class="container-fluid" id="perks">
            <h4>Why to have a Account ?</h4>
            <ul class="mb-3">
                <li class="mb-3">The largest and best collection of online resources guaranteed.</li>
                <li class="mb-3">Personalized Experience of resources</li>
                <li class="mb-3">Access to private post from your favourite resource provider.</li>
            </ul>
        </div>
      </div>
    </div>
</div>
</body>
</html>