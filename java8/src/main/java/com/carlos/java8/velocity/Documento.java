package com.carlos.java8.velocity;

public class Documento {
	private String numeroDocumento;
	private String descripcionEstado;
	private String estadoDian;
	private String descripcionEstadoDian;
	private String respuestaDian;

	public Documento(String numeroDocumento, String descripcionEstado, String estadoDian, String descripcionEstadoDian,
			String respuestaDian) {
		super();
		this.numeroDocumento = numeroDocumento;
		this.descripcionEstado = descripcionEstado;
		this.estadoDian = estadoDian;
		this.descripcionEstadoDian = descripcionEstadoDian;
		this.respuestaDian = respuestaDian;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getDescripcionEstado() {
		return descripcionEstado;
	}

	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}

	public String getEstadoDian() {
		return estadoDian;
	}

	public void setEstadoDian(String estadoDian) {
		this.estadoDian = estadoDian;
	}

	public String getDescripcionEstadoDian() {
		return descripcionEstadoDian;
	}

	public void setDescripcionEstadoDian(String descripcionEstadoDian) {
		this.descripcionEstadoDian = descripcionEstadoDian;
	}

	public String getRespuestaDian() {
		return respuestaDian;
	}

	public void setRespuestaDian(String respuestaDian) {
		this.respuestaDian = respuestaDian;
	}

}
