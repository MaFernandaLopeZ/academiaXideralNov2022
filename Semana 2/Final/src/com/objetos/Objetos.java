package com.objetos;

public class Objetos {
	// Final keyword for objects
	// difference between final and immutability

	public static void main(String[] args) {
		
		final StringBuilder sb = new StringBuilder("Maria");

		// Although the reference variable named sb is final, we can modify the object at any time.
		sb.append(" Fernanda Lopez");

		System.out.println(sb);

		/*However, if we want to reassign it, we will have an error at compile time, since when an object
		reference variable, it cannot change reference, that is, it cannot point to another*/
		sb = new StringBuilder("Maria de Lourdes Lopez");

		System.out.println(sb);
	}
}
