package Empleados;

public abstract class Empleados {
	
	protected String nombre;
	protected double sueldo_mensual;
	protected int dias_laborados;
	
	public Empleados(String nombre, double sueldo_mensual, int dias_laborados) {	
		this.nombre = nombre;
		this.sueldo_mensual = sueldo_mensual;
		this.dias_laborados = dias_laborados;
	}
	
	public abstract double calcular_sueldoQuincenal();
	
	public String toString() {
		return "Datos empleado: \nNombre:"+nombre+"\nRol: Rol \nSueldo mensual: "+sueldo_mensual+"\nDias laborados: "+dias_laborados;
	}
	
}
