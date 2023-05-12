<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Calculator</title>
  </head>
  <body>
    <form method="post" action="calculator">
    	<label for="operand-1">Opérande 1</label>
    	<input type="number" id="operand-1" name="operand-1" /><br>
    	<label for="operand-2">Opérande 2</label>
    	<input type="number" id="operand-2" name="operand-2" /><br>
    	
    	<input type="radio" name="operator" value="add" checked />
    	<label for="add">+</label><br>
    	<input type="radio" name="operator" value="substract" />
    	<label for="substract">-</label><br>
    	<input type="radio" name="operator" value="multiply" />
    	<label for="multiply">*</label><br>
    	<input type="radio" name="operator" value="divide" />
    	<label for="divide">/</label><br>
    	
    	<input type="submit" value="Calculer" />
    </form>
    <p style="color: red"><%= (String) request.getAttribute("ERROR") %></p>
    <p><%= (String) request.getAttribute("OPERATION") %></p>
  </body>
</html>
