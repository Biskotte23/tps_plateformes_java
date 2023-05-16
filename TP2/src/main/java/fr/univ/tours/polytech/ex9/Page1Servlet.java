package fr.univ.tours.polytech.ex9;

import java.io.IOException;
import java.rmi.server.UID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * EXERCICE 9
 * Servlet implementation class CookieServelet
 */
@WebServlet("/Page1Servlet")
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
		request.getRequestDispatcher("page2.jsp").forward(request, response);
	}
}
