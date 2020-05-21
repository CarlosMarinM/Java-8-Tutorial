package com.carlos.java8.thymeleaf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import com.carlos.java8.config.AppConfiguration;
import com.carlos.java8.email.JavaMailSpring;
import com.carlos.java8.velocity.Documento;

@Component
public class ThymeleafExample {

	private static String numeroDocumento = "SETT2000";
	private static String descripcionEstado = "Registrado";
	private static String estadoDian = "2";
	private static String descripcionEstadoDian = "Recibido";
	private static String respuestaDian = "Respuesta exitosa";

	@Autowired
	private SpringTemplateEngine springTemplateEngine;
	@Autowired
	private JavaMailSpring email;
//	@Autowired
//	private JavaMail email;

	public void iniciarPruebaThymeleaf() throws IOException {
		List<Documento> documentos = new ArrayList<Documento>();
		documentos.add(
				new Documento(numeroDocumento, descripcionEstado, estadoDian, descripcionEstadoDian, respuestaDian));
		documentos.add(
				new Documento(numeroDocumento, descripcionEstado, estadoDian, descripcionEstadoDian, respuestaDian));
		documentos.add(
				new Documento(numeroDocumento, descripcionEstado, estadoDian, descripcionEstadoDian, respuestaDian));
		documentos.add(
				new Documento(numeroDocumento, descripcionEstado, estadoDian, descripcionEstadoDian, respuestaDian));

		// Obtener HTML a partir de la plantilla
		Context ctxThymeleaf = new Context();
		ctxThymeleaf.setVariable("recipient", "CARLOS ARTURO MARIN MENDEZ");
		ctxThymeleaf.setVariable("nombreArchivo", "archivo_de_prueba.txt");
		ctxThymeleaf.setVariable("documentos", documentos);
		ctxThymeleaf.setVariable("documentId", "SETT50214");

		String html = springTemplateEngine.process("core-file-loaded", ctxThymeleaf);

		System.out.println(html);

		try {
			email.enviarCorreo("Prueba de correo con plantilla", html);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			AnnotationConfigApplicationContext ctxSpring = new AnnotationConfigApplicationContext(
					AppConfiguration.class);
			ThymeleafExample app = ctxSpring.getBean("thymeleafExample", ThymeleafExample.class);
			app.iniciarPruebaThymeleaf();
			ctxSpring.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
