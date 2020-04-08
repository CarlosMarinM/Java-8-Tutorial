package com.carlos.java8.defaultmethod;

public interface PersonaA {
	public void caminar();

	default public void hablar() {
		System.out.println("Empezo a hablar¡¡¡¡ PersonaA");
	}
}
