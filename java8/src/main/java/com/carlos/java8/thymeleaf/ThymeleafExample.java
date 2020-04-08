package com.carlos.java8.thymeleaf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import com.carlos.java8.config.AppConfiguration;
import com.carlos.java8.email.JavaMail;
import com.carlos.java8.velocity.Documento;

public class ThymeleafExample {
	// Obtener el contexto de Spring
	ApplicationContext ctxSpring = new AnnotationConfigApplicationContext(AppConfiguration.class);

	private static String numeroDocumento = "SETT2000";
	private static String descripcionEstado = "Registrado";
	private static String estadoDian = "2";
	private static String descripcionEstadoDian = "Recibido";
	private static String respuestaDian = "Respuesta exitosa";

	private void iniciarPruebaThymeleaf() throws IOException {
		List<Documento> documentos = new ArrayList<Documento>();
		documentos.add(
				new Documento(numeroDocumento, descripcionEstado, estadoDian, descripcionEstadoDian, respuestaDian));
		documentos.add(
				new Documento(numeroDocumento, descripcionEstado, estadoDian, descripcionEstadoDian, respuestaDian));
		documentos.add(
				new Documento(numeroDocumento, descripcionEstado, estadoDian, descripcionEstadoDian, respuestaDian));
		documentos.add(
				new Documento(numeroDocumento, descripcionEstado, estadoDian, descripcionEstadoDian, respuestaDian));

		String logoFaceldi = Base64.getEncoder()
				.encodeToString(FileUtils.readFileToByteArray(new File("src/main/resources/assets/logo_faceldi.png")));
		String logoJtc = Base64.getEncoder()
				.encodeToString(FileUtils.readFileToByteArray(new File("src/main/resources/assets/logo_jtc.png")));
		String logoFace = Base64.getEncoder()
				.encodeToString(FileUtils.readFileToByteArray(new File("src/main/resources/assets/SOC_FACEBOOK.png")));
		String logoInsta = Base64.getEncoder()
				.encodeToString(FileUtils.readFileToByteArray(new File("src/main/resources/assets/SOC_INSTAGRAM.png")));
		String logoTwitter = Base64.getEncoder()
				.encodeToString(FileUtils.readFileToByteArray(new File("src/main/resources/assets/SOC_TWITTER.png")));

		// Obtener HTML a partir de la plantilla
		Context ctxThymeleaf = new Context();
		ctxThymeleaf.setVariable("nombreEmisor", "CARLOS ARTURO MARIN MENDEZ");
		ctxThymeleaf.setVariable("nombreArchivo", "archivo_de_prueba.txt");
		ctxThymeleaf.setVariable("correoInformacion", "carlos.marinm@hotmail.com");
		ctxThymeleaf.setVariable("documentos", documentos);
		ctxThymeleaf.setVariable("LOGO_FACELDI", logoFaceldi);
		ctxThymeleaf.setVariable("LOGO_JTC", logoJtc);
		ctxThymeleaf.setVariable("SOC_FACEBOOK", logoFace);
		ctxThymeleaf.setVariable("SOC_INSTAGRAM", logoInsta);
		ctxThymeleaf.setVariable("SOC_TWITTER", logoTwitter);

		SpringTemplateEngine templateEngine = (SpringTemplateEngine) ctxSpring.getBean("springTemplateEngine");
		String html = templateEngine.process("doc-emission", ctxThymeleaf);

		System.out.println(html);

		JavaMail email = (JavaMail) ctxSpring.getBean("email");
		email.enviarCorreo("Prueba de correo con plantilla", html);

//		JavaMailSpring email = (JavaMailSpring) ctxSpring.getBean("emailSpring");
//		try {
//			email.enviarCorreo("Prueba de correo con plantilla", html);
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
	}

	public static void main(String[] args) {
		ThymeleafExample app = new ThymeleafExample();
		try {
			app.iniciarPruebaThymeleaf();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
