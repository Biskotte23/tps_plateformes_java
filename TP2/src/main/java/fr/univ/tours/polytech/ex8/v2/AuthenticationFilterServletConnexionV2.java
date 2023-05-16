package fr.univ.tours.polytech.ex8.v2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AuthenticationFilterServletConnexionV2
 */
@WebServlet("/AuthenticationFilterServletConnexionV2")
public class AuthenticationFilterServletConnexionV2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String identifiant = "admin";
	private static final String mdp = "password";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");
		request.setAttribute("page", page);
		request.getRequestDispatcher("authentificationfilterpageconnexionv2.jsp").forward(request, response);
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
			
			HttpSession session = request.getSession();
			session.setAttribute("maSession", "maSession");
			
			if (page != null && !page.isEmpty()) {
				if (page.equals("page1")) {
					response.sendRedirect("AuthenticationFilterServletV2Page1");
				} else if (page.equals("page2")) {
					response.sendRedirect("AuthenticationFilterServletV2Page2");
				}
			} else {
				response.sendRedirect("AuthenticationFilterServletV2Page1");
			}
		} else {
			request.setAttribute("page", page);
			request.getRequestDispatcher("authentificationfilterpageconnexionv2.jsp").forward(request, response);
		}
	}

}
