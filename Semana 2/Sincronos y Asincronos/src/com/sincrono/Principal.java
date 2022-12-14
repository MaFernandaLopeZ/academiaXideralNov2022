package com.sincrono;

public class Principal {
	private Escuchador esc;

	public void aņadirEscuchador(Escuchador esc) {
		this.esc = esc;
	}

	public void ejecutar() {
		System.out.println("Ejecutado antes de llamar al proceso sincrono");
		if (esc != null)
			esc.escuchador();

	}

	public static void main(String[] args) {
		Principal b = new Principal();
		Escuchador esc = new Sincrono();
		b.aņadirEscuchador(esc);
		b.ejecutar();
	}
}

