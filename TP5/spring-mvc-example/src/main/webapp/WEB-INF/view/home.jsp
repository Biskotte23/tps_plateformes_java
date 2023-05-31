<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
</head>
<body>
<h1>Hello World!</h1>
<p>The time on the server is ${serverTime}</p>
<form action="user" method="post">
	<input type="text" name="userName"><br>
	<input type="submit" value="Login">
</form>
</body>
</html>