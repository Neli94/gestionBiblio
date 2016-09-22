package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistencia.Libro;


public interface LibroDAO extends DAOSetter{
	public List<Libro> getAll();

	public Libro getById(int id);

	public Libro update(Libro libro);

	public void delete(int id);

	public Libro create(Libro libro);
}
