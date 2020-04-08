package com.carlos.java8.email;

import java.nio.charset.StandardCharsets;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class JavaMailSpring {

	// Obtener el contexto de Spring
//	ApplicationContext ctxSpring = new AnnotationConfigApplicationContext(JavaMailConfiguration.class);;

	// Para enviar correos desde el servidor de Gmail, de debe permitir el acceso de
	// aplicaciones poco seguras, desde la cuenta de Gmail.
	// https://myaccount.google.com/lesssecureapps
	public void enviarCorreo(String subject, String messageBody) throws MessagingException {
//		JavaMailSender emailSender = (JavaMailSenderImpl) ctxSpring.getBean("getJavaMailSender");

		JavaMailSenderImpl emailSender = new JavaMailSenderImpl();
		emailSender.setHost("smtp.gmail.com");
		emailSender.setPort(587);
		emailSender.setUsername("carlosartmen88@gmail.com");
		emailSender.setPassword("imhotep1188");

		Properties props = emailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());

//		helper.addAttachment("logo_jtc.png", new ClassPathResource("assets/logo_jtc.png"));

		// Imagenes fijas del layout
//		helper.addInline("LOGO_FACELDI", new ClassPathResource("assets/logo_faceldi.png"));

		helper.setTo("carlos.marinm@hotmail.com");
		helper.setText(messageBody, true);
		helper.setSubject(subject);
		helper.setFrom("carlosartmen88@gmail.com");

		emailSender.send(message);

	}

	public static void main(String[] args) {
		JavaMailSpring app = new JavaMailSpring();
		try {
			app.enviarCorreo("Asunto", "Prueba de envio de correo electronico");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
