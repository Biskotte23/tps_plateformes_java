<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="fr.univtours.polytech.ex5.ArithmeticBean"%>
<jsp:useBean id="arithmeticBean"
	class="fr.univtours.polytech.ex5.ArithmeticBean" scope="request" />

<jsp:setProperty name="arithmeticBean" property="operand1"
	value="${param.operand1}" />
<jsp:setProperty name="arithmeticBean" property="operand2"
	value="${param.operand2}" />

<c:choose>
	<c:when test="${param.operation eq 'addition'}">
		<%
		arithmeticBean.performAddition();
		double result = (double) arithmeticBean.getResult();
		%>
		<p>
			Résultat de l'addition :
			<%=result%></p>
	</c:when>
	<c:when test="${param.operation eq 'subtraction'}">
		<%
		arithmeticBean.performSubtraction();
		double result = (double) arithmeticBean.getResult();
		%>
		<p>
			Résultat de la soustration :
			<%=result%></p>
	</c:when>
	<c:when test="${param.operation eq 'multiplication'}">
		<%
		arithmeticBean.performMultiplication();
		double result = (double) arithmeticBean.getResult();
		%>
		<p>
			Résultat de la multiplication :
			<%=result%></p>
	</c:when>
	<c:when test="${param.operation eq 'division'}">
		<%
		arithmeticBean.performDivision();
		double result = (double) arithmeticBean.getResult();
		%>
		<p>
			Résultat de la division :
			<%=result%></p>
	</c:when>
</c:choose>