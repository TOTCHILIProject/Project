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

	public static void sendEmail(String to, String cc, String from, String subject, String text) {
		try {
			Properties emailProp = new Properties();

			InputStream emailPropTxt = EmailService.class.getResourceAsStream("emailProp.txt");
			emailProp.load(emailPropTxt);
			// System.out.println(emailProp.toString());

			// null : no authenticator
			Session emailSession = Session.getDefaultInstance(emailProp);

			Message emailMessage = new MimeMessage(emailSession);
			emailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			if (cc != null) {
				emailMessage.setRecipient(Message.RecipientType.CC, new InternetAddress(cc));
			}

			emailMessage.setFrom(new InternetAddress(from));
			emailMessage.setSubject(subject);
			emailMessage.setText(text);

			Transport transport = emailSession.getTransport("smtp");
			transport.connect(emailSession.getProperty("mail.smtp.host"), emailSession.getProperty("mail.smtp.user"),
					emailSession.getProperty("mail.smtp.password"));
			transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
