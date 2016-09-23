package com.ipartek.formacion.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistencia.Usuario;

public class UsuarioMapper implements RowMapper<Usuario> {

	@Override
	public Usuario mapRow(ResultSet rs, int arg1) throws SQLException {
		Usuario usuario = null;
		usuario = new Usuario();
		usuario.setIdUsuario(rs.getInt("idUsuario"));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setApellidos(rs.getString("apellidos"));
		usuario.setFechaNaci(rs.getDate("fechaNaci"));
		usuario.setEmail(rs.getString("email"));
		usuario.setContrasena(rs.getString("contrasena"));
		return usuario;
	}

}
