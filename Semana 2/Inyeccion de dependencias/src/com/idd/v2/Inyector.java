package com.idd.v2;

public class Inyector {
	//toma la responsabilidad de inyectarle al empleado 
	//el tipo de empleado
		static void inyectarEmpleado(Empleado empleado){
			empleado.doctor = new Doctor("Oftalmologo");
			empleado.doctor = new Enfermero("Pediatria");
		}
}
