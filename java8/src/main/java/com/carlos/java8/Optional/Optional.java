package com.carlos.java8.Optional;

import java.util.Arrays;

public class Optional {

	public void probar(String valor) {
		System.out.println(valor.contains("carlos"));
	}

	public void orElse(String valor) {

	}

	public void orElseThrow(String valor) {

	}

	public void isPresent(String valor) {

	}

	public static void main(String[] args) {
//		Optional app = new Optional();
//		app.probar(null);
		String a = "abcdefghij||klmnopqrs.xml";
		
		Arrays.asList(a.split("\\|{2}")).forEach(System.out::println);
	}

}
