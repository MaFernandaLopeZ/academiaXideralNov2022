package Empleados;

public class Enfermera extends Empleados {
	
	static String rol = "Enfermera";
	
	public Enfermera(String nombre, double sueldo_mensual, int dias_laborados, String especialidad) {
		super(nombre, sueldo_mensual, dias_laborados, especialidad, rol);
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
