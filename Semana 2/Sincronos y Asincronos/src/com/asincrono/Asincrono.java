package com.asincrono;

public class Asincrono implements Escuchador{
	
	@Override
	public void escuchador(){
		System.out.println("Ejecutado despues de llamar al metodo asincrono");
	}
}
