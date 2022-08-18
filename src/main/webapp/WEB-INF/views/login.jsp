<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<style>

a:link, a:visited {
  background-color: white;
  color: black;
  border: 8px solid black;
  padding: 20px 30px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-family: Impact, fantasy;
}

a:hover, a:active {
  background-color: white;
  color: white;
}



</style>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div class="row">
		<div class="col-md-4">
			<form class="form-group" action="login" method="POST">
				<label for="name">Email </label>
				<p><input id ="name" class="form-control" name="email" type="text"> </p>
				<label for="name">Password</label>
			<p>	<input id = "password" class="form-control" name="password" type="password"> </p>
				<br>
				<input class="form-control btn btn-primary"type="submit" value="LOGIN">
			</form>
		</div>

	</div>
	
	<p><a href = "/registerView">REGISTER</a></p>
	
</body>
</html>