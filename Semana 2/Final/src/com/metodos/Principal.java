package com.metodos;

import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		
		List<Calificaciones> alumnos = new ArrayList<>();
		
		//Llenado de la lista con objetos
		alumnos.add(new Alumno("Carlos", 8.5, 9));
		alumnos.add(new Alumno("Fernanda", 9.5, 9));
		alumnos.add(new Alumno("Angel", 6, 9));
		
		alumnos.forEach(x -> {
			System.out.println(x);
			if (x.aprovado())
	            System.out.println("Aprovado");
	        else
	            System.out.println("Reprovado");
			System.out.println("-----------------------------------------");
		});
    }
}
