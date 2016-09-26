package com.ipartek.formacion.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.dao.interfaces.EjemplarDAO;
import com.ipartek.formacion.dao.persistencia.Ejemplar;
import com.ipartek.formacion.dao.persistencia.Libro;

public class EjemplarServiceImp implements EjemplarService {
	private static final Logger logger = LoggerFactory.getLogger(EjemplarServiceImp.class);

	@Autowired
	EjemplarDAO ejemplarDAO;

	@Override
	public List<Libro> getAll() {
		return ejemplarDAO.getAll();
	}

	@Override
	public List<Libro> find(Libro libro) {
		return ejemplarDAO.find(libro);
	}

	@Override
	public List<Ejemplar> getEjemplares(Libro libro) {
		return ejemplarDAO.getEjemplares(libro);
	}

	@Override
	public Ejemplar getEjemplar(int idEjemplar) {
		return ejemplarDAO.getEjemplar(idEjemplar);
	}

	@Override
	public void eliminar(int idEjemplar) {
		ejemplarDAO.eliminar(idEjemplar);

	}

	@Override
	public Ejemplar update(Ejemplar ejemplar) {
		return ejemplarDAO.update(ejemplar);
	}

}
