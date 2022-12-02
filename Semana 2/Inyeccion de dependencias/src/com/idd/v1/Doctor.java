package com.idd.v1;

public class Doctor {
	
	protected String especialidad;
	
	public Doctor(String especialidad) {
		this.especialidad = especialidad;
	}

	public void especialidad(){
		System.out.println("Especialidad: "+especialidad);
	}

}
