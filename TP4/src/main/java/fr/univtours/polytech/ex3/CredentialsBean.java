package fr.univtours.polytech.ex3;

import java.io.Serializable;

public class CredentialsBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String login;

	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login: '" + login + "' - Password: '" + password + "'";
	}
}
