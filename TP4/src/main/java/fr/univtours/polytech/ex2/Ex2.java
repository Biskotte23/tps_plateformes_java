package fr.univtours.polytech.ex2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex2
 */
public class Ex2 extends HttpServlet {
	Map<String, Integer> products = new HashMap<>();
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("panier", products);
		request.getRequestDispatcher("ex2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// On récupère le produit choisi
		String product = request.getParameter("product");
		
		// On verifie que l'utilisateur à bien choisi un produit
		if (product != null) {
			Integer value = 1;
			
			// Si le produit choisi existe dans le panier on augment le nombre produit +1
			if (products.containsKey(product)) {
				value = products.get(product);
				value++;
				products.put(product, value);
				
			// Sinon on l'ajoute au panier
			} else {
				products.put(product, value);
			}
		}
		request.setAttribute("panier", products);
		request.getRequestDispatcher("ex2.jsp").forward(request, response);
	}

}
