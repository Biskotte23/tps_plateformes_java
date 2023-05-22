<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Registration</title>
  </head>
  <body>
  	<h1>Error: You have not registered</h1>
  	<br>
   	<p>Name : ${requestScope.firstName} <span style="color: red">${requestScope.firstNameError}</span></p>
   	<p>Last name : ${requestScope.lastName} <span style="color: red">${requestScope.lastNameError}</span></p>
   	<p>Password : ${requestScope.password} <span style="color: red">${requestScope.passwordError}</span></p>
   	<br>
   	<p>Return to <a href="ex6">registration form</a></p>
  </body>
</html>