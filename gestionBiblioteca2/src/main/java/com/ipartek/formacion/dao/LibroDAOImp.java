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

import com.ipartek.formacion.dao.interfaces.LibroDAO;
import com.ipartek.formacion.dao.mappers.LibroMapper;
import com.ipartek.formacion.dao.mappers.UsuarioMapper;
import com.ipartek.formacion.dao.persistencia.Libro;
import com.ipartek.formacion.dao.persistencia.Usuario;

@Repository("libroDAOImp")
public class LibroDAOImp implements LibroDAO{
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource);
		this.jdbcCall = new SimpleJdbcCall(dataSource);	
	}

	@Override
	public List<Libro> getAll() {
		List<Libro> libros = null;
		final String sql = "SELECT idLibro, titulo, autor, isbn, idEjemplar FROM libro";
		try {
			libros = jdbctemplate.query(sql, new LibroMapper());
		} catch (EmptyResultDataAccessException e) {
			libros = new ArrayList<Libro>();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return libros;
	}

	@Override
	public Libro getById(int id) {
		Libro libro = null;
		final String SQL = "SELECT idLibro, titulo, autor, isbn, idEjemplar FROM libro WHERE idLibro=?";
		try {
			libro = jdbctemplate.queryForObject(SQL, new Object[] { id }, new LibroMapper());
		} catch (EmptyResultDataAccessException e) {
			libro = new Libro();
		}
		return libro;
	}

	@Override
	public Libro update(Libro libro) {
		final String SQL = "UPDATE libro SET titulo=?, autor=?, isbn=?, idEjemplar=?  WHERE idLibro=?";
		for(int i=0;i<libro.getEjemplares().size();i++){
			jdbctemplate
			.update(SQL,
					new Object[] { libro.getTitulo(), libro.getAutor(), libro.getIsbn(),
							libro.getEjemplares().get(i).getIdEjemplar(), libro.getIdLibro()});
		}
		
		return libro;
	}

	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM libro WHERE idLibro=?";
		jdbctemplate.update(SQL, new Object[] { id });
		
	}

	@Override
	public Libro create(Libro libro) {
		jdbcCall.withProcedureName("insertLibro");
		
		SqlParameterSource in=null;
		for(int i=0;i<libro.getEjemplares().size();i++){
			in = new MapSqlParameterSource().addValue("titulo", libro.getTitulo())
					.addValue("autor", libro.getAutor()).addValue("isbn", libro.getIsbn())
					.addValue("idEjemplar", libro.getEjemplares().get(i).getIdEjemplar());
		}

		Map<String, Object> out = jdbcCall.execute(in);
		libro.setIdLibro((Integer) out.get("idLibro"));
		return libro;
	}

}
