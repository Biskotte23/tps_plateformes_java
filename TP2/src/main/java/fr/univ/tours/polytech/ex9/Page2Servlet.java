package fr.univ.tours.polytech.ex9;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * EXERCICE 9
 * Servlet implementation class Page2Servlet
 */
@WebServlet("/Page2Servlet")
public class Page2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * Affiche la page 1 ou 2 en fonction de si le cookie exist
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean dejaVu = false;

		// On recupere la liste des cookies
		Cookie[] listeCookie = request.getCookies();
		if (null != listeCookie) {
			for (Cookie cookie : listeCookie) {
				// si l'utilisateur à déjà vu la page 1 on change valeur du boolean
				if (cookie.getName().equals("page1Vu")) {
					dejaVu = true;
				}
			}
		}

		// Si l'utilisateur à vu la page 1 on redirige vers page 2
		if (dejaVu) {
			request.getRequestDispatcher("page2.jsp").forward(request, response);
		} 
		// Sinon on redirige vers la page 1
		else {
			request.getRequestDispatcher("page1.jsp").forward(request, response);
		}
	}
}
