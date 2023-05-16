package fr.univtours.polytech.ex9;

import java.io.IOException;
import java.rmi.server.UID;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * EXERCICE 9
 * Servlet implementation class CookieServelet
 */
@WebServlet("/ex9_page1")
public class Page1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * On redirige vers la page 1
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("page1.jsp").forward(request, response);
	}

	/**
	 * On Creer un cookie pour valider la vu de la page 1 
	 * puis on redirige vers la page 2
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie cookie = new Cookie("page1Vu", new UID().toString());
		response.addCookie(cookie);
		response.sendRedirect("ex9_page2");
	}
}
