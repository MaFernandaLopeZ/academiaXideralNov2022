package com.hospital;

public class Enfermera implements Empleados {
	
	protected String nombre;
	protected double sueldo_mensual;
	protected int dias_laborados;
	protected String especialidad;
	
	public Enfermera(String nombre, double sueldo_mensual, int dias_laborados, String especialidad) {
		this.nombre = nombre;
		this.sueldo_mensual = sueldo_mensual;
		this.dias_laborados = dias_laborados;
		this.especialidad = especialidad;
	}
	
	@Override
	public double calcular_sueldoQuincenal(){
		return (sueldo_mensual/30)*dias_laborados;
	}
	
	public String toString() {
		return "Datos administrativos: \nEspecialidad:"+especialidad+"\nSueldo mensual: "+sueldo_mensual+"\nDias laborados: "+dias_laborados;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
