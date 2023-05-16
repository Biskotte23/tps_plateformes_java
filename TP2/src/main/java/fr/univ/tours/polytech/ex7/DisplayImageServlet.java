package fr.univ.tours.polytech.ex7;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class DisplayImageServlet
 */
@WebServlet("/DisplayImageServlet")
@MultipartConfig
public class DisplayImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("uploadImage.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récupération du nom de fichier envoyé dans la requête
		Part filePart = request.getPart("imageFile");
		String fileName = filePart.getSubmittedFileName();
		InputStream fileContent = filePart.getInputStream();

		// sauvegarde du ficher dans le repertoire serveur uploads
		File uploadsDir = new File(getServletContext().getRealPath("/") + "uploads");
		uploadsDir.mkdirs();
		File file = new File(uploadsDir, fileName);
		try (OutputStream out = new FileOutputStream(file)) {
			byte[] buffer = new byte[1024];
			int length;
			while ((length = fileContent.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
		}
		// creation d'une page web avec image afficher
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Image Display</title></head><body>");
		out.println("<img src=\"uploads/" + fileName + "\">");
		out.println("<a href=\"image7.html\">Back to form</a>");
		out.println("</body></html>");
	}
}
