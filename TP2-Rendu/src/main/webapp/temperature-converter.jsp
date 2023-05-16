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
    <form method="post" action="ex3">
    	<label for="temperature">Température (Farenheit)</label>
    	<input type="number" id="temperature" name="temperature" value=<%= request.getAttribute("FAHRENHEIT") %> />
    	<input type="submit" value="Convertir en Celsius" />
    	<p><%= (String) request.getAttribute("CELSIUS") %></p>
    </form>
  </body>
</html>
