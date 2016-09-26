package com.ipartek.formacion.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistencia.Ejemplar;
import com.ipartek.formacion.dao.persistencia.Usuario;

public class EjemplarMapper implements RowMapper<Ejemplar> {
	private Usuario usuario;

	@Override
	public Ejemplar mapRow(ResultSet rs, int arg1) throws SQLException {
		this.usuario = new Usuario();
		Ejemplar ejemplar = null;
		ejemplar = new Ejemplar(usuario);
		ejemplar.setIdEjemplar(rs.getInt("idEjemplar"));
		ejemplar.setEditorial(rs.getString("editorial"));
		ejemplar.setNumPags(rs.getInt("numPags"));
		ejemplar.getUsuario().setIdUsuario(rs.getInt("idUsuario"));
		return ejemplar;
	}

}
