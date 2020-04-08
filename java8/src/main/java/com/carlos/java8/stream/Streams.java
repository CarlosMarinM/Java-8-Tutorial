package com.carlos.java8.stream;

import java.util.ArrayList;
import java.util.List;

public class Streams {

	private List<String> lista;
	private List<String> numeros;

	public Streams() {
		lista = new ArrayList<String>();
		lista.add("Carlos");
		lista.add("Arturo");
		lista.add("Marin");
		lista.add("Mendez");

		numeros = new ArrayList<String>();
		numeros.add("1");
		numeros.add("2");
	}

	public void filtrar() {
		lista.stream().filter(s -> s.startsWith("M")).forEach(System.out::println);
	}

	public void ordenar() {
		// Orden ascendente
		lista.stream().sorted().forEach(System.out::println);

		// Orden descendente
		lista.stream().sorted((x, y) -> y.compareTo(x)).forEach(System.out::println);
	}

	public void transformar() {
		lista.stream().map(String::toUpperCase).forEach(System.out::println);

		numeros.stream().map(n -> Integer.parseInt(n) + 1).forEach(System.out::println);
	}

	public void limitar() {
		lista.stream().limit(2).forEach(System.out::println);
	}

	public void contar() {
		System.out.println(lista.stream().count());
	}

	public static void main(String[] args) {
		Streams app = new Streams();
//		app.filtrar();
//		app.ordenar();
//		app.transformar();
//		app.limitar();
//		app.contar();

	}

}
