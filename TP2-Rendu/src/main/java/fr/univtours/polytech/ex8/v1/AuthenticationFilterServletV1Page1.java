package fr.univtours.polytech.ex8.v1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * EXERCICIE 8 V1 Servlet implementation class AuthenticationFilterServletV1
 */
@WebServlet("/ex8.1_page1")
public class AuthenticationFilterServletV1Page1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String connexion = request.getParameter("connexion");
		if("reussi".equals(connexion)) {
			request.getRequestDispatcher("authenticationfilterpage1.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("ex8.1_page1?page=page1");
		}
	}
}
