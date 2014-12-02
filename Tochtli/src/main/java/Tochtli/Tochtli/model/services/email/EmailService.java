package Tochtli.Tochtli.model.services.email;

import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {

	public static String tochtliEmail = "tochtli.nereid1415@gmail.com";
	private static String password = "nereid1415";

	public static void sendEmail(String to, String cc, String from, String subject, String text) {
		try {
			Properties emailProp = new Properties();

			InputStream emailPropTxt = EmailService.class.getResourceAsStream("emailProp.txt");
			emailProp.load(emailPropTxt);
			// System.out.println(emailProp.toString());

			// null : no authenticator
			Session emailSession = Session.getInstance(emailProp, new GmailAuthenticator(tochtliEmail, password));

			Message emailMessage = new MimeMessage(emailSession);
			emailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			if (cc != null) {
				emailMessage.setRecipient(Message.RecipientType.CC, new InternetAddress(cc));
			}

			emailMessage.setFrom(new InternetAddress(from));
			emailMessage.setSubject(subject);
			emailMessage.setText(text);

			Transport.send(emailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
