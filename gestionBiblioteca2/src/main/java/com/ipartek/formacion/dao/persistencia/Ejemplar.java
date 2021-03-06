package com.ipartek.formacion.dao.persistencia;

public class Ejemplar extends Libro {
	private int idEjemplar;
	private String editorial;
	private int numPags;
	private Usuario usuario;

	/**
	 * 
	 */
	public Ejemplar(Usuario usuario) {
		super();
		setEditorial("");
		setNumPags(0);
		setUsuario(usuario);
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
