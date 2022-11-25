package Empleados;

public class Secretario extends Empleados {

	public Secretario(String nombre, double sueldo_mensual, int dias_laborados, String especialidad) {
		super(nombre, sueldo_mensual, dias_laborados, especialidad);
	}
	
	@Override
	public double calcular_sueldoQuincenal(){
		return (sueldo_mensual/30)*dias_laborados;
	}
	
	@Override
	public String toString() {
		return "Datos administrativos: \nEspecialidad:"+especialidad+"\nSueldo mensual: "+sueldo_mensual+"\nDias laborados: "+dias_laborados;
	}	
	
}
