<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Exercice 1</title>
</head>
<body>
	<table>
		<tr>
			<td>Order</td>
			<td>Designation</td>
		</tr>
		<c:forEach var="i" begin="1" end="20">
			<tr>
				<td>${i}</td>
				<td>Hello</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>