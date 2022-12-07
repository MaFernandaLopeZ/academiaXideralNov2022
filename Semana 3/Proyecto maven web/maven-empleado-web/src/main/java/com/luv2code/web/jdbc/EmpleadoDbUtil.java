package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EmpleadoDbUtil {

	private DataSource dataSource;

	public EmpleadoDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Empleado> getEmpleados() throws Exception {
		
		List<Empleado> empleados = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from empleado order by id";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String nombre = myRs.getString("nombre");
				String ap = myRs.getString("ap");
				String am = myRs.getString("am");
				String correo = myRs.getString("correo");
				
				// create new student object
				Empleado tempEmpleado = new Empleado(id, nombre, ap, am, correo);
				
				// add it to the list of empleados
				empleados.add(tempEmpleado);				
			}
			
			return empleados;		
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addEmpleados(Empleado theEmpleado) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into empleado "
					   + "(nombre, ap, am, correo) "
					   + "values (?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setString(1, theEmpleado.getNombre());
			myStmt.setString(2, theEmpleado.getAp());
			myStmt.setString(3, theEmpleado.getAm());
			myStmt.setString(4, theEmpleado.getCorreo());
			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public Empleado getEmpleados(String theEmpleadoId) throws Exception {

		Empleado theEmpleado = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int empleadoId;
		
		try {
			// convert student id to int
			empleadoId = Integer.parseInt(theEmpleadoId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to get selected student
			String sql = "select * from empleado where id=?";
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, empleadoId);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				String nombre = myRs.getString("nombre");
				String ap = myRs.getString("ap");
				String am = myRs.getString("am");
				String correo = myRs.getString("correo");
				
				// use the empleadoId during construction
				theEmpleado = new Empleado(empleadoId, nombre, ap, am, correo);
			}
			else {
				throw new Exception("Could not find employee id: " + empleadoId);
			}				
			
			return theEmpleado;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void updateEmpleados(Empleado theEmpleado) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update empleado "
						+ "set nombre=?, ap=?, am=?, correo=? "
						+ "where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, theEmpleado.getNombre());
			myStmt.setString(2, theEmpleado.getAp());
			myStmt.setString(3, theEmpleado.getAm());
			myStmt.setString(4, theEmpleado.getCorreo());
			myStmt.setInt(5, theEmpleado.getId());
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public void deleteEmpleados(String theEmpleadoId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert student id to int
			int empleadoId = Integer.parseInt(theEmpleadoId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to delete student
			String sql = "delete from empleado where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, empleadoId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}	
	}
}















