<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Supplies form</title>
  </head>
  <body>
    <form method="post" action="ex4">
    	<label for="login">Login</label>
    	<input type="text" id="login" name="login" />
    	<label for="password">Mot de passe</label>
    	<input type="password" id="password" name="password" />
    	<input type="submit" value="Connexion" />
    </form>
    <p style="color: red"><%= (String) request.getAttribute("ERROR") %></p>
    <p style="color: green"><%= (String) request.getAttribute("SUCCESS") %></p>
  </body>
</html>
