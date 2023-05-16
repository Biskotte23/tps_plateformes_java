package fr.univtours.polytech.ex4;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex4
 */
public class Ex4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ex4() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("ERROR", "");
		request.setAttribute("SUCCESS", "");

		request.getRequestDispatcher("ex4.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = "";
		String success = "";

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		if (login != null && !login.isEmpty() && password != null && !password.isEmpty()) {
			ServletConfig config = getServletConfig();

			String loginParam = config.getInitParameter("login");
			String passwordParam = config.getInitParameter("mdp");

			if (loginParam.equals(login) && passwordParam.equals(password)) {
				success = "Authentification réussie !";
				error = "";
			} else {
				error = "Identifiant et/ou mot de passe incorrect(s)";
			}
		} else {
			error = "Veuillez renseigner tous les champs";
		}

		request.setAttribute("ERROR", error);
		request.setAttribute("SUCCESS", success);

		request.getRequestDispatcher("ex4.jsp").forward(request, response);
	}

}
