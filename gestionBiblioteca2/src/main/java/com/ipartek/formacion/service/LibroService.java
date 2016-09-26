package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.dao.persistencia.Libro;

public interface LibroService {
	public List<Libro> getAll();

	public List<Libro> find(Libro libro);
}
