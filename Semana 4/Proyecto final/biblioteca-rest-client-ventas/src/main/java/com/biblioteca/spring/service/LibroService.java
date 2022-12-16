package com.biblioteca.spring.service;

import java.util.List;

import com.biblioteca.spring.model.Libro;

public interface LibroService {

	public List<Libro> getLibros();

	public void saveLibro(Libro theLibro);

	public Libro getLibro(int theId);

	public void deleteLibro(int theId);
	
}
