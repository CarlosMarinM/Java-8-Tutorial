package com.carlos.java8.methodreferences;

@FunctionalInterface
public interface IPersona {
	Persona crear(double id, String nombre, String apellido, int edad);
}
