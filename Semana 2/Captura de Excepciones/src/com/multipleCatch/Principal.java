package com.multipleCatch;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Principal {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		List<String> calif_materias = new ArrayList<>();
		calif_materias.add("5");
		calif_materias.add("9");
		calif_materias.add("10");
		
		int suma = 0;
		
		for(String e :calif_materias){
			suma+= Integer.parseInt(e);
		}
		
		System.out.println(suma);
		
		double promedio = 0;

		try{
			int unidades = Integer.parseInt(scn.nextLine());
			promedio = suma / unidades;
		
		}catch (NumberFormatException | ArithmeticException e) {
			System.out.println(e);
		}
		
		System.out.println(promedio);
		
		Calificaciones alumno = new Alumno("Carlos", promedio, 9);
		
		if (alumno.aprovado())
            System.out.println("Aprovado");
        else
            System.out.println("Reprovado");
    }
}
