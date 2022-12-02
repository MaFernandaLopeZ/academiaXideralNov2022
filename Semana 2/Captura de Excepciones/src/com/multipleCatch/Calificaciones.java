package com.multipleCatch;

public abstract class Calificaciones {
	
	protected String nombre;
    protected double promedio;

    public Calificaciones(String nombre, double promedio) {
        this.nombre = nombre;
        this.promedio = promedio;
    }

    public String toString() {
		return "Nombre:" + nombre + "\nPromedio:" + promedio ;
    }

    public boolean aprovado() {
        if (promedio >= 7)
            return true;
        else
            return false;
    }
}
