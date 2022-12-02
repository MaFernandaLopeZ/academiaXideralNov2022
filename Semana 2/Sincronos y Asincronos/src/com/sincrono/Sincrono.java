package com.sincrono;

public class Sincrono implements Escuchador{
	
	@Override
	public void escuchador(){
		System.out.println("Ejecutado despues de llamar al proceso sincrono");
	}
}
