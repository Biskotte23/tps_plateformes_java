<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page de Connexion</title>
</head>
<body>
<form method="post" action="AuthenticationFilterServletConnexionV2">
<input placeholder="identifiant" name=identifiant>
<input placeholder="mot de passe" name=mdp>
<input type="submit" value="Connexion">
<input type="hidden" name="page" value="${requestScope.page}">
</form>
</body>
</html>