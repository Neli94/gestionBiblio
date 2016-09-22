package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.EjemplarDAO;
import com.ipartek.formacion.dao.mappers.EjemplarMapper;
import com.ipartek.formacion.dao.mappers.UsuarioMapper;
import com.ipartek.formacion.dao.persistencia.Ejemplar;
import com.ipartek.formacion.dao.persistencia.Usuario;

@Repository("ejemplarDAOImp")
public class EjemplarDAOImp implements EjemplarDAO{
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
	public List<Ejemplar> getAll() {
		List<Ejemplar> ejemplares = null;
		final String sql = "SELECT idEjemplar, editorial, numPags, alquilado FROM ejemplar";
		try {
			ejemplares = jdbctemplate.query(sql, new EjemplarMapper());
		} catch (EmptyResultDataAccessException e) {
			ejemplares = new ArrayList<Ejemplar>();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ejemplares;
	}
	@Override
	public Ejemplar getById(int id) {
		Ejemplar ejemplar = null;
		final String SQL = "SELECT idEjemplar, editorial, numPags, alquilado FROM ejemplar WHERE idEjemplar=?";
		try {
			ejemplar = jdbctemplate.queryForObject(SQL, new Object[] { id }, new EjemplarMapper());
		} catch (EmptyResultDataAccessException e) {
			ejemplar = new Ejemplar();
		}
		return ejemplar;
	}
	@Override
	public Ejemplar update(Ejemplar ejemplar) {
		final String SQL = "UPDATE ejemplar SET editorial=?, numPags=?, alquilado=?  WHERE idEjemplar=?";
		jdbctemplate
				.update(SQL,
						new Object[] { ejemplar.getEditorial(), ejemplar.getNumPags(), ejemplar.getAlquilado(),
								ejemplar.getIdEjemplar() });
		return ejemplar;
	}
	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM ejemplar WHERE idEjemplar=?";
		jdbctemplate.update(SQL, new Object[] { id });
		
	}
	@Override
	public Ejemplar create(Ejemplar ejemplar) {
		jdbcCall.withProcedureName("insertEjemplar");
		SqlParameterSource in = new MapSqlParameterSource().addValue("editorial", ejemplar.getEditorial())
				.addValue("numPags", ejemplar.getNumPags()).addValue("alquilado", ejemplar.getAlquilado());

		Map<String, Object> out = jdbcCall.execute(in);
		ejemplar.setIdEjemplar((Integer) out.get("idEjemplar"));
		return ejemplar;
	}

	

}
