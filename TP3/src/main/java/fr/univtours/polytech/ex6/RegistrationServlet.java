package fr.univtours.polytech.ex6;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/ex6")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String firstName = (String) session.getAttribute("firstName");
		String lastName = (String) session.getAttribute("lastName");

		request.setAttribute("firstName", firstName);
		request.setAttribute("lastName", lastName);

		request.getRequestDispatcher("viewRegistration.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String firstName = request.getParameter("first-name");
		String lastName = request.getParameter("last-name");
		String password = request.getParameter("password");
		String hiddenPassword = "";

		String firstNameError = null;
		String lastNameError = null;
		String passwordError = null;

		if (firstName == null || firstName.isEmpty()) {
			firstNameError = "Please enter your name.";
		}

		if (lastName == null || lastName.isEmpty()) {
			lastNameError = "Please enter your last name.";
		}

		if (password == null || password.isEmpty()) {
			passwordError = "Please enter a password.";
		}

		for (int i = 0; i < password.length(); i++) {
			if (i == 0) {
				hiddenPassword += password.charAt(i);
			} else {
				hiddenPassword += "*";
			}
		}

		session.setAttribute("firstName", firstName);
		session.setAttribute("lastName", lastName);

		request.setAttribute("firstName", firstName);
		request.setAttribute("lastName", lastName);
		request.setAttribute("password", hiddenPassword);

		if (firstNameError == null && lastNameError == null && passwordError == null) {
			request.getRequestDispatcher("confirmRegistration.jsp").forward(request, response);
		} else {
			request.setAttribute("firstNameError", firstNameError);
			request.setAttribute("lastNameError", lastNameError);
			request.setAttribute("passwordError", passwordError);

			request.getRequestDispatcher("checkRegistration.jsp").forward(request, response);
		}
	}

}
