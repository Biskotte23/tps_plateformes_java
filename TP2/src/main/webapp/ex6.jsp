<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Ex 6</title>
  </head>
  <body>
    <form method="post" action="ex6">
    	<label for="surname">Surname</label>
    	<input type="text" id="surname" name="surname" /><br>
    	<label for="name">Name</label>
    	<input type="text" id="name" name="name" /><br>
    	<label for="id">Student No.</label>
    	<input type="text" id="id" name="id" min=0 max=20 /><br>
    	<label for="grade">Grade</label>
    	<input type="number" id="grade" name="grade" /><br>
    	<input type="submit" value="Ajouter" />
    </form>
    <p style="color: red"><%= (String) request.getAttribute("ERROR") %></p>
    <p style="font-weight: bold">AVERAGE (<%= request.getAttribute("GRADES_NUMBER") %> grades): <%= request.getAttribute("AVERAGE") %> / 20</p>
  </body>
</html>
