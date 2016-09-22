package com.ipartek.formacion.dao.persistencia;

import java.util.Date;

public class Usuario {
	private int id;
	private String nombre;
	private String apellidos;
	private Date fechaNaci;
	private String email;
	private String contrasena;
	private Ejemplar ejemplar;

	/**
	 * 
	 */
	private Usuario() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNaci() {
		return fechaNaci;
	}

	public void setFechaNaci(Date fechaNaci) {
		this.fechaNaci = fechaNaci;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Ejemplar getEjemplar() {
		return ejemplar;
	}

	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
	}
}
