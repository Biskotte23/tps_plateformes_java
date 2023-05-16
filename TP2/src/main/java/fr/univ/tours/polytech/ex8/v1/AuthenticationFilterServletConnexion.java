package fr.univ.tours.polytech.ex8.v1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AuthenticationFilterServletConnexion
 */
@WebServlet("/AuthenticationFilterServletConnexion")
public class AuthenticationFilterServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String identifiant = "admin";
	private static final String mdp = "password";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");
		request.setAttribute("page", page);
		request.getRequestDispatcher("authentificationfilterpageconnexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// On recupere les donnes du formulaire de connexion
		String identifiantForm = request.getParameter("identifiant");
		String mdpForm = request.getParameter("mdp");

		String page = request.getParameter("page");

		// On les compare aux donnes de connexion defini
		if (identifiant.equals(identifiantForm) && mdp.equals(mdpForm)) {
			if (page != null && !page.isEmpty()) {
				if (page.equals("page1")) {
					response.sendRedirect("AuthenticationFilterServletV1Page1?connexion=reussi");
				} else if (page.equals("page2")) {
					response.sendRedirect("AuthenticationFilterServletV1Page2?connexion=reussi");
				}
			} else {
				response.sendRedirect("AuthenticationFilterServletV1Page1?connexion=reussi");
			}
		} else {
			request.setAttribute("page", page);
			request.getRequestDispatcher("authentificationfilterpageconnexion.jsp").forward(request, response);
		}
	}
}
