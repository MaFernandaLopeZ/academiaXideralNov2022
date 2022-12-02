package com.Exceptions.checked;

import java.io.FileInputStream; 
import java.io.FileNotFoundException;

public class FileNotFoundException2 {

	public static void main(String[] args) {
		try
	      {
	         FileInputStream fileInputStream = new FileInputStream("test.txt");
	      } catch (FileNotFoundException e)
	      {
	         e.printStackTrace();
	      }
	}
}