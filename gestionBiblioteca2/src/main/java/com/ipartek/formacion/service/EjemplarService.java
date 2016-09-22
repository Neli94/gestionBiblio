package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.dao.EjemplarDAOImp;
import com.ipartek.formacion.dao.persistencia.Ejemplar;


public interface EjemplarService {
	public List<Ejemplar> getAll();

	public void setEjemplarDAO(EjemplarDAOImp ejemplarDAO);

	public Ejemplar getById(int id);

	public Ejemplar update(Ejemplar ejemplar);

	public void delete(int id);

	public Ejemplar create(Ejemplar ejemplar);
}
