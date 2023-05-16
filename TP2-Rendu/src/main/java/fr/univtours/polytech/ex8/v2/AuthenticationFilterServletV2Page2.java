package fr.univtours.polytech.ex8.v2;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class AuthenticationFilterServletV2Connexion
 */
@WebServlet("/ex8.2_page2")
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
			response.sendRedirect("ex8.2?page=page2");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("authenticationfilterpage1.jsp").forward(request, response);
	}

}
