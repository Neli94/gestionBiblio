package com.ipartek.formacion.dao.persistencia;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {
	private int idUsuario;
	private String nombre;
	private String apellidos;
	private Date fechaNaci;
	private String email;
	private String contrasena;

	/**
	 * 
	 */
	public Usuario() {
		super();
		setNombre("");
		setApellidos("");
		setFechaNaci(new Date());
		setEmail("");
		setContrasena("");
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int id) {
		this.idUsuario = id;
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

}
