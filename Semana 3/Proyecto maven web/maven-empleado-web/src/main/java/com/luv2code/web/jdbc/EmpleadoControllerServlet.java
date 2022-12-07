package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/EmpleadoControllerServlet")
public class EmpleadoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmpleadoDbUtil empleadoDbUtil;
	
	@Resource(name="jdbc/hospital") //SE COMENTO PARA HACER USO DE JNDI
	private DataSource dataSource;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		// create our student db util ... and pass in the conn pool / datasource
		try {
			//https://www.digitalocean.com/community/tutorials/tomcat-datasource-jndi-example-java
			//Context ctx = new InitialContext(); //USO DE JNDI
			//dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/javatechie"); //USO DE JNDI
			//System.out.println("Demo con JNDI, Datasource: "+dataSource);
			empleadoDbUtil = new EmpleadoDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
						
			// if the command is missing, then default to listing empleados
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listEmpleados(request, response);
				break;
				
			case "ADD":
				addEmpleados(request, response);
				break;
				
			case "LOAD":
				loadEmpleados(request, response);
				break;
				
			case "UPDATE":
				updateEmpleados(request, response);
				break;
			
			case "DELETE":
				deleteEmpleados(request, response);
				break;
				
			default:
				listEmpleados(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deleteEmpleados(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student id from form data
		String theEmpleadoId = request.getParameter("empleadoId");
		
		// delete student from database
		empleadoDbUtil.deleteEmpleados(theEmpleadoId);
		
		// send them back to "list empleados" page
		listEmpleados(request, response);
	}

	private void updateEmpleados(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student info from form data
		int id = Integer.parseInt(request.getParameter("empleadoId"));
		String nombre = request.getParameter("nombre");
		String ap = request.getParameter("ap");
		String am = request.getParameter("am");
		String correo = request.getParameter("correo");
		
		// create a new student object
		Empleado theEmpleado = new Empleado(id, nombre, ap, am, correo);
		
		// perform update on database
		empleadoDbUtil.updateEmpleados(theEmpleado);
		
		// send them back to the "list empleados" page
		listEmpleados(request, response);
		
	}

	private void loadEmpleados(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// read student id from form data
		String theEmpleadoId = request.getParameter("empleadoId");
		
		// get student from database (db util)
		Empleado theEmpleado = empleadoDbUtil.getEmpleados(theEmpleadoId);
		
		// place student in the request attribute
		request.setAttribute("THE_EMPLEADO", theEmpleado);
		
		// send to jsp page: update-student-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-empleados-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addEmpleados(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read student info from form data
		String nombre = request.getParameter("nombre");
		String ap = request.getParameter("ap");
		String am = request.getParameter("am");
		String correo = request.getParameter("correo");
		
		// create a new student object
		Empleado theEmpleado = new Empleado(nombre, ap, am, correo);
		
		// add the student to the database
		empleadoDbUtil.addEmpleados(theEmpleado);
				
		// send back to main page (the student list)
		listEmpleados(request, response);
	}

	private void listEmpleados(
			HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// get empleados from db util
		List<Empleado> empleados = empleadoDbUtil.getEmpleados();
		
		for (Empleado s:empleados) {
			System.out.println(s);
		}
		
		//empleados.add(new Empleado(999, "nombre", "ap", "am", "correo@gmail.com"));
		// add empleados to the request
		request.setAttribute("LISTA_EMPLEADOS", empleados);
		
				
		// send to JSP page (view)
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-empleados.jsp");
		dispatcher.forward(request, response);
	}

}













