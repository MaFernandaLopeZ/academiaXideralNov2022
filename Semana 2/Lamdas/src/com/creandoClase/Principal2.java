package com.creandoClase;

import java.util.ArrayList;
import java.util.List;

public class Principal2 {

	public static void main(String[] args) {
		
		List<String> listaAlumnos = new ArrayList<>();
		listaAlumnos.add("Fernanda Lopez");
		listaAlumnos.add("Daniel Lopez");
		listaAlumnos.add("Esmeralda Pimentel");
		listaAlumnos.add("Liz Paz");
		
		Predicado p = z -> z.length() > 15;
		
		System.out.println("\n**** Alumnos que más de 15 letras en su nombre ***");
		for(String nombre: listaAlumnos){
			boolean r = p.probar(nombre);
			if(r)
				System.out.println(nombre);
		}
		
		p = z -> z.contains("z");
		
		System.out.println("\n**** Alumnos que tienen una z en su nombre ***");
		for(String nombre: listaAlumnos){
			boolean r = p.probar(nombre);
			if(r)
				System.out.println(nombre);
		}
		
		p = z -> z.contains("i") && z.length() < 10;
		
		System.out.println("\n**** Alumnos que tienen una i en su nombre y tienen longitud de su nombre menos a 10 ***");
		for(String nombre: listaAlumnos){
			boolean r = p.probar(nombre);
			if(r)
				System.out.println(nombre);
		}
		
	}

}
