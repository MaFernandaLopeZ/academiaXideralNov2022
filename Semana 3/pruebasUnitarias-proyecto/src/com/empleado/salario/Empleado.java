package com.empleado.salario;

public class Empleado implements EmpleadoIn{
	
	String nombre;
	String ap;
	String especialidad;
	double salario_mensual;
	int dias_trabajados;
	
	public Empleado(String nombre, String ap, String especialidad, double salario_mensual, int dias_trabajados) {
		this.nombre = nombre;
		this.ap = ap;
		this.especialidad = especialidad;
		this.salario_mensual = salario_mensual;
		this.dias_trabajados = dias_trabajados;
	}
	
	@Override
	public double pago_quincenal() {
		return (salario_mensual/30) * dias_trabajados;
	}
}
