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
select {

width: 15%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: 10px solid white;
  border-radius: 4px;
  text-align: center;
  font-family: Impact, fantasy;
font-size: 150%;
}

option:hover option:active{
 background-color: green;
  color: white;

  font-family: Impact, fantasy;
font-size: 150%;
}
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



<form action="/ticketadd" method="POST">


<h1>Trips</h1>

<ul>

<c:forEach items="${trips}"  var="trip">

<li>TRIP ID : ${trip.id}</li>
<li> TRIP NAME : ${trip.trip_name}</li>
<li>TRIP DESTINATION :  ${trip.destination}</li>
<li>TRIP STARTING DATE : ${trip.starting_date}</li>
<li>TRIP STARTING SPOT : ${trip.starting_spot}</li>
<li> TRIP'S BUS ID : ${trip.busid}</li>
<li> TRIP'S PRICE : ${trip.price}</li>




<p></p>
<p></p>

</c:forEach>

</ul>

  <p><select name="payment" id="payment">
		<c:forEach items="${cards}" var="card">


			<option value="${card.id}">${card.cardnumber} , ${card.network}</option>

		</c:forEach>
		
					<option value="balance">BALANCE</option>
		
		
	</select>  </p>

<p><input type="text"   name ="tripid"placeholder="Trip Id">                                          </p>



<p><input type="text"   name ="purchase_time" placeholder="Purchase Time">                                          </p>


<p>    <input type="submit"   value="BUY">                                          </p>

<p><a href = "/profile">PROFILE</a>

</form>






</body>
</html>