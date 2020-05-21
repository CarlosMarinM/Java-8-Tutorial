package com.carlos.java8.email;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class JavaMailSpring {

	// Se puede reemplazar el bean por una instancia local de JavaMailSender
	@Autowired
	private JavaMailSender emailSender;

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//		mailSender.setHost("smtp.gmail.com");
//		mailSender.setPort(587);
//		mailSender.setUsername("carlosartmen88@gmail.com");
//		mailSender.setPassword("imhotep1188");
//
//		Properties props = mailSender.getJavaMailProperties();
//		props.put("mail.transport.protocol", "smtp");
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.debug", "true");
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("facturacion@cincoveinticinco.com");
		mailSender.setPassword("S3cur3Pa55@1983#*");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

//		emisor.getServidorCorreo().put("Host", "smtp.gmail.com");
//		emisor.getServidorCorreo().put("Puerto", "465");
//		emisor.getServidorCorreo().put("OrigenCorreos", "facturacion@cincoveinticinco.com");
//		emisor.getServidorCorreo().put("StartTLS", "true");
//		emisor.getServidorCorreo().put("SSL", "false");
//		emisor.getServidorCorreo().put("Auth", "true");
//		emisor.getServidorCorreo().put("Debug", "true");
//		emisor.getServidorCorreo().put("User", "facturacion@cincoveinticinco.com");
//		emisor.getServidorCorreo().put("Password", "S3cur3Pa55@1983#*");

		return mailSender;
	}

	// Para enviar correos desde el servidor de Gmail, de debe permitir el acceso de
	// aplicaciones poco seguras, desde la cuenta de Gmail.
	// https://myaccount.google.com/lesssecureapps
	public void enviarCorreo(String subject, String messageBody)
			throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());

		InternetAddress fromAddress = new InternetAddress("facturacion@cincoveinticinco.com", "Carlos Marin");

		helper.setFrom(fromAddress);
		helper.setTo("carlos.marinm@hotmail.com");
		helper.setSubject(subject);
		helper.setText(messageBody, true);

		// Imagenes fijas del layout
		helper.addInline("logo_faceldi.png", new ClassPathResource("assets/logo_faceldi.png"));
		helper.addInline("logo_jtc.png", new ClassPathResource("assets/logo_jtc.png"));
		helper.addInline("icon_instagram.png", new ClassPathResource("assets/icon_instagram.png"));
		helper.addInline("icon_facebook.png", new ClassPathResource("assets/icon_facebook.png"));
		helper.addInline("icon_twitter.png", new ClassPathResource("assets/icon_twitter.png"));

		emailSender.send(message);

	}

	public static void main(String[] args) {
		JavaMailSpring app = new JavaMailSpring();
		try {
			app.enviarCorreo("Asunto", "Prueba de envio de correo electronico");
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
