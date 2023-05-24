package fr.univtours.polytech.ex3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class LoginBusinessImpl implements LoginBusiness {
	private static final String RESOURCE_NAME = "jdbc/MySqlTP4";

	@Override
	public boolean checkCredentials(CredentialsBean credentials, String login, String password) {
		return login != null && password != null && login.equals(credentials.getLogin())
				&& password.equals(credentials.getPassword());
	}

	@Override
	public CredentialsBean getCredentials(String login) {
		CredentialsBean credentials = new CredentialsBean();
		createTableIfNotExists();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = createConnection();

			String sql = "SELECT login, password FROM Credentials WHERE login = ?";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, login);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				credentials.setLogin(rs.getString("login"));
				credentials.setPassword(rs.getString("password"));
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

		return credentials;
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

			String sql = "CREATE TABLE IF NOT EXISTS Credentials (id INT(11) PRIMARY KEY AUTO_INCREMENT, login VARCHAR(50), password VARCHAR(50))";
			stmt.executeUpdate(sql);

			sql = "INSERT INTO Credentials(login, password) VALUES ('admin', 'password')";
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
}
