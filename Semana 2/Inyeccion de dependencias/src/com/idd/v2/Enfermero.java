package com.idd.v2;

public class Enfermero implements Empleados {
	
	protected String especialidad;
	
	public Enfermero(String especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public void especialidad(){
		System.out.println("Especialidad: "+especialidad);
	}

}
