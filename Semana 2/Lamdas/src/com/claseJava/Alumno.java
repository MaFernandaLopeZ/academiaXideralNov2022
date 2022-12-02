package com.claseJava;

public class Alumno {
	
	private String nombre;
	private int edad;
	private double calif;
	
	public Alumno(String nombre, int edad, double calif) {
		this.nombre = nombre;
		this.edad = edad;
		this.calif = calif;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getCalif() {
		return calif;
	}
	public void setCalif(double calif) {
		this.calif = calif;
	}
	
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", edad=" + edad + ", calif=" + calif + "]";
	}
	
}