package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.dao.LibroDAOImp;
import com.ipartek.formacion.dao.interfaces.LibroDAO;
import com.ipartek.formacion.dao.persistencia.Libro;
import com.ipartek.formacion.dao.persistencia.Usuario;

public class LibroServiceImp implements LibroService{
	@Autowired
	LibroDAO libroDAO;
	
	@Override
	public List<Libro> getAll() {
		List<Libro> libros = null;
		libros = libroDAO.getAll();
		return libros;
	}

	@Override
	public void setLibroDAO(LibroDAOImp libroDAO) {
		this.libroDAO=libroDAO;
		
	}

	@Override
	public Libro getById(int id) {
		Libro libro = libroDAO.getById(id);
		return libro;
	}

	@Override
	public Libro update(Libro libro) {
		Libro lib = libroDAO.update(libro);
		return lib;
	}

	@Override
	public void delete(int id) {
		libroDAO.delete(id);
		
	}

	@Override
	public Libro create(Libro libro) {
		return libroDAO.create(libro);
	}

}
