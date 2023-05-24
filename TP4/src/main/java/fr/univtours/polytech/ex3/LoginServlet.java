package fr.univtours.polytech.ex3;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/ex3")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginBusiness loginBusiness;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		this.loginBusiness = new LoginBusinessImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String login = (String) session.getAttribute("login");

		request.setAttribute("login", login);

		request.getRequestDispatcher("ex3.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String error = null;
		String success = null;

		if ((login == null || login.isEmpty()) || (password == null || password.isEmpty())) {
			error = "Please enter your login and password.";
		} else {
			CredentialsBean credentials = loginBusiness.getCredentials(login);

			if (loginBusiness.checkCredentials(credentials, login, password)) {
				success = "You are well connected !";
			} else {
				error = "Wrong login or/and password.";
			}
		}

		session.setAttribute("login", login);
		request.setAttribute("login", login);
		request.setAttribute("error", error);
		request.setAttribute("success", success);

		request.getRequestDispatcher("ex3.jsp").forward(request, response);
	}

}
