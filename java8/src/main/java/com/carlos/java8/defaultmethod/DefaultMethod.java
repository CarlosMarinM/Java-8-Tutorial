package com.carlos.java8.defaultmethod;

public class DefaultMethod implements PersonaA, PersonaB {

	@Override
	public void caminar() {
		System.out.println("Empezo a caminar¡¡¡¡");
	}

	@Override
	public void hablar() {
		PersonaB.super.hablar();
	}

	public static void main(String[] args) {
		DefaultMethod app = new DefaultMethod();
		app.caminar();
		app.hablar();
	}

}
