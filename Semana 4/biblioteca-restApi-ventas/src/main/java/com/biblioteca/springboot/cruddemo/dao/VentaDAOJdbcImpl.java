package com.biblioteca.springboot.cruddemo.dao;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.biblioteca.springboot.cruddemo.entity.Libro;
import com.biblioteca.springboot.cruddemo.entity.Ventas;

@Repository
public class VentaDAOJdbcImpl implements VentaDAO {

	@Autowired
	DataSource dataSource;

	/*
	 * Connection myConn = null; Statement myStmt = null; ResultSet myRs = null;
	 */

	@Override
	public List<Ventas> ventaLibro(int theId) {

		List<Ventas> listaVentas = new ArrayList<>();
		
		try (Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = createPreparedStatement_venta(myConn, theId);
				ResultSet myRs = myStmt.executeQuery();) {

			// retrieve data from result set row
			while (myRs.next()) {
				String fecha = myRs.getString("fecha");
				int cantidad = myRs.getInt("cantidad");
				double total = myRs.getDouble("total");

				// use the studentId during construction
				Ventas tempVenta  = new Ventas(theId, fecha, cantidad, total);
				
				listaVentas.add(tempVenta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaVentas;
	}
	
	private PreparedStatement createPreparedStatement_venta(Connection con, int libroId) throws SQLException {
		String sql = "select venta.fecha, detalle.cantidad, venta.total"+
				" from biblioteca2.venta venta inner join biblioteca2.detalle_venta detalle"+
				" where venta.id_detalle = detalle.id and detalle.id_libro=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, libroId);
		return ps;
	}

}
