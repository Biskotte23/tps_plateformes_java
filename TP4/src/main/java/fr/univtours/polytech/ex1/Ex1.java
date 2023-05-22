package fr.univtours.polytech.ex1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigInteger;

/**
 * Servlet implementation class Ex1
 */
public class Ex1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("nombreChoisi", "...");
		request.setAttribute("reponse", "...");
		request.getRequestDispatcher("ex1.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// On récupère le nombre choisi
		String nombreChoisi = request.getParameter("nombreChoisi");
		
		// On calcule son carre
		BigInteger nombre = new BigInteger(nombreChoisi);
		BigInteger carre = nombre.multiply(nombre);
	
		// On renvoie la reponse
		request.setAttribute("nombreChoisi", nombreChoisi);
		request.setAttribute("reponse", carre.toString());
		request.getRequestDispatcher("ex1.jsp").forward(request, response);
	}

}
