<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Authentication</title>
  </head>
  <body>
    <form method="post" action="ex3">
    	<label for="login">Login</label>
    	<input type="text" id="login" name="login" value="${requestScope.login}" /><br>
    	<label for="password">Password</label>
    	<input type="password" id="password" name="password" /><br>
    	<input type="submit" value="Authenticate" />
    </form>
    <p style="color: red">${requestScope.error}</p>
    <p style="color: green">${requestScope.success}</p>
  </body>
</html>