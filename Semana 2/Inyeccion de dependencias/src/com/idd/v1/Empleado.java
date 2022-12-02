package com.idd.v1;

public class Empleado {
	
	//Alto acoplamiento
	
	private String nombre;
	private double sueldo_mensual;
	private int dias_laborados;
	
	Doctor doctor;
	
	public Empleado(String nombre, double sueldo_mensual, int dias_laborados) {
		this.nombre = nombre;
		this.sueldo_mensual = sueldo_mensual;
		this.dias_laborados = dias_laborados;
	}
	
	public void calcular_sueldoQuincenal(){
		System.out.println("Datos administrativos: \nNombre: "+nombre+"\nSueldo mensual: "+sueldo_mensual+"\nDias laborados: "+dias_laborados);
		System.out.println("\nSueldo quincenal: "+(sueldo_mensual/30)*dias_laborados);
		doctor = new Doctor("Oftalmologo");
		doctor.especialidad();
	}
	
	public String toString() {
		return "Datos administrativos: \nSueldo mensual: "+sueldo_mensual+"\nDias laborados: "+dias_laborados;
	}
}
