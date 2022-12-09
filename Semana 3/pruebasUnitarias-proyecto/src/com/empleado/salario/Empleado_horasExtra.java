package com.empleado.salario;

public class Empleado_horasExtra implements EmpleadoIn{
	
	String nombre;
	String ap;
	String especialidad;
	double salario_mensual;
	int dias_trabajados;
	int horas_extras;
	
	public Empleado_horasExtra(String nombre, String ap, String especialidad, double salario_mensual, int dias_trabajados,
			int horas_extras) {
		this.nombre = nombre;
		this.ap = ap;
		this.especialidad = especialidad;
		this.salario_mensual = salario_mensual;
		this.dias_trabajados = dias_trabajados;
		this.horas_extras = horas_extras;
	}

	@Override
	public double pago_quincenal() {
		double salario = salario_mensual/30;
		return (salario/8)* horas_extras ;
	}
}
