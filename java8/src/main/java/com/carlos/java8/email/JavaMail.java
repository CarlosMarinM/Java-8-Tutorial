package com.carlos.java8.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Component;

@Component
public class JavaMail {

	final String username = "carlosartmen88@gmail.com";
	final String password = "imhotep1188";
//	final String recipient = "carlos.marinm@hotmail.com";
	final String recipient = "carlosm_tec@jaimetorres.net";
	Properties props = new Properties();

	// Para enviar correos desde el servidor de Gmail, de debe permitir el acceso de
	// aplicaciones poco seguras, desde la cuenta de Gmail.
	// https://myaccount.google.com/lesssecureapps
	public void enviarCorreo(String subject, String messageBody) {
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
//		props.put("mail.debug", "true");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Multipart mp = new MimeMultipart();

			MimeBodyPart bodyPart = new MimeBodyPart();
			bodyPart.setContent(messageBody, "text/html; charset=iso-8859-1");
			mp.addBodyPart(bodyPart);

			// Se adjunta imagen como inline (esta opcion envia la imagen como archivo
			// adjunto)
//			MimeBodyPart imagePart = new PreencodedMimeBodyPart("base64");
//			imagePart.setContentID("LOGO_FACELDI");
//			imagePart.setDisposition(MimeBodyPart.INLINE);
////			imagePart.attachFile("src/main/resources/assets/logo_faceldi.png");
////			imagePart.setHeader("Content-Transfer-Encoding", "base64");
////			  imagePart.setDataHandler(new DataHandler(Base64.decode(base64ImagesMap.get(contentId)), "image/png;"));
//			imagePart.setContent("src/main/resources/assets/logo_faceldi.png", "image/*");
//			mp.addBodyPart(imagePart);

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setSubject(subject);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setContent(messageBody, "text/html; charset=iso-8859-1");
			message.setContent(mp);
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JavaMail app = new JavaMail();
		app.enviarCorreo("Asunto", "Prueba de envio de correo electronico");
	}

}
