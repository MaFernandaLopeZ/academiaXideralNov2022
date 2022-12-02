package com.metodos;

public class Alumno extends Calificaciones{
	
	protected int semestre;

	public Alumno(String nombre, double promedio, int semestre) {
		super(nombre, promedio);
		this.semestre = semestre;
	}
	
	@Override
	public String toString() {
		return "Nombre:" + nombre +"\nSemestre: "+ semestre + "\nPromedio:" + promedio;
    }
	
	@Override
    public final boolean aprovado() {
        if (promedio >= 7)
            return true;
        else
            return false;
    }
	
}
