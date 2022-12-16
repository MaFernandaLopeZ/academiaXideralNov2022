package com.biblioteca.spring.model;

public class Libro {

	private int id;
	private String nombre;
	private String genero;	
	private String autor;
	private double precio;
	
	public Libro() {
	}

	public Libro(String nombre, String genero, String autor, double precio) {
		this.nombre = nombre;
		this.genero = genero;
		this.autor = autor;
		this.precio = precio;
	}
	
	public Libro(int id, String nombre, String genero, String autor, double precio) {
		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
		this.autor = autor;
		this.precio = precio;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", genero=" + genero + ", autor=" + autor + ", precio=" + precio + "]";
	}		
}











