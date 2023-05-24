package fr.univtours.polytech.ex3;

public interface LoginBusiness {
	public CredentialsBean getCredentials(String login);

	public boolean checkCredentials(CredentialsBean user, String login, String password);
}
