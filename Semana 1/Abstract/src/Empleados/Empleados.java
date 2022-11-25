package Empleados;

public abstract class Empleados {
	
	protected String nombre;
	protected double sueldo_mensual;
	protected int dias_laborados;
	protected String especialidad;
	//protected String rol;
	
	public Empleados(String nombre, double sueldo_mensual, int dias_laborados,String especialidad) {	
		this.nombre = nombre;
		this.sueldo_mensual = sueldo_mensual;
		this.dias_laborados = dias_laborados;
		this.especialidad = especialidad;
		//this.rol = rol;
	}
	
	public abstract double calcular_sueldoQuincenal();
	
	public String toString() {
		return "Datos administrativos: \nEspecialidad:"+especialidad+"\nSueldo mensual: "+sueldo_mensual+"\nDias laborados: "+dias_laborados;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}*/
		
}
