package com.asincrono;

public class Principal {
	private Escuchador esc;
	
	public void a�adirEscuchador(Escuchador esc){
		this.esc = esc;
	}
	
	public void ejecutar(){
		new Thread(new Runnable(){
			public void run(){
				System.out.println("Corriendo proceso asincrono");
				if(esc != null)
					esc.escuchador();
			}
		}).start();
		
	}
	
	public static void main(String[] args){
		Principal b = new Principal();
		Escuchador esc = new Asincrono();
		b.a�adirEscuchador(esc);
		b.ejecutar();
	}
}
