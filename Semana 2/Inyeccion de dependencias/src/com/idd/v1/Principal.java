package com.idd.v1;

public class Principal {
	public static void main(String[] args){
		Empleado empleado = new Empleado("Fernanda López", 12000.0, 10);
		empleado.calcular_sueldoQuincenal();
	}
}
