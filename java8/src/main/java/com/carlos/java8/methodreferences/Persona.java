package com.carlos.java8.methodreferences;

public class Persona {
	private double id;
	private String nombre;
	private String apellido;
	private int edad;

	public Persona() {
	}

	public Persona(double id, String nombre, String apellido, int edad) {
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setEdad(edad);
	}

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + "]";
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}
