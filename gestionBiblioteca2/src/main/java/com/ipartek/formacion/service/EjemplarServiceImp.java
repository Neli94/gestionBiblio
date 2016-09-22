package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.dao.EjemplarDAOImp;
import com.ipartek.formacion.dao.interfaces.EjemplarDAO;
import com.ipartek.formacion.dao.persistencia.Ejemplar;
import com.ipartek.formacion.dao.persistencia.Usuario;

public class EjemplarServiceImp implements EjemplarService{
	@Autowired
	EjemplarDAO ejemplarDAO;

	@Override
	public List<Ejemplar> getAll() {
		List<Ejemplar> ejemplares = null;
		ejemplares = ejemplarDAO.getAll();
		return ejemplares;
	}

	@Override
	public void setEjemplarDAO(EjemplarDAOImp ejemplarDAO) {
		this.ejemplarDAO=ejemplarDAO;
		
	}

	@Override
	public Ejemplar getById(int id) {
		Ejemplar ejemplar=ejemplarDAO.getById(id);
		return ejemplar;
	}

	@Override
	public Ejemplar update(Ejemplar ejemplar) {
		Ejemplar ejem=ejemplarDAO.update(ejemplar);
		return ejem;
	}

	@Override
	public void delete(int id) {
		ejemplarDAO.delete(id);
		
	}

	@Override
	public Ejemplar create(Ejemplar ejemplar) {
		return ejemplarDAO.create(ejemplar);
	}

}
