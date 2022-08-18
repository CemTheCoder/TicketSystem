<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    isELIgnored = "false"
    
    %>
    
    
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>

p{

text-align: center;
}

input[type=text] {
  width: 15%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: 10px solid crimson;
  border-radius: 4px;
  text-align: center;
}
input[type=submit] {
  width: 15%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: 8px solid green;
  border-radius: 4px;
  text-align: center;
}
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
input[type=password] {
  width: 15%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: 10px solid crimson;
  border-radius: 4px;
  text-align: center;
}
body {background-color: black;}

a:link, a:visited {
  background-color: white;
  color: black;
  border: 5px solid gold;
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
</head>
<body>



<h1>Credit Cards</h1>

<ul>

<c:forEach items="${cards}"  var="card">
<li>CardId :  ${card.id}</li>
<li>Network :  ${card.network}</li>
<li>CARD NUMBER : ${card.cardnumber}</li>
<li>NAME : ${card.name}</li>


<br>
<br>

</c:forEach>

</ul>
<p><a href = "/cardView">ADD Card</a>
<p><a href = "/profile">PROFILE</a>




</body>
</html>