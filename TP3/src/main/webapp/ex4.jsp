<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exercice 4</title>
</head>
<body>
	<form action="ex4" method="post">
		<input type="number" name="nombreChoisi"> <input type="submit"
			value="valider">
	</form>
	<h1>${requestScope.reponse}</h1>
</body>
</html>