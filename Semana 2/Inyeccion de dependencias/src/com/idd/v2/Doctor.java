package com.idd.v2;

public class Doctor implements Empleados {
	
	protected String especialidad;
	
	public Doctor(String especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public void especialidad(){
		System.out.println("Especialidad: "+especialidad);
	}

}
