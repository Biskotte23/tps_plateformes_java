package fr.univtours.polytech.ex5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Calculator
 */
@WebServlet("/ex5")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Calculator() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("ERROR", "");
		request.setAttribute("OPERATION", "");

		request.getRequestDispatcher("calculator.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = "";
		String operation = "";

		String operand1 = request.getParameter("operand-1");
		String operand2 = request.getParameter("operand-2");
		String operator = request.getParameter("operator");

		if (operand1 != null && !operand1.isEmpty() && operand2 != null && !operand2.isEmpty() && operator != null
				&& !operator.isEmpty()) {
			double op1 = Double.parseDouble(operand1);
			double op2 = Double.parseDouble(operand2);
			double result = 0;
			
			switch(operator) {
				case "add":
					result = op1 + op2;
					operation = op1 + " + " + op2 + " = " + result; 
					break;
				case "substract":
					result = op1 - op2;
					operation = op1 + " - " + op2 + " = " + result; 
					break;
				case "multiply":
					result = op1 * op2;
					operation = op1 + " * " + op2 + " = " + result; 
					break;
				case "divide":
					if ((int) op2 != 0) {
						result = op1 / op2;
						operation = op1 + " / " + op2 + " = " + result; 
					} else {
						error = "Erreur: Division par 0 !";
					}
					break;
			}
		} else {
			error = "Veuillez renseigner tous les champs";
		}

		request.setAttribute("ERROR", error);
		request.setAttribute("OPERATION", operation);

		request.getRequestDispatcher("calculator.jsp").forward(request, response);
	}

}
