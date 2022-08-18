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
<style >

p{

text-align: center;
}

input[type=text] {
  width: 15%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: 10px solid black;
  border-radius: 4px;
  text-align: center;
}
input[type=submit] {
  width: 15%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: 8px solid black;
  border-radius: 4px;
  text-align: center;
}
input[type=password] {
  width: 15%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: 10px solid black;
  border-radius: 4px;
  text-align: center;
}
body {background-color: black;
background-image: url("https://image.winudf.com/v2/image/Y29tLldhbGRlbWFyVUEuYXBwMDA5OF9zY3JlZW5fOF95OXNvMG41YQ/screen-8.jpg?fakeurl=1&type=.webp");

}





</style>
</head>
<body>
	<c:forEach var="error" items="${errors}">
	<p>
	  <c:out value="${error.key}"/></br>
	  <c:out value="${error.value}"/>
	</p>
	</c:forEach>
	<form action="/registers" method="POST">
	
	<br>
	<br>
	<br>
		<p><input name="name" type="text"  placeholder="Your Name"> </p><br/>
		<p><input name="surname" type="text"  placeholder="Your Surname"></p><br/>
		<p><input name="email" type="text" placeholder="Your E-mail"></p><br/>
		<p><input name="password" type="password" placeholder="Your Password"> </p> <br/>
	<br/>
		<p><input value="Register" type="submit"> </p><br/>
	</form>
</body>
</html>