package com.carlos.java8.velocity;

import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.carlos.java8.config.AppConfiguration;
import com.carlos.java8.email.JavaMail;

public class VelocityExample {

//	@Autowired
//	private Email email;

	private static String numeroDocumento = "SETT2000";
	private static String descripcionEstado = "Registrado";
	private static String estadoDian = "2";
	private static String descripcionEstadoDian = "Recibido";
	private static String respuestaDian = "Respuesta exitosa";

	private void iniciarPruebaVelocity() {
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
		Velocity.init();
		
//		Template t = Velocity.getTemplate("./src/index.html");
		Template t = Velocity.getTemplate("./src/templates/doc-emission.html");
		
		VelocityContext ctx = new VelocityContext();
		ctx.put("nombreEmisor", "CARLOS ARTURO MARIN MENDEZ");
		ctx.put("nombreArchivo", "archivo_de_prueba.txt");
		ctx.put("correoInformacion", "carlos.marinm@hotmail.com");
		ctx.put("documentos", documentos);
		Writer writer = new StringWriter();
		t.merge(ctx, writer);

		System.out.println(writer);

		// Obtener el contexto de Spring
		ApplicationContext ctxSpring = new AnnotationConfigApplicationContext(AppConfiguration.class);
		JavaMail email = (JavaMail) ctxSpring.getBean("email");

		email.enviarCorreo("Prueba de correo con plantilla", writer.toString());
	}

	public static void main(String[] args) {
		VelocityExample app = new VelocityExample();
		app.iniciarPruebaVelocity();
	}

}
