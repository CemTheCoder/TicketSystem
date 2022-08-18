<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored = "false"
    
    %>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<style >
h1 {
  color: white;
  font-family: verdana;
  font-size: 200%;
  text-align: center;

}

ul li {
  
  color: white;
  margin: 5px;
  font-size: 20px;
}

body {background-color: black;}

a:link, a:visited {
  background-color: white;
  color: black;
  border: 5px solid green;
  padding: 20px 30px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: green;
  color: white;
}

</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



SUCCESSFULLY

<h1>DRIVERS</h1>

<p><a href = "/driverView">ADD DRIVER</a>
<p><a href = "/profile">PROFILE</a>

<ul>

<c:forEach items="${drivers}"  var="driver">

<li>DRIVER ID : ${driver.id}</li>
<li>DRIVER NAME : ${driver.name}</li>
<li>DRIVER SURNAME : ${driver.surname}</li>
<br>
<br>


</c:forEach>

</ul>







</body>
</html>