package fr.univ.tours.polytech.ex8.v2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AuthenticationFilterServletV2Connexion
 */
@WebServlet("/AuthenticationFilterServletV2Page2")
public class AuthenticationFilterServletV2Page2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("maSession") != null) {
			request.getRequestDispatcher("authenticationfilterpage2.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("AuthenticationFilterServletConnexionV2?page=page2");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("authenticationfilterpage1.jsp").forward(request, response);
	}

}
