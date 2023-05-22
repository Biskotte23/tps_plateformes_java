package fr.univtours.polytech.ex4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex4
 */
@WebServlet("/ex4")
public class Ex4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("reponse", "");
		request.getRequestDispatcher("ex4.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Création de la liste
		List<Integer> listeNombre = new ArrayList<>();

		// Ajout des nombres de 1 à 10 à la liste
		for (int i = 1; i <= 10; i++) {
			listeNombre.add(i);
		}

		// Tirage d'un nombre aléatoire
		Random random = new Random();
		int index = random.nextInt(listeNombre.size());
		int nombreAleatoire = listeNombre.get(index);

		int nombreChoisi = Integer.parseInt(request.getParameter("nombreChoisi"));

		String reponse = "";
		if (nombreAleatoire == nombreChoisi) {
			reponse = "Victoire :) ";
		} else if (nombreChoisi > 10 || nombreChoisi < 0) {
			reponse = "Nombre choisi incorrect ! ";
		} else {
			reponse = "Perdu :( ";
		}

		request.setAttribute("reponse", reponse);
		request.getRequestDispatcher("ex4.jsp").forward(request, response);
	}

}
