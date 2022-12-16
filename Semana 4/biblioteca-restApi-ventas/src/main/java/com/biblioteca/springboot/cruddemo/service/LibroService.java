package com.biblioteca.springboot.cruddemo.service;

import java.util.List;

import com.biblioteca.springboot.cruddemo.entity.Libro;

public interface LibroService {

	public List<Libro> findAll();
	
	public Libro findById(int theId);
	
	public void save(Libro theLibro);
	
	public void deleteById(int theId);
	
}
