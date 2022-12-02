package com.Exceptions.unchecked;

public class NullPointerExecption {

	public static void main(String[] args) {
		String nombre = null;
		try {
			System.out.println(nombre.length());
		} catch (NullPointerException ne) {
			System.out.println("NullPointerException has occured!!");
		}
	}
}
