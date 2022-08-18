<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
     isELIgnored = "false"
    
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
a:link, a:visited {
  background-color: white;
  color: black;
  border: 5px solid green;
  padding: 20px 30px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-family: Impact, fantasy;
}

a:hover, a:active {
  background-color: green;
  color: white;
}

h1 {
  color: white;
  font-family: OCR A Std, monospace;
  font-size: 150%;
  text-align: center;

}
body {background-color: black;

background-image: url("https://wallpaperscart.com/wp-content/uploads/2022/03/Dark-Green-Wallpapers-Backgrounds-Black-Dark-Color_19.jpg");




}
</style>


</head>
<body>



<h1>ADMIN PAGE </h1>




<p><a href = "/driverView">ADD DRIVER</a>  <a href = "/deldriverView">DELETE DRIVER</a>
<p><a href = "/driversView">DRIVERS</a>




<br>
<br>
<br>

<p><a href = "/firmView">ADD FIRM</a>   <a href = "/delfirmView">DELETE FIRM</a>
<p><a href = "/firmsView">FIRMS</a>


<br>
<br>
<br>


<p><a href = "/busView">ADD BUS</a>     <a href = "/delbusView">DELETE BUS</a>
<p><a href = "/busesView">BUSES</a>

<br>
<br>
<br>



<p><a href = "/tripView">ADD TRIP</a>     <a href = "/deltripView">DELETE TRIP</a>
<p><a href = "/tripsView">TRIPS</a>
<br>






<p><a href = "/logout">Logout</a>


</body>
</html>