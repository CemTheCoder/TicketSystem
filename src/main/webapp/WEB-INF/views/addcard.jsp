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


<form action="cardadd"  method="POST">



<select name="network" id="network" >
    			<option value="MasterCard">MasterCard</option>
    			<option value="Visa">Visa</option>
    			<option value="American Express">American Express</option>
  		</select>



<p><input type="text"   name ="cardnumber" placeholder="Card Number"></p>



<p><input type="text"   name ="name" placeholder="Card Name"></p>

<p><input type="text"   name ="country" placeholder="Country"></p>

<p><input type="text"   name ="address" placeholder="Address"></p>

<p><input type="text"   name ="exp" placeholder="Exp Date"></p>


<p><input type="text"   name ="cvv" placeholder="cvv"></p>



<p><input type="submit"   value="AddCreditCard"></p>



<p><a href = "/profile">PROFILE</a>


</form>



</body>
</html>