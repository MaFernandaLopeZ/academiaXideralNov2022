package com.claseJava;

import java.util.*;

public class Principal {

	public static void main(String[] args) {

		List<Alumno> listaAlumnos = new ArrayList<>();
		listaAlumnos.add(new Alumno("Fernanda Lopez",22,9.5));
		listaAlumnos.add(new Alumno("Daniel Lopez",20, 9.0));
		listaAlumnos.add(new Alumno("Esmeralda Pimentel",19,7.5));
		listaAlumnos.add(new Alumno("Angeles Paz",21, 8.0));
		
		System.out.println("\n----- Alumnos cuya calificación sea aprovatoria ----------");		
		
		mostrarAlumno(listaAlumnos,emp -> emp.getCalif() > 8);
		
		System.out.println("\n----- Alumnos cuya calificación sea aprovatoria y tengan menos de 20 años ----------");		
		
		mostrarAlumno(listaAlumnos,emp -> emp.getEdad() <= 20 && emp.getCalif()>8);
		
		System.out.println("\n----- Mostrar los primeros 2 alumnos de la lista ----------");
		
		listaAlumnos.stream().limit(2).forEach(a -> System.out.println(a));
	
	}
	
	static void mostrarAlumno(List<Alumno> lista, 
			Predicado<Alumno> p ) {

		for(Alumno e :lista) {
			if (p.probar(e)) //EJECUTA LA LAMBDA
				System.out.println(e);
		}
		
	}

}
