package Principal;

import java.util.*;

import Empleados.*;

public class Hospital {
	public static void main(String[] args) {
		List<Empleados> ListaEmpleados = new ArrayList<>();
		ListaEmpleados.add(new Doctor("Fernanda", 12000.0, 10));
		ListaEmpleados.add(new Enfermera("Fernanda2",25000.0, 15));
		ListaEmpleados.add(new Doctor("Fernanda3",35000.0, 13));
	
		
		for(Empleados empleados : ListaEmpleados) {
			System.out.println(empleados.toString());
			System.out.println("\nEl sueldo del empleado es: "+empleados.calcular_sueldoQuincenal());
			System.out.println("-----------------------------------------");
		}
	}
}
