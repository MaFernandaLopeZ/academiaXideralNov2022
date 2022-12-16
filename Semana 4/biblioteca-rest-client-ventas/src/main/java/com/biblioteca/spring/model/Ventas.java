package com.biblioteca.spring.model;

public class Ventas {

	private int id;
	private String fecha;
	private int cantidad;
	private double total;
	
	public Ventas() {
	}

	public Ventas(String fecha, int cantidad, double total) {
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.total = total;
	}
	
	public Ventas(int id, String fecha, int cantidad, double total) {
		this.id = id;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Ventas [id=" + id + ", fecha=" + fecha + ", cantidad=" + cantidad + ", total=" + total + "]";
	}		
}











