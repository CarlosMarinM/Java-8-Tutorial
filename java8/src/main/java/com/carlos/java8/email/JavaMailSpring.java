package com.carlos.java8.email;

import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.carlos.java8.config.JavaMailConfiguration;

public class JavaMailSpring {

	// Obtener el contexto de Spring
	ApplicationContext ctxSpring = new AnnotationConfigApplicationContext(JavaMailConfiguration.class);;

	// Para enviar correos desde el servidor de Gmail, de debe permitir el acceso de
	// aplicaciones poco seguras, desde la cuenta de Gmail.
	// https://myaccount.google.com/lesssecureapps
	public void enviarCorreo(String subject, String messageBody) throws MessagingException {
		JavaMailSender emailSender = (JavaMailSenderImpl) ctxSpring.getBean("getJavaMailSender");

		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());

		helper.setFrom("carlosartmen88@gmail.com");
		helper.setTo("carlos.marinm@hotmail.com");
		helper.setSubject(subject);
		helper.setText(messageBody, true);

		// Imagenes fijas del layout
		helper.addInline("LOGO_FACELDI", new ClassPathResource("assets/logo_faceldi.png"));
		helper.addInline("LOGO_JTC", new ClassPathResource("assets/logo_jtc.png"));
		helper.addInline("SOC_INSTAGRAM", new ClassPathResource("assets/SOC_INSTAGRAM.png"));
		helper.addInline("SOC_FACEBOOK", new ClassPathResource("assets/SOC_FACEBOOK.png"));
		helper.addInline("SOC_TWITTER", new ClassPathResource("assets/SOC_TWITTER.png"));

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
