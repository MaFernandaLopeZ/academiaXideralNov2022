package com.primitivos;

public class Primitivo {

	public static void main(String[] args) {
		
		// create a final variable
		final String CURP = "LOZF000121MVZPRRA4";
		
		// try to change the final variable
		CURP = "LOZF000121MVZPRRA6";
		System.out.println("CURP: " + CURP);
	}
}
