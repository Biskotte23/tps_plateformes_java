<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Ex2</title>
</head>
<body>
	<form action="Ex2" method="post">
		<input type="radio" name="product" value="pen" /> <label>Pen</label>
		<input type="radio" name="product" value="marker" /> <label>Marker</label>
		<input type="radio" name="product" value="eraser" /> <label>Eraser</label>
		<input type="submit" value="Submit" />
	</form>

	<h1>Le panier est composé de :</h1>
	<c:forEach var="entry" items="${requestScope.panier}">
  		 <h2>- ${entry.key}: (${entry.value})</h2>
	</c:forEach>
</body>
</html>