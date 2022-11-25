package Principal;

import java.util.*;

import Empleados.*;

public class Hospital {
	
	public static void main(String[] args) {
		List<Empleados> ListaEmpleados = new ArrayList<>();
		ListaEmpleados.add(new Doctor("Fernanda", 12000.0, 10, "Oftalmologo"));
		ListaEmpleados.add(new Enfermera("Fernanda2",25000.0, 15, "Quirúrgica"));
		ListaEmpleados.add(new Doctor("Fernanda3",35000.0, 13, "Cirujano"));
		
		System.out.println("-----------------------------------------");
		System.out.println("NÓMINA DE EMPLEADO DE UN HOSPITAL");
		System.out.println("-----------------------------------------");
		
		for(Empleados empleados : ListaEmpleados) {
			//System.out.println("Nombre de "+empleados.getRol()+" : "+empleados.getNombre());
			System.out.println("Profesion: "+empleados.getRol());
			System.out.println("Nombre: "+empleados.getNombre());
			System.out.println("\n"+empleados.toString());
			System.out.println("\nEl sueldo del empleado es: "+empleados.calcular_sueldoQuincenal());
			System.out.println("-----------------------------------------");
		}
	}
	
}
