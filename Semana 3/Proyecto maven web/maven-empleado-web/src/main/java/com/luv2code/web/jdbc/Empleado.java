package com.luv2code.web.jdbc;

public class Empleado {

	private int id;
	private String nombre;
	private String ap;
	private String am;
	private String correo;

	public Empleado(String nombre, String ap, String am, String correo) {
		this.nombre = nombre;
		this.ap = ap;
		this.am = am;
		this.correo = correo;
	}

	public Empleado(int id, String nombre, String ap, String am, String correo) {
		this.id = id;
		this.nombre = nombre;
		this.ap = ap;
		this.am = am;
		this.correo = correo;
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

	public String getAp() {
		return ap;
	}

	public void setAp(String ap) {
		this.ap = ap;
	}

	public String getAm() {
		return am;
	}

	public void setAm(String am) {
		this.am = am;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", Nombre=" + nombre + ", Apellido paterno=" + ap + ", Apellido materno=" + am + ", Correo=" + correo + "]";
	}	
}
