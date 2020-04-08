package com.carlos.java8.methodreferences;

import java.util.Arrays;

public class ReferenciaMetodo {

	public static void referenciarMetodoEstatico() {
		System.out.println("Metodo estatico referido");
	}

	public void referenciarMetodoInstanciaObjetoArbitrario() {
		String[] nombres = { "Carlos", "Arturo", "Marin", "Mendez" };

		// Java 7
//		Arrays.sort(nombres, new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.compareToIgnoreCase(o2);
//			}
//		});

		// Java 8 lambda
//		Arrays.sort(nombres, (o1, o2) -> o1.compareToIgnoreCase(o2));

		// Java 8 Referencia a metodos
		Arrays.sort(nombres, String::compareToIgnoreCase);

		System.out.println(Arrays.toString(nombres));
	}

	public void referenciarMetodoInstanciaObjetoParticular() {
		System.out.println("Método referido instancia de un objeto en particular");
	}

	public void referenciarConstructor() {
		// Java 7
//		IPersona ip = new IPersona() {
//
//			@Override
//			public Persona crear(int id, String nombre) {
//				return new Persona(id, nombre);
//			}
//		};
//
//		Persona p = ip.crear(1, "Carlos");

		// Java 8 lambda
//		IPersona ip = (id, nombre) -> new Persona(id, nombre);
//		Persona p = ip.crear(2, "Arturo");

		IPersona ip = Persona::new;
		Persona p = ip.crear(3, "Marin", "Mendez", 25);

		System.out.println(p.toString());
	}

	public void operar() {
		Operacion op = () -> ReferenciaMetodo.referenciarMetodoEstatico();
		op.saludar();

		Operacion op2 = ReferenciaMetodo::referenciarMetodoEstatico;
		op2.saludar();
	}

	public static void main(String[] args) {
		ReferenciaMetodo app = new ReferenciaMetodo();
		app.operar();
		app.referenciarMetodoInstanciaObjetoArbitrario();

		Operacion op = app::referenciarMetodoInstanciaObjetoParticular;
		op.saludar();

		app.referenciarConstructor();
	}

}