<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Post</title>
<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/4.6.0/css/bootstrap.min.css">
<script type="text/javascript" src="/webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>
</head>
<body>
	<br>
	<div class="container">
		<h3>lets share, what you have in you mind?</h3>
		<form action="/createPost/upload/${currentUser}" method="post" enctype="multipart/form-data">
			<div class="mb-3">
  				<label for="postTopic" class="form-label">Topic</label>
  				<input type="text" class="form-control" name="postTopic" required="required">
			</div>
			<div class="mb-3">
			<label class="preview" for="customFile">Upload a preview image for your document.</label>
			<input type="file" class="form-control" name="preview">
			</div>
			<div class="mb-3">
			<label class="pdf" for="customFile">Upload your PDF</label>
			<input type="file" class="form-control" name="pdf">
			</div>
			<div class="form-check">
			  <input class="form-check-input" type="radio" name="postType" value="PUBLIC" checked>
			  <label class="form-check-label" for="exampleRadios1">
			    Public post
			  </label>
			</div>
			<div class="form-check">
			  <input class="form-check-input" type="radio" name="postType" value="PRIVATE">
			  <label class="form-check-label" for="exampleRadios2">
			    Private post
			  </label>
			</div>
			<br>
			<button type="submit" class="btn btn-primary">Share</button><br><br>
		</form>
	</div>
</body>
</html>