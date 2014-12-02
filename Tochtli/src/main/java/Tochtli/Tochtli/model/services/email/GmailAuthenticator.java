package Tochtli.Tochtli.model.services.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

class GmailAuthenticator extends Authenticator {
	
	String user = "";
	String password = "";
	
	public GmailAuthenticator(String user, String pass) {
		super();
		this.user = user;
		this.password = pass;
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(user, password);
	}
}