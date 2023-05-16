package fr.univ.tours.polytech.ex8.v1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * EXERCICE 8 Servlet implementation class AuthenticationFilterServletV1Page2
 */
@WebServlet("/AuthenticationFilterServletV1Page2")
public class AuthenticationFilterServletV1Page2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String connexion = request.getParameter("connexion");
		if("reussi".equals(connexion)) {
			request.getRequestDispatcher("authenticationfilterpage2.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("AuthenticationFilterServletConnexion?page=page2");
		}
	}
}
