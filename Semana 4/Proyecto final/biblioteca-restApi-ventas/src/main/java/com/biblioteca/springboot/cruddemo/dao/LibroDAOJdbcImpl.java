package com.biblioteca.springboot.cruddemo.dao;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.biblioteca.springboot.cruddemo.entity.Libro;

@Repository
public class LibroDAOJdbcImpl implements LibroDAO {

	@Autowired
	DataSource dataSource;

	/*
	 * Connection myConn = null; Statement myStmt = null; ResultSet myRs = null;
	 */

	@Override
	public List<Libro> findAll() {
		System.out.println("Implementación DAO con JDBC: " + dataSource);

		List<Libro> listaLibros = new ArrayList<>();

		// create sql statement
		String sql = "select * from libros_2";

		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql);) {

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String nombre = myRs.getString("nombre_libro");
				String genero = myRs.getString("genero");
				String autor = myRs.getString("autor");
				double precio = myRs.getDouble("precio");

				// create new student object
				Libro tempLibro = new Libro(id, nombre, genero, autor, precio);

				// add it to the list of students
				listaLibros.add(tempLibro);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaLibros;
	}

	@Override
	public Libro findById(int theId) {
		Libro theLibro = null;

		try (Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = createPreparedStatement(myConn, theId);
				ResultSet myRs = myStmt.executeQuery();) {

			// retrieve data from result set row
			if (myRs.next()) {
				String nombre = myRs.getString("nombre_libro");
				String genero = myRs.getString("genero");
				String autor = myRs.getString("autor");
				double precio = myRs.getDouble("precio");

				// use the studentId during construction
				theLibro = new Libro(theId, nombre, genero, autor, precio);
			} else {
				throw new SQLException("Could not find employee id: " + theId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return theLibro;
	}

	private PreparedStatement createPreparedStatement(Connection con, int libroId) throws SQLException {
		String sql = "select * from libros_2 where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, libroId);
		return ps;
	}

	@Override
	public void save(Libro theLibro) {
		String sql = "";

		if (theLibro.getId() == 0)
			sql = "insert into libros_2 (nombre_libro, genero, autor, precio) values (?, ?, ?, ?)";
		else
			sql = "update libros_2 set nombre_libro=?, genero=?, autor=?, precio=? where id=?";

		try (Connection myConn = dataSource.getConnection();
			 PreparedStatement myStmt = myConn.prepareStatement(sql)) {

			myStmt.setString(1, theLibro.getNombre());
			myStmt.setString(2, theLibro.getGenero());
			myStmt.setString(3, theLibro.getAutor());
			myStmt.setDouble(4, theLibro.getPrecio());
			
			System.out.println(theLibro.getPrecio());

			if (theLibro.getId() != 0)
				myStmt.setInt(5, theLibro.getId());

			myStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteById(int theId) {
		String sql = "delete from libros where id=?";
		
		try (Connection myConn = dataSource.getConnection(); 
			 PreparedStatement myStmt = myConn.prepareStatement(sql)) {

			myStmt.setInt(1, theId);

			myStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
