package Empleados;

public class Doctor extends Empleados {

	public Doctor(String nombre, double sueldo_mensual, int dias_laborados) {
	//public Doctor(String nombre, int horas, double sueldo_mensual, int dias_laborados) {
		//super(nombre, horas, sueldo_mensual, dias_laborados);
		super(nombre, sueldo_mensual, dias_laborados);
	}
	
	@Override
	public double calcular_sueldoQuincenal(){
		return (sueldo_mensual/30)*dias_laborados;
	}
	
	@Override
	public String toString() {
		return "Datos empleado: \nNombre:"+nombre+"\nRol: Doctor \nSueldo mensual: "+sueldo_mensual+"\nDias laborados: "+dias_laborados;
	}
	
}
