package Empleados;

public class Enfermera extends Empleados {
	
	/*public Enfermera(String nombre, int horas, double sueldo, int dias_laborados) {
		super(nombre, horas, sueldo, dias_laborados);
	}
	*/
	public Enfermera(String nombre, double sueldo_mensual, int dias_laborados) {
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
		return "Datos empleado: \nNombre:"+nombre+"\nRol: Enfermera \nSueldo mensual: "+sueldo_mensual+"\nDias laborados: "+dias_laborados;
	}
	
}
