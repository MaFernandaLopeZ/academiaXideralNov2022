package com.principal;

import java.util.*;

import com.hospital.*;

public class Hospital_v1 {
	
	//Versión 1_ Ingreso de datos directo
	
	public static void main(String[] args) {
		
		//Creación de una lista de objetos de tipo empleado
		List<Empleados> ListaEmpleados = new ArrayList<>();
		
		//Llenado de la lista con objetos
		ListaEmpleados.add(new Doctor("Fernanda López", 12000.0, 10, "Oftalmologo"));
		ListaEmpleados.add(new Enfermera("Julia",25000.0, 15, "Quirúrgica"));
		ListaEmpleados.add(new Camillero("Hector", 12000.0, 10, "Oftalmologo"));
		ListaEmpleados.add(new Secretario("Pedro",35000.0, 13, "Recursos humanos"));
		
		//Impresión de cada datos de la lista
		System.out.println("-----------------------------------------");
		System.out.println("NÓMINA DE UN HOSPITAL");
		System.out.println("-----------------------------------------");
		
		for(Empleados empleados : ListaEmpleados) {
			System.out.println("Profesión: "+empleados.getClass().getSimpleName());
			System.out.println("Nombre: "+empleados.getNombre());
			System.out.println(empleados.toString());
			System.out.println("\nEl sueldo del empleado es: "+empleados.calcular_sueldoQuincenal());
			System.out.println("-----------------------------------------");
		}
	}
}
