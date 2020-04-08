package com.carlos.java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambda {

	public void ordenar() {
		List<String> lista = new ArrayList<String>();
		lista.add("Carlos");
		lista.add("Java");
		lista.add("Desarrollador");
		lista.add("Marin");

		// Implementacion en Java 7
//		Collections.sort(lista, new Comparator<String>() {
//
//			public int compare(String o1, String o2) {
//				return o1.compareTo(o2);
//			}
//		});

		// Implementacion en Java 8
		Collections.sort(lista, (String p1, String p2) -> p1.compareTo(p2));

		for (String string : lista) {
			System.out.println(string);
		}
	}

	public void calcularPromedio() {
		// Implementacion en Java 7
		/*
		 * Operacion op = new Operacion() {
		 * 
		 * @Override public double calcular(double i1, double i2) { return (i1 + i2) /
		 * 2; } };
		 * 
		 */

		// Implementacion en Java 8
		Operacion op = (double n1, double n2) -> (n1 + n2) / 2;

		System.out.println(op.calcular(4, 7));
	}

	public static void main(String[] args) {
		Lambda app = new Lambda();
//		app.ordenar();
		app.calcularPromedio();
	}

}
