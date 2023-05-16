package fr.univ.tours.polytech.ex8.v1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * EXERCICIE 8 V1 Servlet implementation class AuthenticationFilterServletV1
 */
@WebServlet("/AuthenticationFilterServletV1Page1")
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
			response.sendRedirect("AuthenticationFilterServletConnexion?page=page1");
		}
	}
}
