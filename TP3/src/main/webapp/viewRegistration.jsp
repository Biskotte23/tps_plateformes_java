<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Registration</title>
  </head>
  <body>
    <form method="post" action="ex6">
    	<label for="first-name">Name</label>
    	<input type="text" id="first-name" name="first-name" value="${requestScope.firstName}" /><br>
    	<label for="last-name">Last name</label>
    	<input type="text" id="last-name" name="last-name" value="${requestScope.lastName}" /><br>
    	<label for="password">Password</label>
    	<input type="password" id="password" name="password" /><br>
    	<input type="submit" value="Submit" />
    </form>
  </body>
</html>