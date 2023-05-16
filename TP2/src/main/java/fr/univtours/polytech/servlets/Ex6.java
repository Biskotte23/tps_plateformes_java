package fr.univtours.polytech.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex6
 */
public class Ex6 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String RESOURCE_NAME = "jdbc/MySqlTP2";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ex6() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("AVERAGE", "0");
		request.setAttribute("GRADES_NUMBER", "0");
		request.setAttribute("ERROR", "");

		request.getRequestDispatcher("ex6.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		double average = 0;
		int gradesNumber = 0;
		String error = "";

		String surname = request.getParameter("surname");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String grade = request.getParameter("grade");

		if (surname != null && !surname.isEmpty() && name != null && !name.isEmpty() && id != null && !id.isEmpty()
				&& grade != null && !grade.isEmpty()) {
			double gradeValue = Double.parseDouble(grade);

			createTableIfNotExists();
			insertStudent(surname, name, id, gradeValue);

			ArrayList<Double> grades = getGrades();
			gradesNumber = grades.size();

			if (gradesNumber > 0) {
				for (double g : grades) {
					average += g;
				}

				average = average / gradesNumber;
			}
		} else {
			error = "Plese fill in all the fields";
		}

		request.setAttribute("AVERAGE", average);
		request.setAttribute("GRADES_NUMBER", gradesNumber);
		request.setAttribute("ERROR", error);

		request.getRequestDispatcher("ex6.jsp").forward(request, response);
	}

	private Connection createConnection() throws SQLException, NamingException {
		InitialContext ic = new InitialContext();
		Context ctx = (Context) ic.lookup("java:comp/env");
		DataSource ds = (DataSource) ctx.lookup(RESOURCE_NAME);

		return ds.getConnection();
	}

	private void createTableIfNotExists() {
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = createConnection();
			stmt = conn.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS Student (id INT(11) PRIMARY KEY AUTO_INCREMENT, surname VARCHAR(50), name VARCHAR(50), number VARCHAR(10), grade FLOAT(4, 2))";
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void insertStudent(String surname, String name, String id, double grade) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = createConnection();

			String sql = "INSERT INTO Student(surname, name, number, grade) VALUES (?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, surname);
			stmt.setString(2, name);
			stmt.setString(3, id);
			stmt.setDouble(4, grade);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private ArrayList<Double> getGrades() {
		ArrayList<Double> grades = new ArrayList<Double>();
		Connection conn = null;

		try {
			conn = createConnection();

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT grade AS average FROM Student");

			while (rs.next()) {
				grades.add(Double.parseDouble(rs.getString("average")));
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return grades;
	}
}
