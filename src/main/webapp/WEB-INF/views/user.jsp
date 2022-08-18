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
p{

text-align: center;
}
a:link, a:visited {
  background-color: white;
  color: black;
  border: 12px solid crimson;
  padding: 20px 30px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
    font-family: Stencil Std, fantasy;
}

a:hover, a:active {
  background-color: white;
  color: crimson;
    font-family: Stencil Std, fantasy;
    
    
    
}

h1 {
  color: black;
  font-family: OCR A Std, monospace;
  font-size: 300%;
  text-align: center;

}
body {background-color: white;

background-image: url("https://wallpapercave.com/wp/JCngDPA.jpg");


}

h2{
 background-color: white;
  color: black;
  border: 6px solid black;
  padding: 20px 30px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
    font-family: OCR A Std, monospace;

}
</style>

</head>
<body>





<h1>WELCOME ${user.name} </h1>

<h2>BALANCE = ${user.balance}</h2>


<br>
<br>

<a href = "/cardView">ADD CREDIT CARD</a>   <a href = "/delcardView">DELETE CREDIT CARD</a>  <a href = "/cardsView">MY CREDIT CARDS</a>



<br>
<br>
<a href = "/moneyView">ADD MONEY</a>





<p><a href = "/ticketsView">MY TICKETS</a>  <a href = "/ticketView">BUY TICKET</a>    <a href = "/delticketView">DELETE TICKET</a> </p>

<br>
<br>
<br>


<p><a href = "/logout">Logout</a>


</body>
</html>