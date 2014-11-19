package Tochtli.Tochtli.model.services;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {

	private static String mailSmtpHost = "cakelycakes.com";
	public static String tochtliEmail = "tochtli@gmail.com";

	public static void sendEmail(String to, String cc, String from,
			String subject, String text) {
		try {
			Properties properties = new Properties();
			properties.put("mail.smtp.host", mailSmtpHost);
			Session emailSession = Session.getDefaultInstance(properties);

			Message emailMessage = new MimeMessage(emailSession);
			emailMessage.addRecipient(Message.RecipientType.TO,
					new InternetAddress(to));
			if (cc != null) {
				emailMessage.addRecipient(Message.RecipientType.CC,
						new InternetAddress(cc));
			}

			emailMessage.setFrom(new InternetAddress(from));
			emailMessage.setSubject(subject);
			emailMessage.setText(text);

			emailSession.setDebug(true);

			Transport.send(emailMessage);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
