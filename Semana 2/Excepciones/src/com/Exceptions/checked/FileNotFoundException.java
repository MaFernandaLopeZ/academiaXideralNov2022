package com.Exceptions.checked;

import java.io.FileInputStream;

public class FileNotFoundException {
	
	public static void main(String[] args) {
		FileInputStream fileInputStream = new FileInputStream("test.txt");
	}
}