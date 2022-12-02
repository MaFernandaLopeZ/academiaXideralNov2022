package com.idd.v2;

public class Principal {
	public static void main(String[] args){
		Empleado empleado = new Empleado("Fernanda López", 12000.0, 10);
		Inyector.inyectarEmpleado(empleado);
		empleado.calcular_sueldoQuincenal();
	}
}
