package com.ipartek.formacion.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.EjemplarDAO;
import com.ipartek.formacion.dao.mappers.EjemplarMapper;
import com.ipartek.formacion.dao.mappers.LibrosExtractor;
import com.ipartek.formacion.dao.persistencia.Ejemplar;
import com.ipartek.formacion.dao.persistencia.Libro;

@Repository("ejemplarDAOImp")
public class EjemplarDAOImp implements EjemplarDAO {
	private static final Logger logger = LoggerFactory.getLogger(EjemplarDAOImp.class);
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;

	@Override
	public List<Libro> getAll() {
		List<Libro> libros = null;
		final String SQL = "SELECT idLibro, titulo, autor, isbn, idEjemplar FROM libro";

		libros = jdbctemplate.query(SQL, new LibrosExtractor());
		return libros;
	}

	@Override
	public List<Libro> find(Libro libro) {
		List<Libro> libros = null;
		final String SQL = "call CONSULTAR_CATOLOGO(?,?)";
		libros = jdbctemplate.query(SQL, new Object[] { libro.getIsbn(), libro.getTitulo() }, new LibrosExtractor());

		return libros;
	}

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		this.jdbctemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public List<Ejemplar> getEjemplares(Libro libro) {
		List<Ejemplar> ejemplares = null;
		final String SQL = "SELECT idEjemplar, editorial, numPags, idUsuario FROM ejemplar e INNER JOIN libro l "
				+ "ON l.idEjemplar=e.idEjemplar WHERE idLibro=?";
		jdbcCall.withProcedureName(SQL).returningResultSet("listado", new EjemplarMapper());
		SqlParameterSource in = new MapSqlParameterSource().addValue("idLibro", libro.getIdLibro());
		ejemplares = (List<Ejemplar>) jdbcCall.execute(in).get("listado");

		return ejemplares;
	}

	@Override
	public Ejemplar getEjemplar(int idEjemplar) {
		final String SQL = "SELECT idEjemplar, editorial, numPags, idUsuario FROM ejemplar WHERE idEjemplar=? ";
		Ejemplar ejemplar = null;
		jdbcCall.withProcedureName(SQL).returningResultSet("ejemplar", new EjemplarMapper());
		SqlParameterSource in = new MapSqlParameterSource().addValue("idEjemplar", idEjemplar);
		ejemplar = (Ejemplar) jdbcCall.execute(in).get("ejemplar");
		return ejemplar;
	}

	@Override
	public void eliminar(int idLibro) {
		final String SQL = "BORRAR_EJEMPLAR";
		jdbcCall.withProcedureName(SQL);
		SqlParameterSource in = new MapSqlParameterSource().addValue("codigoLibro", idLibro);
		jdbcCall.execute(in);

	}

	@Override
	public Ejemplar update(Ejemplar ejemplar) {
		final String SQL = "ACTUALIZAR_EJEMPLAR";
		jdbcCall.withProcedureName(SQL);
		SqlParameterSource in = new MapSqlParameterSource().addValue("idEjemplar", ejemplar.getIdEjemplar())
				.addValue("isbn", ejemplar.getIsbn()).addValue("numPags", ejemplar.getNumPags())
				.addValue("titulo", ejemplar.getTitulo()).addValue("idLibro", ejemplar.getIdLibro());
		jdbcCall.execute(in);

		return ejemplar;
	}

}
