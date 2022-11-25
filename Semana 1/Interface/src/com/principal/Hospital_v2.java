package com.principal;

import java.util.*;

import javax.swing.JOptionPane;

import com.hospital.*;

public class Hospital_v2 {
	
	//Versión 2_ Ingreso de datos por el usuario dinámico con uso de JOptionPane
	
	//Creación de una lista de objetos de tipo empleado
	static List<Empleados> ListaEmpleados = new ArrayList<>();
	
	public static void main(String[] args) {
		
		//metodo de menu
		Menu();
		
		//Impresión de cada dato de la lista a través de un for-each
		System.out.println("-----------------------------------------");
		System.out.println("NÓMINA DE UN HOSPITAL");
		System.out.println("-----------------------------------------");
		
		for(Empleados empleados : ListaEmpleados) {
			System.out.println("Profesión: "+empleados.getClass().getSimpleName());
			System.out.println("Nombre: "+empleados.getNombre());
			System.out.println("\n"+empleados.toString());
			System.out.println("\nEl sueldo del empleado es: "+empleados.calcular_sueldoQuincenal());
			System.out.println("-----------------------------------------");
			
		}
	}	
	
	public static void Menu(){
		/*Método con función de ser un menú el cual pide el número de empleados a ingresar
		* así como que tipo de empleado desea ingresar, al igual como sus datos correspondientes
		*/
		String sms_empleados = "NÓMINA DE UN HOSPITAL";
		sms_empleados+= "\n¿Cuantos empleados desea capturar?";
		int num_empleados = Integer.parseInt(JOptionPane.showInputDialog(null, sms_empleados));
		
		while(num_empleados > 0){
			System.out.println("antes: "+num_empleados);
			String sms= "Seleccione el tipo de empleado que desea agregar";
			sms+= "\n1. Doctor";
			sms+= "\n2. Enfermero";
			sms+= "\n3. Camillero";
			sms+= "\n4. Secretario";
			
			int op = Integer.parseInt(JOptionPane.showInputDialog(null, sms));
			
			String especialidad="",nombre="";
			double sueldo_mensual=0;
			int dias_laborados=0;
			
			switch(op){
				case 1: 
					especialidad = JOptionPane.showInputDialog(null,"Ingrese la especialidad");
					nombre = JOptionPane.showInputDialog(null,"Ingrese el nombre");
					sueldo_mensual = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el sueldo mensual del Doctor "+nombre));
					dias_laborados = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese los días laborados hasta la fecha de hoy del Doctor "+nombre));
					
					ListaEmpleados.add(new Doctor(nombre, sueldo_mensual, dias_laborados, especialidad));
					break;
				case 2: 
					especialidad = JOptionPane.showInputDialog(null,"Ingrese la especialidad");
					nombre = JOptionPane.showInputDialog(null,"Ingrese el nombre");
					sueldo_mensual = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el sueldo mensual del Enfermero "+nombre));
					dias_laborados = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese los días laborados hasta la fecha de hoy del Enfermero "+nombre));
					
					ListaEmpleados.add(new Enfermera(nombre, sueldo_mensual, dias_laborados, especialidad));
					break;
				case 3: 
					especialidad = JOptionPane.showInputDialog(null,"Ingrese la especialidad");
					nombre = JOptionPane.showInputDialog(null,"Ingrese el nombre");
					sueldo_mensual = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el sueldo mensual del Camillero "+nombre));
					dias_laborados = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese los días laborados hasta la fecha de hoy del Camillero "+nombre));
					
					ListaEmpleados.add(new Camillero(nombre, sueldo_mensual, dias_laborados, especialidad));
					break;
				case 4: 
					especialidad = JOptionPane.showInputDialog(null,"Ingrese la especialidad");
					nombre = JOptionPane.showInputDialog(null,"Ingrese el nombre");
					sueldo_mensual = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el sueldo mensual del Secretario "+nombre));
					dias_laborados = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese los días laborados hasta la fecha de hoy del Secretario "+nombre));
					
					ListaEmpleados.add(new Secretario(nombre, sueldo_mensual, dias_laborados, especialidad));
					break;
				default: 
					JOptionPane.showMessageDialog(null, "Abortando...");
					num_empleados=0;
					break;
			}
			System.out.println("medio: "+num_empleados);
			num_empleados--;
			System.out.println("final: "+num_empleados);
		}	
	}
}