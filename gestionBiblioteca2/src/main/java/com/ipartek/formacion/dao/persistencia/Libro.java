package com.ipartek.formacion.dao.persistencia;

import java.util.ArrayList;
import java.util.List;

public class Libro {
	private int idLibro;
	private String titulo;
	private String autor;
	private String isbn;
	private List<Ejemplar> ejemplares;

	/**
	 * 
	 */
	public Libro() {
		super();
		setIdLibro(-1);
		setTitulo("");
		setIsbn("");
		setEjemplares(new ArrayList<Ejemplar>());
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<Ejemplar> getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(List<Ejemplar> ejemplares) {
		this.ejemplares = ejemplares;
	}

	public void addEjemplar(Ejemplar ejemplar) {
		this.ejemplares.add(ejemplar);
	}

}
