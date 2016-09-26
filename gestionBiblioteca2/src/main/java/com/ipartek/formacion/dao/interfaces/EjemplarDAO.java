package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistencia.Ejemplar;
import com.ipartek.formacion.dao.persistencia.Libro;

public interface EjemplarDAO extends LibroDAO {
	public List<Ejemplar> getEjemplares(Libro libro);

	public Ejemplar getEjemplar(int idEjemplar);

	public void eliminar(int idLibro);

	public Ejemplar update(Ejemplar ejemplar);
}
