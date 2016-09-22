package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.dao.UsuarioDAOImp;
import com.ipartek.formacion.dao.interfaces.UsuarioDAO;
import com.ipartek.formacion.dao.persistencia.Usuario;

public class UsuarioServiceImp implements UsuarioService {
	@Autowired
	UsuarioDAO usuarioDAO;

	@Override
	public List<Usuario> getAll() {
		List<Usuario> usuarios = null;
		usuarios = usuarioDAO.getAll();
		return usuarios;
	}

	@Override
	public void setUsuarioDAO(UsuarioDAOImp usuarioDAO) {
		this.usuarioDAO = usuarioDAO;

	}

	@Override
	public Usuario getById(int id) {
		Usuario usuario = usuarioDAO.getById(id);
		return usuario;
	}

	@Override
	public Usuario update(Usuario usuario) {
		Usuario usu = usuarioDAO.update(usuario);
		return usu;
	}

	@Override
	public void delete(int id) {
		usuarioDAO.delete(id);

	}

	@Override
	public Usuario create(Usuario usuario) {
		return usuarioDAO.create(usuario);
	}

}
