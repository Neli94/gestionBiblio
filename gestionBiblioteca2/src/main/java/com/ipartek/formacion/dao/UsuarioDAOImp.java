package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.UsuarioDAO;
import com.ipartek.formacion.dao.mappers.UsuarioMapper;
import com.ipartek.formacion.dao.persistencia.Usuario;

@Repository("usuarioDAOImp")
public class UsuarioDAOImp implements UsuarioDAO {
	private static final Logger logger = LoggerFactory.getLogger(UsuarioDAOImp.class);
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource);
		this.jdbcCall = new SimpleJdbcCall(dataSource);

	}

	@Override
	public List<Usuario> getAll() {
		List<Usuario> usuarios = null;
		final String sql = "SELECT idUsuario, nombre, apellidos, fechaNaci, email, contrasena FROM usuario";
		try {
			usuarios = jdbctemplate.query(sql, new UsuarioMapper());
		} catch (EmptyResultDataAccessException e) {
			usuarios = new ArrayList<Usuario>();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	@Override
	public Usuario getById(int id) {
		Usuario usuario = null;
		final String SQL = "SELECT idUsuario, nombre, apellidos, fechaNaci, email, contrasena FROM usuario WHERE idUsuario=?";
		try {
			usuario = jdbctemplate.queryForObject(SQL, new Object[] { id }, new UsuarioMapper());
		} catch (EmptyResultDataAccessException e) {
			usuario = new Usuario();
		}
		return usuario;
	}

	@Override
	public Usuario update(Usuario usuario) {
		final String SQL = "UPDATE usuario SET nombre=?, apellidos=?, fechaNaci=?, email=?, contrasena=?  WHERE idUsuario=?";
		jdbctemplate.update(SQL, new Object[] { usuario.getNombre(), usuario.getApellidos(), usuario.getFechaNaci(),
				usuario.getEmail(), usuario.getContrasena(), usuario.getIdUsuario() });
		return usuario;
	}

	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM usuario WHERE idUsuario=?";
		jdbctemplate.update(SQL, new Object[] { id });

	}

	@Override
	public Usuario create(Usuario usuario) {
		jdbcCall.withProcedureName("insertUsuario");
		SqlParameterSource in = new MapSqlParameterSource().addValue("nombre", usuario.getNombre())
				.addValue("apellidos", usuario.getApellidos()).addValue("fechaNaci", usuario.getFechaNaci())
				.addValue("email", usuario.getEmail()).addValue("contrasena", usuario.getContrasena());

		Map<String, Object> out = jdbcCall.execute(in);
		usuario.setIdUsuario((Integer) out.get("idUsuario"));
		return usuario;
	}

}
