package com.ipartek.formacion.dao.persistencia;

public class Ejemplar {
	private int idEjemplar;
	private String editorial;
	private int numPags;
	private int alquilado;

	/**
	 * 
	 */
	public Ejemplar() {
		super();
	}

	public int getIdEjemplar() {
		return idEjemplar;
	}

	public void setIdEjemplar(int idEjemplar) {
		this.idEjemplar = idEjemplar;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getNumPags() {
		return numPags;
	}

	public void setNumPags(int numPags) {
		this.numPags = numPags;
	}

	public int getAlquilado() {
		return alquilado;
	}

	public void setAlquilado(int alquilado) {
		this.alquilado = alquilado;
	}

}
