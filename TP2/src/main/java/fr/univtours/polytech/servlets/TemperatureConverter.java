package fr.univtours.polytech.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class TemperatureConverter
 */
public class TemperatureConverter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TemperatureConverter() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("FAHRENHEIT", 0);
		request.setAttribute("CELSIUS", "");
		
		request.getRequestDispatcher("temperature-converter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fahrenheit = request.getParameter("temperature");
		String temperature = "";
		
		if (fahrenheit != null && !fahrenheit.isEmpty()) {
			double celsius = (Double.parseDouble(fahrenheit) - 32) / 1.8;
			temperature = (int) celsius + "°C";
		} else {
			fahrenheit = "0";
		}
		
		request.setAttribute("FAHRENHEIT", fahrenheit);
		request.setAttribute("CELSIUS", temperature);
		
		request.getRequestDispatcher("temperature-converter.jsp").forward(request, response);
	}

}
