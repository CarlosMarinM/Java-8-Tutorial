package com.carlos.java8.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Colecciones {

	private List<String> lista;

	public void llenarLista() {
		lista = new ArrayList<String>();

		lista.add("Carlos");
		lista.add("Arturo");
		lista.add("Marin");
		lista.add("Mendez");
	}

	public void usarForEach() {
		// Java 7
//		for (String elemento : lista) {
//			System.out.println(elemento);
//		}

		// Java 8. forEach recibe como parametro un Consumer<T> que es una interfaz
		// funcional
//		lista.forEach(x -> System.out.println(x));

		// Java 8 referencia a metodo
		lista.forEach(System.out::println);
	}

	public void usarRemoveIf() {
		// Java 7. No se puede remover un elemento que esta siendo iterado en un for.
		// Esto genera un ConcurrentModificationException. Para poder eliminar un
		// elemento de esta manera, es necesario declarar un Iterator y crear un ciclo
		// con whileF
//		for (String elemento : lista) {
//			if (elemento.equalsIgnoreCase("Carlos")) {
//				lista.remove(elemento);
//			}
//		}

		Iterator<String> it = lista.iterator();
		while (it.hasNext()) {
			if (it.next().equalsIgnoreCase("Carlos")) {
				it.remove();
			}
		}

		// Java 8. removeIf recibe como parametro un Predicate<T> (funcion con valor
		// boolean), para hacer filtros de datos
		lista.removeIf(s -> s.equalsIgnoreCase("Arturo"));
	}

	public void usarSort() {
		// Java 7
//		Collections.sort(lista);

		// Java 8 lambda
//		lista.sort((x, y) -> x.compareTo(y));

		// Java 8 referencia a metodo
		lista.sort(String::compareTo);
	}

	public static void main(String[] args) {
		Colecciones app = new Colecciones();
		app.llenarLista();
//		app.usarRemoveIf();
		app.usarSort();
		app.usarForEach();
	}

}
