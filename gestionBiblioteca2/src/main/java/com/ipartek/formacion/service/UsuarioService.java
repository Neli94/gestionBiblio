package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.dao.UsuarioDAOImp;
import com.ipartek.formacion.dao.persistencia.Usuario;

public interface UsuarioService {
	public List<Usuario> getAll();

	public void setAlumDAO(UsuarioDAOImp usuarioDAO);

	public Usuario getById(int id);

	public Usuario update(Usuario usuario);

	public void delete(int id);

	public Usuario create(Usuario usuario);
}

// telosys tools code generation
